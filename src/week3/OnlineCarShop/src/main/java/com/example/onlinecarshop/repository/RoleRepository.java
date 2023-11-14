package com.example.onlinecarshop.repository;

import com.example.onlinecarshop.entity.RoleEntity;
import com.example.onlinecarshop.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<Object> findByRole(UserRole userRole);
}
