package com.example.wildpath.dto.travelPackageDTOs;

import com.example.wildpath.dto.DateAvailableDTO;
import com.example.wildpath.dto.ImageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePaginatedDTO {
    private Long id;
    private String name;
    private String category;
    private String place;
    private String duration;
    private String description;
    private String locationAddress;
    private BigDecimal pricePerPerson;
    private String discount;
    private List<ImageDTO> images;
    private List<DateAvailableDTO> datesAvailable;
    private Double averageStars;
    private Integer totalReviews;

}
