package com.example.wildpath.service;

import com.example.wildpath.dto.UserUpdateDTO;
import com.example.wildpath.dto.booking.BookingRequestDTO;
import com.example.wildpath.dto.booking.BookingResponseDTO;
import com.example.wildpath.entity.*;
import com.example.wildpath.mapper.BookingMapper;
import com.example.wildpath.mapper.UserMapper;
import com.example.wildpath.repository.*;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final IBookingRepository bookingRepository;
    private final IReviewRepository reviewRepository;
    private final ITravelPackageRepository travelPackageRepository;
    private final IDateAvailableRepository dateAvailableRepository;
    private final IUserRepository userRepository;
    private final EmailService emailService;

    public BookingService(IBookingRepository bookingRepository, IReviewRepository reviewRepository,
                          ITravelPackageRepository travelPackageRepository,
                          IDateAvailableRepository dateAvailableRepository, IUserRepository userRepository, EmailService emailService) {
        this.bookingRepository = bookingRepository;
        this.reviewRepository = reviewRepository;
        this.travelPackageRepository = travelPackageRepository;
        this.dateAvailableRepository = dateAvailableRepository;
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public BookingResponseDTO createBooking(BookingRequestDTO dto, User user) {

        TravelPackage travelPackage = travelPackageRepository.findById(dto.getPackageId())
                .orElseThrow(() -> new RuntimeException("Package not found"));

        DateAvailable dateAvailable = dateAvailableRepository.findById(dto.getDateAvailableId())
                .orElseThrow(() -> new RuntimeException("Date available not found"));

        if(dateAvailable.getSpots() < dto.getQuantityPeople()) {
            throw new RuntimeException("There aren't enough spots available.");
        }

        if(dto.getUserInfo() != null) {
            UserUpdateDTO userUpdateDTO = dto.getUserInfo();
            UserMapper.updateUserFromDTO(user, userUpdateDTO);
            userRepository.save(user);
        }

        dateAvailable.setSpots(dateAvailable.getSpots() - dto.getQuantityPeople());
        dateAvailableRepository.save(dateAvailable);

        Booking booking = BookingMapper.toEntity(dto, travelPackage, dateAvailable, user);
        Booking saved = bookingRepository.save(booking);

        emailService.sendConfirmationReserve(
                saved.getUser().getEmail(),
                saved.getTravelPackage().getName(),
                saved.getCreatedAt(),
                saved.getDateAvailable().getDate().toString(),
                saved.getTravelPackage().getEnterprise().getPhone(),
                saved.getConfirmationToken()
        );

        return BookingMapper.toDTO(saved, reviewRepository);
    }

//    public BookingResponseDTO enableBooking()

    public List<Long> getBookingsPackageIdsByUser(User user) {
        return bookingRepository.findPackageIdsByUserId(user.getId());
    }

    public List<BookingResponseDTO> findByUser(User user) {
        List<Booking> bookings = bookingRepository.findByUser(user);
        return BookingMapper.toDTOList(bookings, reviewRepository);
    }

    public String confirmBookingByToken(String token) {
        Optional<Booking> optionalBooking = bookingRepository.findByConfirmationToken(token);
        if (optionalBooking.isEmpty()) {
            return "The link has already been used or is invalid.";
        }

        Booking booking = optionalBooking.get();

        if (booking.getStatus() == BookingStatus.CONFIRMED) {
            return "The reservation has already been confirmed previously.";
        }

        booking.setStatus(BookingStatus.CONFIRMED);


        booking.setConfirmationToken(null);

        bookingRepository.save(booking);

        return "¡Your booking has been confirmed!";
    }

}
