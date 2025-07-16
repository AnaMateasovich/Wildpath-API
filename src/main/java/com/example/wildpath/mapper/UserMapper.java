package com.example.wildpath.mapper;

import com.example.wildpath.dto.UserUpdateDTO;
import com.example.wildpath.entity.User;

public class UserMapper {
    public static void updateUserFromDTO(User user, UserUpdateDTO dto) {
        user.setAddress(dto.getAddress());
        user.setZipcode(dto.getZipcode());
        user.setCity(dto.getCity());
        user.setCountry(dto.getCountry());
        user.setPhoneNumber(dto.getPhoneNumber());
    }
}
