package com.example.wildpath.controller.admin;

import com.example.wildpath.dto.PlaceDTO;
import com.example.wildpath.entity.Place;
import com.example.wildpath.service.PlaceService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/places")
public class PlaceControllerAdmin {

    private final PlaceService placeService;

    public PlaceControllerAdmin(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Place> createPlace(@RequestPart("data") PlaceDTO dto, @RequestPart("image")MultipartFile image) {
        Place createdPlace = placeService.createPlace(dto, image);
        return ResponseEntity.ok(createdPlace);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        placeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
