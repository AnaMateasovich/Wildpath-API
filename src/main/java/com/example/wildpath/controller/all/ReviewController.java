package com.example.wildpath.controller.all;

import com.example.wildpath.dto.review.ReviewResponseDTO;
import com.example.wildpath.dto.review.ReviewsListWithAverageDTO;
import com.example.wildpath.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/all/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/packages/{id}")
    public ResponseEntity<ReviewsListWithAverageDTO> getAllReviewsByPackageId(@PathVariable("id") Long packageId) {
        ReviewsListWithAverageDTO response = reviewService.getAllReviewsByPackageId(packageId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/packages/{id}/average-rating")
    public ResponseEntity<Double> getAverageRating(@PathVariable("id") Long packageId) {
        return ResponseEntity.ok(reviewService.getAverageRatingByPackageId(packageId));
    }


}
