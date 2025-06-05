package com.example.wildpath.repository;

import com.example.wildpath.entity.PackageNoInclude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPackageNoIncludeRepository extends JpaRepository<PackageNoInclude,Long> {

    List<PackageNoInclude> findByAPackage_Id(Long packageId);
}
