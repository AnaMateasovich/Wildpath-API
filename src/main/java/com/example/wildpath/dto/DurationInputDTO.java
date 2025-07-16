package com.example.wildpath.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DurationInputDTO {
    private Integer days;
    private Integer hours;
    private Integer minutes;
    private Integer nights;
}

