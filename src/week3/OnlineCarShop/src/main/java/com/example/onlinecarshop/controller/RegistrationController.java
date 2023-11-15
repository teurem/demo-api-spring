package com.example.onlinecarshop.controller;

import com.example.onlinecarshop.entity.Role;
import com.example.onlinecarshop.entity.User;
import com.example.onlinecarshop.entity.UserEntity;
import com.example.onlinecarshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("registration")
    public String addUser(UserEntity user, Map<String, Object> model) {
        UserEntity userFromDb = userRepository.findByName(user.getName());

        if(userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

//        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.USER));

        return "redirect:/login";
    }
}
