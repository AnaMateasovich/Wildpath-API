package com.example.wildpath.dto.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDTO {
    private String userName;
    private int stars;
    private String comment;
    private LocalDateTime createdAt;
    private Long travelPackageId;

}
