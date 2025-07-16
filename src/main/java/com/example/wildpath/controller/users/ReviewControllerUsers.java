package com.example.wildpath.controller.users;

import com.example.wildpath.dto.review.ReviewCreateDTO;
import com.example.wildpath.dto.review.ReviewResponseDTO;
import com.example.wildpath.entity.User;
import com.example.wildpath.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/review")
public class ReviewControllerUsers {

    private final ReviewService reviewService;

    public ReviewControllerUsers(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewResponseDTO> createReview(@RequestBody ReviewCreateDTO dto, @AuthenticationPrincipal User user) {
        ReviewResponseDTO responseDTO = reviewService.createReview(dto, user);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/reviewed-packages")
    public ResponseEntity<List<Long>> getReviewedPackages(@AuthenticationPrincipal User user) {
        List<Long> reviewedPackageIds = reviewService.getReviewedPackageIdsByUser(user);
        return ResponseEntity.ok(reviewedPackageIds);
    }


}
