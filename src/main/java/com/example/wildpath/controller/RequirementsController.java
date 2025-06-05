package com.example.wildpath.controller;

import com.example.wildpath.dto.RequirementsDTO;
import com.example.wildpath.entity.Requirements;
import com.example.wildpath.service.RequirementsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requirements")
public class RequirementsController {

    private final RequirementsService requirementsService;

    public RequirementsController(RequirementsService requirementsService) {
        this.requirementsService = requirementsService;
    }

    @PostMapping
    public ResponseEntity<List<Requirements>> createRequirements(@RequestBody List<RequirementsDTO> requests) {
        List<Requirements> createdRequirements = requirementsService.createRequirement(requests);
        return ResponseEntity.ok(createdRequirements);
    }

    @GetMapping
    public  ResponseEntity<List<RequirementsDTO>> getAllRequirements() {
        List<RequirementsDTO> requirements = requirementsService.findAllDTOs();
        return ResponseEntity.ok(requirements);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Requirements>> getRequirementsById(@PathVariable Long id) {
        Optional<Requirements> foundRequirements = requirementsService.findById(id);
        return ResponseEntity.ok(foundRequirements);
    }

    @GetMapping("/package/{packageId}")
    public ResponseEntity<List<Requirements>> getRequirementsByPackageId(@PathVariable Long packageId) {
        List<Requirements> requirements = requirementsService.findByPackageId(packageId);
        return ResponseEntity.ok(requirements);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequirements(@PathVariable Long id) {
        requirementsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
