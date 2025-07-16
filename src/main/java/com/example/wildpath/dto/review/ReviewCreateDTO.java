package com.example.wildpath.dto.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateDTO {

    private int stars;
    private String comment;
    private Long travelPackageId;
}
