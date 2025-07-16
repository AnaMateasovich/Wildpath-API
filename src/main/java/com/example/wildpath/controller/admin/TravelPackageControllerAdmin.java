package com.example.wildpath.controller.admin;

import com.example.wildpath.dto.travelPackageDTOs.TravelPackageCategoryUpdateDTO;
import com.example.wildpath.dto.travelPackageDTOs.TravelPackageDTO;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.service.TravelPackageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/admin/packages")
public class TravelPackageControllerAdmin {

    private final TravelPackageService packageService;

    public TravelPackageControllerAdmin(TravelPackageService packageService) {
        this.packageService = packageService;
    }


    @PostMapping
    public ResponseEntity<?> createPackage(@RequestBody TravelPackageDTO dto) {
        Optional<TravelPackage> saved = packageService.createFromDTO(dto);

        if (saved.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of("id", saved.get().getId()));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear el paquete. Verifique los IDs enviados.");
        }
    }

    @GetMapping("/check-name")
    public ResponseEntity<Boolean> checkName(@RequestParam String name) {
        boolean exists = packageService.nameExists(name);
        return ResponseEntity.ok(exists);
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
