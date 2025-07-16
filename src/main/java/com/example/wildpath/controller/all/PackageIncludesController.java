package com.example.wildpath.controller.all;

import com.example.wildpath.dto.PackageIncludeDTO;
import com.example.wildpath.entity.PackageInclude;
import com.example.wildpath.service.PackageIncludesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/all")
public class PackageIncludesController {

    private final PackageIncludesService packageIncludesService;

    public PackageIncludesController(PackageIncludesService packageIncludesService) {
        this.packageIncludesService = packageIncludesService;
    }

    @GetMapping("packageIncludes")
    public ResponseEntity<List<PackageInclude>> getAllPackageIncludes() {
        List<PackageInclude> packageIncludes = packageIncludesService.findAll();
        return ResponseEntity.ok(packageIncludes);
    }

    @GetMapping("/packageIncludes/id/{id}")
    public ResponseEntity<Optional<PackageInclude>> getPackageIncludeById(@PathVariable Long id) {
        Optional<PackageInclude> foundPackageInclude = packageIncludesService.findById(id);
        return ResponseEntity.ok(foundPackageInclude);
    }

    @GetMapping("/packageIncludes/package/{packageId}")
    public ResponseEntity<List<PackageIncludeDTO>> getPackageIncludeByPackageId(@PathVariable Long packageId) {
        List<PackageIncludeDTO> packageInclude = packageIncludesService.findByPackageId(packageId);
        return ResponseEntity.ok(packageInclude);
    }

}
