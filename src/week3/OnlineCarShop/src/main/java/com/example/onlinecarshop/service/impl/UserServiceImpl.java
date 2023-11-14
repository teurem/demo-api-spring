package com.example.onlinecarshop.service.impl;

import com.example.onlinecarshop.dto.UserDTO;
import com.example.onlinecarshop.entity.RoleEntity;
import com.example.onlinecarshop.entity.UserEntity;
import com.example.onlinecarshop.entity.UserRole;
import com.example.onlinecarshop.repository.RoleRepository;
import com.example.onlinecarshop.repository.UserRepository;
import com.example.onlinecarshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(this::convertingEntityToDto)
                .collect(Collectors.toList());
    }

    private UserDTO convertingEntityToDto(UserEntity user){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setCity(user.getCity());
        return userDTO;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        return userRepository.findById(userId)
                .map(this::convertingEntityToDto)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }


//    @Override
//    public UserDTO getUserById(Long userId) {
//        Optional<UserDTO> userOpt = userRepository.findById(userId)
//                .stream()
//                .map(this::convertingEntityToDto)
//
//        if(userOpt.isPresent())
//            return userOpt.get();
//        else
//            throw new RuntimeException("user not found.");
//    }

    @Override
    public void saveUser(UserEntity user) {
        UserEntity userDetail = userRepository.save(user);
        System.out.println("user saved to db with userId : "+ userDetail.getId());
    }

    @Override
    public void updateUser(UserEntity user, Long userId) {
        Optional<UserEntity> userDetailOpt = userRepository.findById(userId);
        if(userDetailOpt.isPresent()){
            UserEntity userDetail = userDetailOpt.get();
            if(user.getName() != null || user.getName().isEmpty())
                userDetail.setName(user.getName());
            if(user.getPassword() != null || user.getPassword().isEmpty())
                userDetail.setPassword(user.getPassword());
            if(user.getCity() != null || user.getCity().isEmpty())
                userDetail.setCity(user.getCity());
            userRepository.save(userDetail);
        } else {
            throw new RuntimeException("user not found");
        }
    }

    @Override
    public void deleteUserId(Long userId) {
        Optional<UserEntity> userOpt = userRepository.findById(userId);
        if(userOpt.isPresent())
            userRepository.deleteById(userId);
        else
            throw new RuntimeException("user not found");
    }

    @Override
    public UserEntity registerUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        RoleEntity userRole = (RoleEntity) roleRepository.findByRole(UserRole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.setRoles(Collections.singleton(userRole));

        return userRepository.save(user);
    }

}

