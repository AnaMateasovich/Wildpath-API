package com.example.wildpath.mapper;

import com.example.wildpath.dto.ImageDTO;
import com.example.wildpath.entity.Image;

public class ImageMapper {

    public static ImageDTO toDTO(Image image) {
        ImageDTO dto = new ImageDTO();
        dto.setId(image.getId());
        dto.setName(image.getName());
        String baseUrl = "http://localhost:8081";
        dto.setSrc(baseUrl + image.getSrc());

        return dto;
    }

    public static Image toEntity(ImageDTO dto) {
        Image image = new Image();
        image.setName(dto.getName());
        image.setSrc(dto.getSrc());
        return image;
    }
}
