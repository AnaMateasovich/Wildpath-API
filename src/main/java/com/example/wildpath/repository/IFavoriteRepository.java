package com.example.wildpath.repository;

import com.example.wildpath.entity.Favorite;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFavoriteRepository extends JpaRepository<Favorite, Long> {

    Optional<Favorite> findByUserAndTravelPackage(User user, TravelPackage travelPackage);
    List<Favorite> findAllByUser(User user);
    void deleteByUserAndTravelPackage(User user, TravelPackage travelPackage);
}
