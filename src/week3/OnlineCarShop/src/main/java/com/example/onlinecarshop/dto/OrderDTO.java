package com.example.onlinecarshop.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class OrderDTO {
    private int date;

    private int sum;

    private String status;
}
