package com.example.wildpath.dto.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsListWithAverageDTO {

    private List<ReviewResponseDTO> reviews;
    private Double averageStars;
    private int totalReviews;
}
