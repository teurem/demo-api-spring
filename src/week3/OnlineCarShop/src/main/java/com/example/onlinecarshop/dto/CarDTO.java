package com.example.onlinecarshop.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CarDTO {
    private String brand;
    private String model;
    private int year;
    private int cost;
    private String description;
}
