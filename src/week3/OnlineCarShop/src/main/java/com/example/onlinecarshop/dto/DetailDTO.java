package com.example.onlinecarshop.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DetailDTO {
    private int amount;
    private int price_for_one;
}
