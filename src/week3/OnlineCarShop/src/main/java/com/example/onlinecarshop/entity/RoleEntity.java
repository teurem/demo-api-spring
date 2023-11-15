package com.example.onlinecarshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Data
@Table(name = "roles")
public class RoleEntity {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
}

