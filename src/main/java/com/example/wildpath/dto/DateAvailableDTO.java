package com.example.wildpath.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DateAvailableDTO {

    private Long id;
    private Long packageId;
    private LocalDate date;
    private Integer capacity;
}
