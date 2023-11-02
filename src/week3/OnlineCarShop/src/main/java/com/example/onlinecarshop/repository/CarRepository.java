package com.example.onlinecarshop.repository;

import com.example.onlinecarshop.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
}
