package com.example.wildpath.dto.travelPackageDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPaginatedDTO {

    private Long id;
    private String name;
    private Long categoryId;
    private Long placeId;
    private String duration;
    private Integer nights;
    private String description;
    private String locationAddress;
    private BigDecimal pricePerPerson;
    private String discount;
}
