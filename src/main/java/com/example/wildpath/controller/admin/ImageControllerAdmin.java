package com.example.wildpath.controller.admin;

import com.example.wildpath.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("admin/packages/images")
public class ImageControllerAdmin {

    private final ImageService imageService;

    public ImageControllerAdmin(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<String> uploadPackageImage(@RequestParam("file") MultipartFile[] files, @RequestParam("packageId") Long packageId) {
        try {
            imageService.uploadImages(files, packageId);
            return  ResponseEntity.ok("Image uploaded and registered successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }

    }


    @DeleteMapping("/imageid/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
