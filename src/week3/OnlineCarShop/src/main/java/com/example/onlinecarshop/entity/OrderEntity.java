package com.example.onlinecarshop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders", schema = "public")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int date;

    @Column
    private int sum;

    @Column
    private String status;

    @Column
    private Long user_id;

    public OrderEntity(Long id, int date, int sum, String status, Long user_id) {
        this.id = id;
        this.date = date;
        this.sum = sum;
        this.status = status;
        this.user_id = user_id;
    }

    public OrderEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
