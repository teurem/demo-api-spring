package com.example.onlinecarshop.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ValueGenerationType;

@Entity
@Table(name = "details", schema = "public")
public class DetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long car_id;

    @Column
    private Long order_id;

    @Column
    private int amount;

    @Column
    private int price_for_one;

    public DetailEntity(Long id, Long car_id, Long order_id, int amount, int price_for_one) {
        this.id = id;
        this.car_id = car_id;
        this.order_id = order_id;
        this.amount = amount;
        this.price_for_one = price_for_one;
    }

    public DetailEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice_for_one() {
        return price_for_one;
    }

    public void setPrice_for_one(int price_for_one) {
        this.price_for_one = price_for_one;
    }
}
