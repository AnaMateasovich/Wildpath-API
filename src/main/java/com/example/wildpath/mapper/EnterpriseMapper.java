package com.example.wildpath.mapper;

import com.example.wildpath.dto.EnterpriseDTO;
import com.example.wildpath.entity.Enterprise;

public class EnterpriseMapper {
    public static EnterpriseDTO toDTO(Enterprise enterprise) {
        EnterpriseDTO dto = new EnterpriseDTO();
        dto.setId(enterprise.getId());
        dto.setName(enterprise.getName());
        dto.setCuit(enterprise.getCuit());
        dto.setEmail(enterprise.getEmail());
        dto.setPhone(enterprise.getPhone());
        dto.setAddress(enterprise.getAddress());
        dto.setSocialMedia(enterprise.getSocialMedia());
        dto.setDescription(enterprise.getDescription());

        return dto;
    }

    public static Enterprise toEntity(EnterpriseDTO dto) {
        Enterprise enterprise = new Enterprise();
        enterprise.setName(dto.getName());
        enterprise.setCuit(dto.getCuit());
        enterprise.setEmail(dto.getEmail());
        enterprise.setPhone(dto.getPhone());
        enterprise.setAddress(dto.getAddress());
        enterprise.setSocialMedia(dto.getSocialMedia());
        enterprise.setDescription(dto.getDescription());

        return enterprise;
    }
}
