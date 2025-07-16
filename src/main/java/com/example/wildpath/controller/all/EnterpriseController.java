package com.example.wildpath.controller.all;

import com.example.wildpath.dto.EnterpriseDTO;
import com.example.wildpath.service.EnterpriseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/all/enterprises")
public class EnterpriseController {

    private final EnterpriseService enterpriseService;

    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnterpriseDTO> getEnterpriseById(@PathVariable Long id) {
        EnterpriseDTO dto = enterpriseService.findById(id);
        return ResponseEntity.ok(dto);
    }
}
