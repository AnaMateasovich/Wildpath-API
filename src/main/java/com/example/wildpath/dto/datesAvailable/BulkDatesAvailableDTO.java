package com.example.wildpath.dto.datesAvailable;

import com.example.wildpath.dto.DateAvailableDTO;
import lombok.Data;

import java.util.List;

@Data
public class BulkDatesAvailableDTO {
    private Long packageId;
    private List<DateAvailableDTO> dates;
}
