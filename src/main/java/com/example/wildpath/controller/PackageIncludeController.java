package com.example.wildpath.controller;

import com.example.wildpath.dto.PackageIncludeDTO;
import com.example.wildpath.entity.PackageInclude;
import com.example.wildpath.service.PackageIncludesService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/includes")
public class PackageIncludeController {

    private final PackageIncludesService packageIncludesService;

    public PackageIncludeController(PackageIncludesService packageIncludesService) {
        this.packageIncludesService = packageIncludesService;
    }

    @PostMapping(value= "/bulk", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<PackageInclude>> createPackageInclude(@RequestPart("data") List<PackageIncludeDTO> requests, @RequestPart("icon") List<MultipartFile> iconFiles) {

        if(requests.size() != iconFiles.size()) {
            return ResponseEntity.badRequest().build();
        }

        List<PackageInclude> createdIncludes = packageIncludesService.createMultiplePackageInclude(requests, iconFiles);
        return ResponseEntity.ok(createdIncludes);
    }

    @GetMapping
    public  ResponseEntity<List<PackageInclude>> getAllPackageIncludes() {
        List<PackageInclude> packageIncludes = packageIncludesService.findAll();
        return ResponseEntity.ok(packageIncludes);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<PackageInclude>> getPackageIncludeById(@PathVariable Long id) {
        Optional<PackageInclude> foundPackageInclude = packageIncludesService.findById(id);
        return ResponseEntity.ok(foundPackageInclude);
    }

    @GetMapping("/package/{packageId}")
    public ResponseEntity<List<PackageInclude>> getPackageIncludeByPackageId(@PathVariable Long packageId) {
        List<PackageInclude> packageInclude = packageIncludesService.findByPackageId(packageId);
        return ResponseEntity.ok(packageInclude);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackageInclude(@PathVariable Long id) {
        packageIncludesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
