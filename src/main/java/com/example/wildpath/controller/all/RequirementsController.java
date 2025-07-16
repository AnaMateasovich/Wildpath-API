package com.example.wildpath.controller.all;

import com.example.wildpath.dto.RequirementsDTO;
import com.example.wildpath.entity.Requirements;
import com.example.wildpath.service.RequirementsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/all")
public class RequirementsController {

    private final RequirementsService requirementsService;

    public RequirementsController(RequirementsService requirementsService) {
        this.requirementsService = requirementsService;
    }


    @GetMapping("/requirements")
    public ResponseEntity<List<RequirementsDTO>> getAllRequirements() {
        List<RequirementsDTO> requirements = requirementsService.findAllDTOs();
        return ResponseEntity.ok(requirements);
    }

    @GetMapping("/requirements/id/{id}")
    public ResponseEntity<Optional<Requirements>> getRequirementsById(@PathVariable Long id) {
        Optional<Requirements> foundRequirements = requirementsService.findById(id);
        return ResponseEntity.ok(foundRequirements);
    }

    @GetMapping("/requirements/package/{packageId}")
    public ResponseEntity<List<Requirements>> getRequirementsByPackageId(@PathVariable Long packageId) {
        List<Requirements> requirements = requirementsService.findByPackageId(packageId);
        return ResponseEntity.ok(requirements);
    }
}
