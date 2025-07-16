package com.example.wildpath.mapper;

import com.example.wildpath.dto.booking.BookingRequestDTO;
import com.example.wildpath.dto.booking.BookingResponseDTO;
import com.example.wildpath.entity.*;
import com.example.wildpath.repository.IReviewRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class BookingMapper {


    public static Booking toEntity(BookingRequestDTO dto, TravelPackage travelPackage, DateAvailable dateAvailable, User user) {
        Booking booking = new Booking();
        booking.setDate(dateAvailable.getDate());
        booking.setTravelPackage(travelPackage);
        booking.setDateAvailable(dateAvailable);
        booking.setConfirmationToken(UUID.randomUUID().toString());
        booking.setUser(user);
        booking.setQuantityPeople(dto.getQuantityPeople());
        booking.setStatus(BookingStatus.PENDING);
        booking.setCreatedAt(LocalDateTime.now());
        return booking;
    }

    public static BookingResponseDTO toDTO(Booking booking,  IReviewRepository reviewRepository) {
        BookingResponseDTO dto = new BookingResponseDTO();
        dto.setId(booking.getId());
        dto.setPackageId(booking.getTravelPackage().getId());
        dto.setPackageName(booking.getTravelPackage().getName());
        dto.setDate(booking.getDateAvailable().getDate());
        dto.setQuantityPeople(booking.getQuantityPeople());
        dto.setStatus(booking.getStatus().toString());
        dto.setCreatedAt(booking.getCreatedAt());

        boolean hasReview = reviewRepository.findByUserAndTravelPackageId(
                booking.getUser(), booking.getTravelPackage().getId()
        ) != null;
        dto.setHasReview(hasReview);

        return dto;
    }

    public static List<BookingResponseDTO> toDTOList(List<Booking> bookings, IReviewRepository reviewRepository) {
        return bookings.stream()
                .map(b -> toDTO(b, reviewRepository))
                .toList();
    }
}
