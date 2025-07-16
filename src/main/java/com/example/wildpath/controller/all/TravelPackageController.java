package com.example.wildpath.controller.all;

import com.example.wildpath.dto.travelPackageDTOs.ResponsePaginatedDTO;
import com.example.wildpath.dto.travelPackageDTOs.TravelPackageDTO;
import com.example.wildpath.service.TravelPackageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/all")
public class TravelPackageController {

    private final TravelPackageService travelPackageService;

    public TravelPackageController(TravelPackageService travelPackageService) {
        this.travelPackageService = travelPackageService;
    }

    @GetMapping("/packages")
    public ResponseEntity<List<TravelPackageDTO>> getAllPackages() {
        List<TravelPackageDTO> packages = travelPackageService.findAllDTOs();
        return ResponseEntity.ok(packages);
    }


    @GetMapping("/packages/{id}")
    public ResponseEntity<TravelPackageDTO> getPackageById(@PathVariable Long id) {
        return travelPackageService.findDTOById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/packages/page")
    public ResponseEntity<Page<ResponsePaginatedDTO>> getAllPageable(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ResponsePaginatedDTO> packages = travelPackageService.findAllPageable(pageable);

        return ResponseEntity.ok(packages);
    }

    @GetMapping("/packages/random")
    public ResponseEntity<List<TravelPackageDTO>> get10Random() {
        List<TravelPackageDTO> randomPackages = travelPackageService.find10Random();
        return ResponseEntity.ok(randomPackages);
    }

    @GetMapping("/packages/search")
    public ResponseEntity<List<ResponsePaginatedDTO>> searchFiltered(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        List<ResponsePaginatedDTO> result = travelPackageService.searchFilteredPackages(categoryId, location, startDate, endDate);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/packages/category/{categoryId}")
    public ResponseEntity<List<TravelPackageDTO>> getByCategoryId(@PathVariable Long categoryId) {
        List<TravelPackageDTO> packages = travelPackageService.getPackagesByCategory(categoryId);
        return ResponseEntity.ok(packages);
    }

    @GetMapping("/packages/search-by-name")
    public ResponseEntity<List<TravelPackageDTO>> searchPackageByName(@RequestParam String name) {
        List<TravelPackageDTO> packages = travelPackageService.searchPackageByName(name);
        return ResponseEntity.ok(packages);
    }

    @GetMapping("/packages/locations-suggestions")
    public ResponseEntity<List<String>> getLocationSuggestions(@RequestParam("query") String query) {
        List<String> suggestions = travelPackageService.getLocationSuggestions(query);
        return ResponseEntity.ok(suggestions);
    }

}
