package com.example.wildpath.mapper;

import com.example.wildpath.dto.UserRegisterDTO;
import com.example.wildpath.dto.UserResponseDTO;
import com.example.wildpath.entity.User;

public class UserMapper {
    public static User toEntityRegister(UserRegisterDTO dto) {

        User user = new User();
        user.setName(dto.getName());
        user.setLastname(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        return user;
    }

    public static UserResponseDTO toDTO(User user, String token) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastname(user.getLastname());
        dto.setEmail(user.getEmail());
        dto.setToken(token);

        return  dto;
    }
}
