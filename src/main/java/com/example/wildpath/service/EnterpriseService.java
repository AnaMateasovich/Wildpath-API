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

    public Optional<Enterprise> findById(Long id) {
        return enterpriseRepository.findById(id);
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
