package com.example.wildpath.mapper;

import com.example.wildpath.dto.ImageDTO;
import com.example.wildpath.entity.Image;
import com.example.wildpath.entity.TravelPackage;


public class ImageMapper {

    public static ImageDTO toDTO(Image image) {
        ImageDTO dto = new ImageDTO();
        dto.setId(image.getId());
        dto.setName(image.getName());
        dto.setSrc(image.getSrc());
        dto.setPackageId(image.getAPackage().getId());

        return dto;
    }

    public static Image toEntity(ImageDTO dto) {
        Image image = new Image();
        image.setName(dto.getName());
        image.setSrc(dto.getSrc());

        TravelPackage travelPackage = new TravelPackage();
        travelPackage.setId(dto.getPackageId());

        image.setAPackage(travelPackage);
        return image;
    }
}
