package com.example.wildpath.service;

import com.example.wildpath.dto.review.ReviewCreateDTO;
import com.example.wildpath.dto.review.ReviewResponseDTO;
import com.example.wildpath.dto.review.ReviewsListWithAverageDTO;
import com.example.wildpath.entity.*;
import com.example.wildpath.mapper.ReviewMapper;
import com.example.wildpath.repository.IBookingRepository;
import com.example.wildpath.repository.IReviewRepository;
import com.example.wildpath.repository.ITravelPackageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReviewService {

    private final ITravelPackageRepository travelPackageRepository;
    private final IReviewRepository reviewRepository;
    private final IBookingRepository bookingRepository;
    private final ReviewMapper reviewMapper;

    public ReviewService(ITravelPackageRepository travelPackageRepository, IReviewRepository reviewRepository, IBookingRepository bookingRepository, ReviewMapper reviewMapper) {
        this.travelPackageRepository = travelPackageRepository;
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.reviewMapper = reviewMapper;
    }


    public ReviewResponseDTO createReview(ReviewCreateDTO dto, User user) {

        Review reviewExists = reviewRepository.findByUserAndTravelPackageId(user, dto.getTravelPackageId());

        if (reviewExists != null) {
            throw new RuntimeException("You already left a review for this trip.");
        }

        if (dto.getStars() < 1 || dto.getStars() > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5 stars.");
        }

        TravelPackage travelPackage = travelPackageRepository.findById(dto.getTravelPackageId())
                .orElseThrow(() -> new RuntimeException("Travel package not found"));

        boolean hasConfirmedBooking = bookingRepository.existsByUserAndTravelPackageAndStatus(user, travelPackage, BookingStatus.CONFIRMED);

        if (!hasConfirmedBooking) {
            throw new RuntimeException("It is not possible to post a review if you have not made a reservation.");
        }

//         despues agregamos las validaciones de que pase la fecha que hizo la aventura
//        List<Booking> bookings = bookingRepository.findByUserAndTravelPackageAndStatus(user, travelPackage, BookingStatus.ENDED);
//
//        boolean travelEnded = bookings.stream()
//                .anyMatch(b -> b.getDate().isBefore(LocalDate.now()));
//
//        if(!travelEnded) {
//            throw new RuntimeException("You will be able to leave a review after the trip.");
//        }

        Review review = reviewMapper.toEntity(dto, user, travelPackage);
        reviewRepository.save(review);

        ReviewResponseDTO responseDTO = ReviewMapper.toDTO(review);
        return responseDTO;
    }

    public ReviewsListWithAverageDTO getAllReviewsByPackageId(Long packageId) {
        List<Review> reviews = reviewRepository.findByTravelPackageId(packageId);
        List<ReviewResponseDTO> reviewDTOs = reviewMapper.toDTOList(reviews);


        ReviewsListWithAverageDTO response = new ReviewsListWithAverageDTO();
        response.setReviews(reviewDTOs);
        response.setTotalReviews(reviewDTOs.size());

        if (!reviewDTOs.isEmpty()) {
            Double average = reviewRepository.findAverageRatingByTravelPackageId(packageId);
            response.setAverageStars(Math.round(average * 10.0) / 10.0); // redondea a 1 decimal
        } else {
            response.setAverageStars(0.0); // o podés usar null si querés indicar "sin reviews"
        }

        return response;
    }


    public List<Long> getReviewedPackageIdsByUser(User user) {
        return reviewRepository.findPackageIdsByUserId(user.getId());
    }

    public Double getAverageRatingByPackageId(Long packageId) {
        Double avg = reviewRepository.findAverageRatingByTravelPackageId(packageId);
        if (avg == null) return 0.0;

        return Math.round(avg * 10.0) / 10.0;
    }
}
