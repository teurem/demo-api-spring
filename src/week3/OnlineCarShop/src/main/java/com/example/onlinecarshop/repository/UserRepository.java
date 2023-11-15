package com.example.onlinecarshop.repository;

import com.example.onlinecarshop.dto.UserDTO;
import com.example.onlinecarshop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByName(String name);
}
