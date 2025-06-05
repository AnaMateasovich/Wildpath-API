package com.example.wildpath.repository;

import com.example.wildpath.entity.PackageInclude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPackageIncludeRepository extends JpaRepository<PackageInclude, Long> {

    List<PackageInclude> findByAPackage_Id(Long packageId);
}
