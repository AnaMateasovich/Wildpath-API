package com.example.wildpath.service;

import com.example.wildpath.dto.EnterpriseDTO;
import com.example.wildpath.entity.Enterprise;
import com.example.wildpath.mapper.EnterpriseMapper;
import com.example.wildpath.repository.IEnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService {

    private final IEnterpriseRepository enterpriseRepository;

    public EnterpriseService(IEnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    public List<Enterprise> findAll() {
        return enterpriseRepository.findAll();
    }

    public EnterpriseDTO findById(Long id) {
        Enterprise enterprise = enterpriseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enterprise not found"));

        EnterpriseDTO dto = EnterpriseMapper.toDTO(enterprise);
        return dto;
    }

    public Enterprise createEnterprise(EnterpriseDTO dto) {
        Enterprise enterprise = EnterpriseMapper.toEntity(dto);
        return enterpriseRepository.save(enterprise);
    }

    public Enterprise save(Enterprise newEnterprise) {
        return enterpriseRepository.save(newEnterprise);
    }

    public void deleteById(Long id) {
        enterpriseRepository.deleteById(id);
    }
}
