package com.example.wildpath.repository;

import com.example.wildpath.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByAPackage_Id(Long packageId);

}
