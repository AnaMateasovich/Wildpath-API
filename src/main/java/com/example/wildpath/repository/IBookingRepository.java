package com.example.wildpath.repository;

import com.example.wildpath.entity.Booking;
import com.example.wildpath.entity.BookingStatus;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IBookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUser(User user);
    boolean existsByUserAndTravelPackageAndStatus(User user, TravelPackage travelPackage, BookingStatus status);
    @Query("SELECT b.travelPackage.id FROM Booking b WHERE b.user.id = :userId")
    List<Long> findPackageIdsByUserId(@Param("userId") Long userId);

    Optional<Booking> findByConfirmationToken(String token);
}
