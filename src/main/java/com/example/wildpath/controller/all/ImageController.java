package com.example.wildpath.controller.all;

import com.example.wildpath.dto.ImageDTO;
import com.example.wildpath.entity.Image;
import com.example.wildpath.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/all")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/images")
    public ResponseEntity<List<ImageDTO>> getAllImages() {
        List<Image> images = imageService.findAll();
        List<ImageDTO> imageDTOs = imageService.findAllImagesDTOs(images);
        return ResponseEntity.ok(imageDTOs);
    }

    @GetMapping("/images/imageid/{id}")
    public ResponseEntity<ImageDTO> getImageById(@PathVariable Long id) {
        ImageDTO image = imageService.findImageDTOById(id);
        return ResponseEntity.ok(image);
    }

    @GetMapping("/images/{packageId}")
    public ResponseEntity<List<ImageDTO>> getImageByPackageId(@PathVariable Long packageId) {
        List<ImageDTO> images = imageService.findImagesDTOsByPackageId(packageId);
        return ResponseEntity.ok(images);
    }


}
