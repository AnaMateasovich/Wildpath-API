package com.example.wildpath.controller.admin;

import com.example.wildpath.dto.CategoryDTO;
import com.example.wildpath.entity.Category;
import com.example.wildpath.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/categories")
public class CategoryControllerAdmin {

    private final CategoryService categoryService;

    public CategoryControllerAdmin(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    //(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Category> createCategory (@RequestPart("data") CategoryDTO dto, @RequestPart("image")MultipartFile image) {
        try {
        Category createdCategory = categoryService.createCategory(dto, image);
        return ResponseEntity.ok(createdCategory);
        } catch (Exception e) {
            e.printStackTrace(); // importante para ver el error real
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
