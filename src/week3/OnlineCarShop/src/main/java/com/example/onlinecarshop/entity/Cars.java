package com.example.onlinecarshop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cars", schema = "public")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private int year;

    @Column
    private int cost;

    @Column
    private String description;

    public Cars(Long id, String brand, String model, int year, int cost, String description) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.cost = cost;
        this.description = description;
    }

    public Cars() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
