package com.example.onlinecarshop.service;

import com.example.onlinecarshop.dto.UserDTO;
import com.example.onlinecarshop.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUser();
    UserDTO getUserById(Long userId);
    void saveUser(UserEntity user);
    void updateUser(UserEntity user, Long userId);
    void deleteUserId(Long userId);
}
