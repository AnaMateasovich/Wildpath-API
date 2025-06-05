package com.example.wildpath.dto;

import lombok.Data;

@Data
public class UserRegisterDTO {
    private String name;
    private String lastname;
    private String email;
    private String password;
}
