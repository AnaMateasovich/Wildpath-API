package com.example.wildpath.dto;

import com.example.wildpath.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAdminDTO {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private Role role;
}
