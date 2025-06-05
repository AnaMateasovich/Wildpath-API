package com.example.wildpath.service;

import com.example.wildpath.dto.LoginDTO;
import com.example.wildpath.dto.UserRegisterDTO;
import com.example.wildpath.dto.UserResponseDTO;
import com.example.wildpath.entity.User;
import com.example.wildpath.mapper.UserMapper;
import com.example.wildpath.repository.IUserRepository;
import com.example.wildpath.service.interfaceService.IUserService;
import com.example.wildpath.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private final IUserRepository userRepository;
    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(IUserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserResponseDTO register(UserRegisterDTO dto) {
        userRepository.findByEmail(dto.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("Email already registered");
                });


        User user = UserMapper.toEntityRegister(dto);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);

        String token = JwtUtil.generateToken(user.getEmail());

        return UserMapper.toDTO(savedUser, token);
    }

    @Override
    public UserResponseDTO login(LoginDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = JwtUtil.generateToken(user.getEmail());

        return UserMapper.toDTO(user, token);
    }


}
