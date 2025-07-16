package com.example.wildpath.controller.admin;

import com.example.wildpath.dto.UpdateUserRoleDTO;
import com.example.wildpath.dto.UserAdminDTO;
import com.example.wildpath.entity.Role;
import com.example.wildpath.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserAdminDTO>> getAllUsers() {
        List<UserAdminDTO> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/role")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateUserRole(@RequestBody UpdateUserRoleDTO dto,
                                            @AuthenticationPrincipal UserDetails currentUser) {
        String result = userService.updateUserRole(dto, currentUser);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/roles")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Role[]> getAllRoles() {
        return ResponseEntity.ok(Role.values());
    }
}
