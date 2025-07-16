package com.example.wildpath.controller.all;

import com.example.wildpath.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/all/booking")
public class BookingControllerAll {

    private final BookingService bookingService;

    public BookingControllerAll(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @GetMapping("/token-confirm")
    public ResponseEntity<String> confirmBooking(@RequestParam("token") String token) {
        String confirmed = bookingService.confirmBookingByToken(token);

        return ResponseEntity.ok(confirmed);
    }
}
