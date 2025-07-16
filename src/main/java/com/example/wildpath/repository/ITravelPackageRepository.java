package com.example.wildpath.repository;

import com.example.wildpath.dto.travelPackageDTOs.RequestPaginatedDTO;
import com.example.wildpath.entity.TravelPackage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITravelPackageRepository extends JpaRepository<TravelPackage, Long> {

    @Query("SELECT new com.example.wildpath.dto.travelPackageDTOs.RequestPaginatedDTO(t.id, t.name, t.category.id, t.place.id, t.duration, t.nights, t.description, t.locationAddress, t.pricePerPerson, t.discount ) FROM TravelPackage t")
    Page<RequestPaginatedDTO> findAllDTOs(Pageable pageable);

    @EntityGraph(attributePaths = {"images"})
    @Query("SELECT t FROM TravelPackage t ORDER BY function('RAND')")
    List<TravelPackage> findRandom10();

    @Query("SELECT new com.example.wildpath.dto.travelPackageDTOs.RequestPaginatedDTO(t.id, t.name, t.category.id, t.place.id, t.duration, t.nights, t.description, t.locationAddress, t.pricePerPerson, t.discount ) FROM TravelPackage t WHERE LOWER(t.locationAddress) LIKE LOWER (CONCAT('%', :locationAddress, '%'))")
    List<RequestPaginatedDTO> findByLocationAddress(@Param("locationAddress") String locationAddress);

    @Query("SELECT DISTINCT new com.example.wildpath.dto.travelPackageDTOs.RequestPaginatedDTO(t.id, t.name, t.category.id, t.place.id, t.duration, t.nights, t.description, t.locationAddress, t.pricePerPerson, t.discount ) " +
            "FROM TravelPackage t " +
            "JOIN t.datesAvailable d " +
            "WHERE (:categoryId IS NULL OR t.category.id = :categoryId) " +
            "AND (:location IS NULL OR LOWER(t.locationAddress) LIKE LOWER(CONCAT('%', :location, '%')))" +
            "AND (:startDate IS NULL OR d.date >= :startDate)" +
            "AND (:endDate IS NULL OR d.date <= :endDate)")
    List<RequestPaginatedDTO> searchFiltered(
            @Param("categoryId") Long categoryId,
            @Param("location") String location,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    @Query("SELECT DISTINCT t.locationAddress FROM TravelPackage t WHERE LOWER(t.locationAddress) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<String> findLocationSuggestions(@Param("query") String query);

    boolean existsByNameIgnoreCase(String name);

    List<TravelPackage> findByCategoryId(Long categoryId);

    List<TravelPackage> findByNameContainingIgnoreCase(String name);
}
