package com.example.wildpath.dto;

import com.example.wildpath.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRoleDTO {
    private Long userId;
    private String email;
    private Role role;
}
