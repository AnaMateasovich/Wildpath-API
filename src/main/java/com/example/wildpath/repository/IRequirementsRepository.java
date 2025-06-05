package com.example.wildpath.repository;

import com.example.wildpath.entity.Requirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRequirementsRepository extends JpaRepository<Requirements, Long> {

    List<Requirements> findByAPackage_Id(Long packageId);

}
