package com.example.wildpath.repository;

import com.example.wildpath.entity.PackageItinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPackageItineraryRepository extends JpaRepository<PackageItinerary,Long> {

    List<PackageItinerary> findByAPackage_Id(Long packageId);

}
