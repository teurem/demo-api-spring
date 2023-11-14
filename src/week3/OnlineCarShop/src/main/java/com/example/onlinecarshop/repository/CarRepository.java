package com.example.onlinecarshop.repository;

import com.example.onlinecarshop.dto.CarDTO;
import com.example.onlinecarshop.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
}
