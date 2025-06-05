package com.example.wildpath.mapper;

import com.example.wildpath.dto.PackageIncludeDTO;
import com.example.wildpath.entity.PackageInclude;
import com.example.wildpath.entity.TravelPackage;

public class PackageIncludesMapper {

    public static PackageIncludeDTO toDTO(PackageInclude packageInclude) {
        PackageIncludeDTO dto = new PackageIncludeDTO();
        dto.setId(packageInclude.getId());
        dto.setDescription(packageInclude.getDescription());
        dto.setIconSrc(packageInclude.getIconSrc());

        return dto;
    }

    public static PackageInclude toEntity(PackageIncludeDTO dto) {
        PackageInclude packageInclude = new PackageInclude();
        packageInclude.setDescription(dto.getDescription());
        packageInclude.setIconSrc(dto.getIconSrc());

        return packageInclude;
    }
}
