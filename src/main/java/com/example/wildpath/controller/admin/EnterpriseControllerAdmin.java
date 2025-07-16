package com.example.wildpath.controller.admin;

import com.example.wildpath.dto.EnterpriseDTO;
import com.example.wildpath.entity.Enterprise;
import com.example.wildpath.service.EnterpriseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/enterprises")
public class EnterpriseControllerAdmin {

    private final EnterpriseService enterpriseService;

    public EnterpriseControllerAdmin(EnterpriseService enterpriseService) {
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
    public ResponseEntity<EnterpriseDTO> getEnterpriseById(@PathVariable Long id) {
        EnterpriseDTO dto = enterpriseService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnterprise(@PathVariable Long id) {
        enterpriseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
