package com.example.wildpath.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String token;
}

