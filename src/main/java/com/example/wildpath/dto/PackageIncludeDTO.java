package com.example.wildpath.dto;

import lombok.Data;

@Data
public class PackageIncludeDTO {

    private Long id;
    private Long packageId;
    private String description;
    private String iconSrc;
}
