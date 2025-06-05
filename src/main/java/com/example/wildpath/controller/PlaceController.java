package com.example.wildpath.controller;

import com.example.wildpath.dto.PlaceDTO;
import com.example.wildpath.entity.Enterprise;
import com.example.wildpath.entity.Place;
import com.example.wildpath.service.PlaceService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Place> createPlace(@RequestPart("data") PlaceDTO dto, @RequestPart("image")MultipartFile image) {
        Place createdPlace = placeService.createPlace(dto, image);
        return ResponseEntity.ok(createdPlace);
    }

    @GetMapping
    public ResponseEntity<List<Place>> getAllPlaces() {
        List<Place> enterpriseList = placeService.findAll();
        return ResponseEntity.ok(enterpriseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable Long id) {
        return placeService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        placeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
