package com.example.onlinecarshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ValueGenerationType;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "details", schema = "public")
public class DetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "car_id", nullable = false)
    private CarEntity car_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order_id;

    @Column
    private int amount;

    @Column
    private int price_for_one;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarEntity getCar_id() {
        return car_id;
    }

    public void setCar_id(CarEntity car_id) {
        this.car_id = car_id;
    }

    public OrderEntity getOrder_id() {
        return order_id;
    }

    public void setOrder_id(OrderEntity order_id) {
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
