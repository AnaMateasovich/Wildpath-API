package com.example.wildpath.controller.users;

import com.example.wildpath.dto.booking.BookingRequestDTO;
import com.example.wildpath.dto.booking.BookingResponseDTO;
import com.example.wildpath.entity.Booking;
import com.example.wildpath.entity.DateAvailable;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.entity.User;
import com.example.wildpath.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO dto, @AuthenticationPrincipal User user) {
        BookingResponseDTO response = bookingService.createBooking(dto, user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/history")
    public ResponseEntity<List<BookingResponseDTO>> findByUser(@AuthenticationPrincipal User user) {
        List<BookingResponseDTO> bookings = bookingService.findByUser(user);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/booking-packages")
    public ResponseEntity<List<Long>> getBookingPackages(@AuthenticationPrincipal User user) {
        List<Long> bookingPackageIds = bookingService.getBookingsPackageIdsByUser(user);
        return ResponseEntity.ok(bookingPackageIds);
    }


}
