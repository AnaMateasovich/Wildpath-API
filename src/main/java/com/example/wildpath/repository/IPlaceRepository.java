package com.example.wildpath.repository;

import com.example.wildpath.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findByIdIn(List<Long> ids);
}
