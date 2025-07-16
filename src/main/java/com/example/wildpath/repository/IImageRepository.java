package com.example.wildpath.repository;

import com.example.wildpath.dto.ImageDTO;
import com.example.wildpath.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByAPackage_Id(Long packageId);

    // Get all images from all packages ids
    @Query("SELECT i FROM Image i WHERE i.APackage.id IN :packageIds")
    List<Image> findImagesByPackageIds(@Param("packageIds") List<Long> packageIds);
}
