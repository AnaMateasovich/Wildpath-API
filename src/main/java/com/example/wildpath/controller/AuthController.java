package com.example.wildpath.controller;

import com.example.wildpath.dto.LoginDTO;
import com.example.wildpath.dto.UserRegisterDTO;
import com.example.wildpath.dto.UserResponseDTO;
import com.example.wildpath.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRegisterDTO dto) {
        UserResponseDTO responseDTO = userService.register(dto);
        return ResponseEntity.status(201).body(responseDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginDTO dto) {
        UserResponseDTO responseDTO = userService.login(dto);
        return ResponseEntity.ok(responseDTO);
    }
}
