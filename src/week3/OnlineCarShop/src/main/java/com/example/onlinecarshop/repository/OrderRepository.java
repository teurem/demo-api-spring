package com.example.onlinecarshop.repository;

import com.example.onlinecarshop.dto.OrderDTO;
import com.example.onlinecarshop.dto.UserDTO;
import com.example.onlinecarshop.entity.OrderEntity;
import com.example.onlinecarshop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
