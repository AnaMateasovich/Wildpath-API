package com.example.wildpath.mapper;

import com.example.wildpath.dto.DateAvailableDTO;
import com.example.wildpath.entity.DateAvailable;
import com.example.wildpath.entity.TravelPackage;

import java.util.Date;
import java.util.List;

public class DateAvailableMapper {

    public static DateAvailableDTO toDTO(DateAvailable entity) {
        DateAvailableDTO dto = new DateAvailableDTO();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setSpots(entity.getSpots());
        dto.setPackageId(entity.getAPackage().getId());

        return dto;
    }

    public static DateAvailable toEntity(DateAvailableDTO dto) {
        DateAvailable dateAvailable = new DateAvailable();
        dateAvailable.setDate(dto.getDate());
        dateAvailable.setSpots(dto.getSpots());

        return dateAvailable;
    }

    public static List<DateAvailableDTO> toDTOList(List<DateAvailable> dates) {
        return dates.stream()
                .map(DateAvailableMapper::toDTO)
                .toList();
    }

    public static List<DateAvailable> toEntityList(List<DateAvailableDTO> dtos, TravelPackage travelPackage) {
        return dtos.stream()
                .map(dto -> {
                    DateAvailable entity = toEntity(dto);
                    entity.setAPackage(travelPackage);
                    return entity;
                })
                .toList();
    }



}
