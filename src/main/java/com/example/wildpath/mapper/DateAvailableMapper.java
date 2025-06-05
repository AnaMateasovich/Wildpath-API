package com.example.wildpath.mapper;

import com.example.wildpath.dto.DateAvailableDTO;
import com.example.wildpath.entity.DateAvailable;
import com.example.wildpath.entity.TravelPackage;

public class DateAvailableMapper {

    public static DateAvailableDTO toDTO(DateAvailable dateAvailable) {
        DateAvailableDTO dto = new DateAvailableDTO();
        dto.setId(dateAvailable.getId());
        dto.setDate(dateAvailable.getDate());
        dto.setCapacity(dateAvailable.getCapacity());

        return dto;
    }

    public static DateAvailable toEntity(DateAvailableDTO dto) {
        DateAvailable dateAvailable = new DateAvailable();
        dateAvailable.setDate(dto.getDate());
        dateAvailable.setCapacity(dto.getCapacity());

        return dateAvailable;
    }
}
