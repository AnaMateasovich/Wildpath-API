package com.example.wildpath.repository;

import com.example.wildpath.entity.DateAvailable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDateAvailableRepository extends JpaRepository<DateAvailable, Long> {

    List<DateAvailable> findByAPackage_Id(Long packageId);

    @Query("SELECT d FROM DateAvailable d WHERE d.APackage.id IN :packageIds")
    List<DateAvailable> findByPackageIds(@Param("packageIds") List<Long> packageIds);
}
