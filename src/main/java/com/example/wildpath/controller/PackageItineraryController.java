package com.example.wildpath.controller;

import com.example.wildpath.dto.PackageItineraryDTO;
import com.example.wildpath.entity.PackageItinerary;
import com.example.wildpath.service.PackageItineraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itinerary")
public class PackageItineraryController {

    private final PackageItineraryService packageItineraryService;

    public PackageItineraryController(PackageItineraryService packageItineraryService) {
        this.packageItineraryService = packageItineraryService;
    }

    @PostMapping
    public ResponseEntity<PackageItinerary> createPackageItinerary(@RequestBody PackageItineraryDTO request) {
        PackageItinerary packageItinerary = packageItineraryService.createPackageItinerary(request);
        return ResponseEntity.ok(packageItinerary);
    }

    @GetMapping
    public  ResponseEntity<List<PackageItinerary>> getAllPackageItineraries() {
        List<PackageItinerary> packageItineraries = packageItineraryService.findAll();
        return ResponseEntity.ok(packageItineraries);
    }

    @GetMapping("/id/{id}")
    public List<PackageItinerary> getPackageItineraryById(@PathVariable Long packageId) {
        return packageItineraryService.findByPackageId(packageId);
    }

    @GetMapping("/package/{packageId}")
    public ResponseEntity<List<PackageItinerary>> getPackageItineraryByPackageId(@PathVariable Long packageId) {
        List<PackageItinerary> packageItinerary = packageItineraryService.findByPackageId(packageId);
        return ResponseEntity.ok(packageItinerary);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackageItinerary(@PathVariable Long id) {
        packageItineraryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
