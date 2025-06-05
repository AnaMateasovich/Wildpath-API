package com.example.wildpath.mapper;


import com.example.wildpath.dto.*;
import com.example.wildpath.entity.Category;
import com.example.wildpath.entity.Enterprise;
import com.example.wildpath.entity.Place;
import com.example.wildpath.entity.TravelPackage;

import java.util.List;
import java.util.stream.Collectors;


public class TravelPackageMapper {
    public static TravelPackage toEntity(TravelPackageDTO dto, Category category, Place place, Enterprise enterprise) {
        TravelPackage p = new TravelPackage();
        p.setName(dto.getName());
        p.setCategory(category);
        p.setPlace(place);
        p.setDuration(dto.getDuration());
        p.setLatitude(dto.getLatitude());
        p.setLongitude(dto.getLongitude());
        p.setLocationAddress(dto.getLocationAddress());
        p.setPricePerPerson(dto.getPricePerPerson());
        p.setDifficulty(dto.getDifficulty());
        p.setDescription(dto.getDescription());
        p.setDiscount(dto.getDiscount());
        p.setCancelPolicy(dto.getCancelPolicy());
        p.setIsActive(dto.getIsActive());
        p.setEnterprise(enterprise);
        return p;
    }

    public static TravelPackageDTO toDTO(TravelPackage entity) {
        TravelPackageDTO dto = new TravelPackageDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDuration(entity.getDuration());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        dto.setLocationAddress(entity.getLocationAddress());
        dto.setPricePerPerson(entity.getPricePerPerson());
        dto.setDifficulty(entity.getDifficulty());
        dto.setDescription(entity.getDescription());
        dto.setDiscount(entity.getDiscount());
        dto.setIsActive(entity.getIsActive());
        dto.setCancelPolicy(entity.getCancelPolicy());

        List<ImageDTO> images = entity.getImages().stream()
                .map(ImageMapper::toDTO)
                .toList();
        dto.setImages(images);

        List<DateAvailableDTO> dateAvailable = entity.getDatesAvailable().stream()
                .map(DateAvailableMapper::toDTO)
                        .toList();
        dto.setDateAvailable(dateAvailable);

        List<RequirementsDTO> requirements = entity.getRequirements().stream()
                .map(RequirementsMapper::toDTO)
                .toList();
        dto.setRequirements(requirements);

        List<PackageIncludeDTO> packageIncludeDTOS = entity.getPackageIncludes().stream()
                .map(PackageIncludesMapper::toDTO)
                        .toList();
        dto.setPackageIncludes(packageIncludeDTOS);

        // Relacionales (pueden ser solo los IDs o también los nombres, según tu DTO)
        dto.setCategoryId(entity.getCategory().getId());
        dto.setPlaceId(entity.getPlace().getId());
        dto.setEnterpriseId(entity.getEnterprise().getId());

        // Extras si tu DTO los tiene:
        dto.setCategoryName(entity.getCategory().getName());
        dto.setPlaceName(entity.getPlace().getName());
        dto.setEnterpriseName(entity.getEnterprise().getName());

        return dto;
    }
}