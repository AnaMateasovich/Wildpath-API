package com.example.wildpath.repository;

import com.example.wildpath.entity.Review;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByTravelPackageId(Long travelPackageId);
    Review findByUserAndTravelPackageId(User user, Long travelPackageId);

    @Query("SELECT r.travelPackage.id FROM Review r WHERE r.user.id = :userId")
    List<Long> findPackageIdsByUserId(@Param("userId") Long userId);

    Review findByUserAndTravelPackage(User user, TravelPackage travelPackage);

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.travelPackage.id = :packageId")
    Double findAverageRatingByTravelPackageId(@Param("packageId") Long packageId);

    Integer countByTravelPackageId(Long packageId);

}
