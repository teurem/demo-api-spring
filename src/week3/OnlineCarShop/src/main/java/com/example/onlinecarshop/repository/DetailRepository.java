package com.example.onlinecarshop.repository;

import com.example.onlinecarshop.dto.DetailDTO;
import com.example.onlinecarshop.entity.DetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<DetailEntity, Long> {
}
