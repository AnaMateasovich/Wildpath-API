package com.example.wildpath.repository;

import com.example.wildpath.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByIdIn(List<Long> ids);
}
