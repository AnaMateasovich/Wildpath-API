package com.example.wildpath.controller.admin;

import com.example.wildpath.dto.PackageNoIncludeDTO;
import com.example.wildpath.entity.PackageNoInclude;
import com.example.wildpath.service.PackageNoIncludesService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/noincludes")
public class PackageNoIncludeControllerAdmin {

    private final PackageNoIncludesService packageNoIncludesService;

    public PackageNoIncludeControllerAdmin(PackageNoIncludesService packageNoIncludesService) {
        this.packageNoIncludesService = packageNoIncludesService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PackageNoInclude> createPackageNoInclude(@RequestPart ("data") PackageNoIncludeDTO request, @RequestPart("icon")MultipartFile iconFile) {
        PackageNoInclude packageNoInclude = packageNoIncludesService.createPackageNoInclude(request, iconFile);
        return ResponseEntity.ok(packageNoInclude);
    }

    @GetMapping
    public  ResponseEntity<List<PackageNoInclude>> getAllPackageNoIncludes() {
        List<PackageNoInclude> packageNoIncludes = packageNoIncludesService.findAll();
        return ResponseEntity.ok(packageNoIncludes);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<PackageNoInclude>> getPackageNoIncludeById(@PathVariable Long id) {
        Optional<PackageNoInclude> foundPackageNoInclude = packageNoIncludesService.findById(id);
        return ResponseEntity.ok(foundPackageNoInclude);
    }

    @GetMapping("/package/{packageId}")
    public ResponseEntity<List<PackageNoInclude>> getPackageNoIncludeByPackageId(@PathVariable Long packageId) {
        List<PackageNoInclude> packageNoInclude = packageNoIncludesService.findByPackageId(packageId);
        return ResponseEntity.ok(packageNoInclude);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackageNoInclude(@PathVariable Long id) {
        packageNoIncludesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
