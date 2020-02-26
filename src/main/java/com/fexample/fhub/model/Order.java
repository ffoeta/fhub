package com.fexample.fhub.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "order")
@Data
public class Order extends BaseEntity {
    @Column(name = "user_id")
    private UUID user_id;

    @Column(name = "name")
    private String name;

    @Column(name = "payed")
    private int payed;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery")
    private Delivery delivery;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_dish", joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")})
    private List<Dish> dishes;
}