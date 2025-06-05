package com.example.wildpath.controller;

import com.example.wildpath.dto.ImageDTO;
import com.example.wildpath.entity.Image;
import com.example.wildpath.mapper.ImageMapper;
import com.example.wildpath.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/packages/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
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

    @GetMapping
    public  ResponseEntity<List<ImageDTO>> getAllImages() {
        List<Image> images = imageService.findAll();
        List<ImageDTO> imageDTOs = imageService.findAllImagesDTOs(images);
        return ResponseEntity.ok(imageDTOs);
    }

    @GetMapping("/imageid/{id}")
    public ResponseEntity<ImageDTO> getImageById(@PathVariable Long id) {
       ImageDTO image = imageService.findImageDTOById(id);
       return ResponseEntity.ok(image);
    }

    @GetMapping("/{packageId}")
    public ResponseEntity<List<ImageDTO>> getImageByPackageId(@PathVariable Long packageId) {
        List<ImageDTO> images = imageService.findImagesDTOsByPackageId(packageId);
        return ResponseEntity.ok(images);
    }

    @DeleteMapping("/imageid/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
