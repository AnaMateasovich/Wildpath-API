package com.example.wildpath.repository;

import com.example.wildpath.entity.TravelPackage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITravelPackageRepository extends JpaRepository<TravelPackage, Long> {

    @EntityGraph(attributePaths = {"images"})
    Page<TravelPackage> findAll (Pageable pageable);

    @EntityGraph(attributePaths = {"images"})
    @Query("SELECT t FROM TravelPackage t ORDER BY function('RAND')") // para MySQL
    List<TravelPackage> findRandom10();

    boolean existsByName (String name);
}
