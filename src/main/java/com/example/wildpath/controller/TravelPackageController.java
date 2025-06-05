package com.example.wildpath.controller;

import com.example.wildpath.dto.TravelPackageCategoryUpdateDTO;
import com.example.wildpath.dto.TravelPackageDTO;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.service.TravelPackageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/packages")
public class TravelPackageController {

    private final TravelPackageService packageService;

    public TravelPackageController(TravelPackageService packageService) {
        this.packageService = packageService;
    }


    @GetMapping
    public ResponseEntity<List<TravelPackageDTO>> getAllPackages() {
        List<TravelPackageDTO> packages = packageService.findAllDTOs();
        return ResponseEntity.ok(packages);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TravelPackageDTO> getPackageById(@PathVariable Long id) {
        return packageService.findDTOById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/check-name")
    public ResponseEntity<Boolean> checkName(@RequestParam String name) {
        boolean exists = packageService.nameExists(name);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<TravelPackageDTO>> getAllPageable(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TravelPackageDTO> packages = packageService.findAllPageable(pageable);

        return ResponseEntity.ok(packages);
    }

    @GetMapping("/random")
    public ResponseEntity<List<TravelPackageDTO>> get10Random() {
        List<TravelPackageDTO> randomPackages = packageService.find10Random();
        return ResponseEntity.ok(randomPackages);
    }
    /*
    @PutMapping("/{id}")
    public ResponseEntity<Package> updatePackage(@PathVariable Long id, @RequestBody Package updatePackage) {
        Package packageUpdated =
    }
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable Long id) {
        packageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/category")
    public ResponseEntity<?> updateCategory(@RequestBody TravelPackageCategoryUpdateDTO dto) {
        packageService.updateCategory(dto.getPackageId(), dto.getCategoryId());
        return ResponseEntity.ok("Successful category update");
    }

    @PutMapping("/{id}/pause")
    public TravelPackageDTO togglePackageStatus(@PathVariable Long id) {
        return packageService.togglePackageStatus(id);
    }
}
