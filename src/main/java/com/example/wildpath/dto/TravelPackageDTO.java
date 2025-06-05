package com.example.wildpath.dto;

import com.example.wildpath.entity.Image;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class TravelPackageDTO {

    private Long id;

    private String name;
    private Long categoryId;
    private Long placeId;
    private String duration;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String locationAddress;
    private BigDecimal pricePerPerson;
    private String difficulty;
    private String description;
    private String discount;
    private String cancelPolicy;
    private Boolean isActive;
    private Long enterpriseId;
    private List<ImageDTO> images;
    private List<DateAvailableDTO> dateAvailable;
    private List<PackageIncludeDTO> packageIncludes;
    private List<RequirementsDTO> requirements;

    private String categoryName;
    private String placeName;
    private String enterpriseName;
}

