package com.example.wildpath.service.interfaceService;

import com.example.wildpath.dto.LoginDTO;
import com.example.wildpath.dto.UserRegisterDTO;
import com.example.wildpath.dto.UserResponseDTO;
import com.example.wildpath.entity.User;

public interface IUserService {

    UserResponseDTO register(UserRegisterDTO dto);
    UserResponseDTO login(LoginDTO dto);

}
