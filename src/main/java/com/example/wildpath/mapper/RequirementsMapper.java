package com.example.wildpath.mapper;

import com.example.wildpath.dto.RequirementsDTO;
import com.example.wildpath.entity.Requirements;

public class RequirementsMapper {

    public static RequirementsDTO toDTO(Requirements requirements) {
        RequirementsDTO dto = new RequirementsDTO();
        dto.setId(requirements.getId());
        dto.setPackageId(requirements.getAPackage().getId());
        dto.setTitle(requirements.getTitle());
        dto.setDescription(requirements.getDescription());
        return dto;
    }

    public static Requirements toEntity(RequirementsDTO dto) {
        Requirements requirements = new Requirements();
        requirements.setTitle(dto.getTitle());
        requirements.setDescription(dto.getDescription());
        return requirements;
    }
}
