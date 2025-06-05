package com.example.wildpath.dto;

import lombok.Data;

@Data
public class PackageItineraryDTO {

    private Long id;
    private Long packageId;
    private String day;
    private String hour;
    private String description;
}
