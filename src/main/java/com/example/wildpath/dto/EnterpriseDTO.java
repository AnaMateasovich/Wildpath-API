package com.example.wildpath.dto;

import lombok.Data;

@Data
public class EnterpriseDTO {

    private Long id;
    private String name;
    private String cuit;
    private String email;
    private String phone;
    private String address;
    private String socialMedia;
    private String description;

}
