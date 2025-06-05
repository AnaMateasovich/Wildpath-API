package com.example.wildpath.controller;

import com.example.wildpath.dto.EnterpriseDTO;
import com.example.wildpath.entity.Enterprise;
import com.example.wildpath.service.EnterpriseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enterprises")
public class EnterpriseController {

    private final EnterpriseService enterpriseService;

    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @PostMapping
    public ResponseEntity<Enterprise> createEnterprise(@RequestBody EnterpriseDTO dto) {
        Enterprise savedEnterprise = enterpriseService.createEnterprise(dto);
        return ResponseEntity.ok(savedEnterprise);
    }

    @GetMapping
    public ResponseEntity<List<Enterprise>> getAllEnterprises() {
        List<Enterprise> enterpriseList = enterpriseService.findAll();
        return ResponseEntity.ok(enterpriseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enterprise> getEnterpriseById(@PathVariable Long id) {
        return enterpriseService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnterprise(@PathVariable Long id) {
        enterpriseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
