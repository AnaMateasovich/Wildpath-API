package com.example.wildpath.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDTO {

    private Long id;
    private Long packageId;
    private String packageName;
    private LocalDate date;
    private Integer quantityPeople;
    private String status;
    private LocalDateTime createdAt;
    private boolean hasReview;
}
