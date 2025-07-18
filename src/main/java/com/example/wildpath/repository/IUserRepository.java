package com.example.wildpath.repository;

import com.example.wildpath.entity.Role;
import com.example.wildpath.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository <User, Long> {

    Optional<User> findByEmail(String email);
    long countByRole(Role role);

}
