package com.example.wildpath.controller.admin;

import com.example.wildpath.dto.RequirementsDTO;
import com.example.wildpath.entity.Requirements;
import com.example.wildpath.service.RequirementsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/requirements")
public class RequirementsControllerAdmin {

    private final RequirementsService requirementsService;

    public RequirementsControllerAdmin(RequirementsService requirementsService) {
        this.requirementsService = requirementsService;
    }

    @PostMapping
    public ResponseEntity<List<Requirements>> createRequirements(@RequestBody List<RequirementsDTO> requests) {
        List<Requirements> createdRequirements = requirementsService.createRequirement(requests);
        return ResponseEntity.ok(createdRequirements);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequirements(@PathVariable Long id) {
        requirementsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
