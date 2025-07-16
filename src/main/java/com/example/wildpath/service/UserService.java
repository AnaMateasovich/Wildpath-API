package com.example.wildpath.service;

import com.example.wildpath.dto.UpdateUserRoleDTO;
import com.example.wildpath.dto.UserAdminDTO;
import com.example.wildpath.entity.Role;
import com.example.wildpath.entity.User;
import com.example.wildpath.repository.IUserRepository;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserAdminDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserAdminDTO(
                        user.getId(),
                        user.getName(),
                        user.getLastname(),
                        user.getEmail(),
                        user.getRole()
                ))
                .collect(Collectors.toList());
    }

    public String updateUserRole(UpdateUserRoleDTO dto, UserDetails currentUser) {
        User userToUpdate = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if ("admin@wildpath.com".equals(userToUpdate.getEmail())) {
           throw new RuntimeException("You cannot modify the root administrator");
        }

        if (currentUser.getUsername().equals(userToUpdate.getEmail()) && dto.getRole() != Role.ADMIN) {
            throw new RuntimeException("You cannot remove your own admin role");

        }

        userToUpdate.setRole(dto.getRole());
        userRepository.save(userToUpdate);
        return "Role updated";
    }

    public User getUserFromAuth(Authentication authentication) {
        String email = authentication.getName(); //
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
