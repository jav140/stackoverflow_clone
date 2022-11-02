package com.example.stackoverflow_mono.repository;

import com.example.stackoverflow_mono.domains.Role;
import com.example.stackoverflow_mono.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
