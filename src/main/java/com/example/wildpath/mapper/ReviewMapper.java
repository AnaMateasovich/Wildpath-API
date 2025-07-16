package com.example.wildpath.mapper;

import com.example.wildpath.dto.review.ReviewCreateDTO;
import com.example.wildpath.dto.review.ReviewResponseDTO;
import com.example.wildpath.entity.Review;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ReviewMapper {

    public Review toEntity(ReviewCreateDTO dto, User user, TravelPackage travelPackage) {
        Review review = new Review();
        review.setUser(user);
        review.setTravelPackage(travelPackage);
        review.setRating(dto.getStars());
        review.setComment(dto.getComment());
        review.setCreatedAt(LocalDateTime.now());
        return review;
    }

    public static ReviewResponseDTO toDTO(Review review) {
        ReviewResponseDTO dto = new ReviewResponseDTO();
        dto.setUserName(review.getUser().getName());
        dto.setStars(review.getRating());
        dto.setComment(review.getComment());
        dto.setCreatedAt(review.getCreatedAt());
        dto.setTravelPackageId(review.getTravelPackage().getId());
        return dto;
    }

    public List<ReviewResponseDTO> toDTOList(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewMapper::toDTO)
                .toList();
    }
}
