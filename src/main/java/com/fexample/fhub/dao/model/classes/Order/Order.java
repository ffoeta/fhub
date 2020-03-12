package com.fexample.fhub.dao.model.classes.Order;

import com.fexample.fhub.dao.model.classes.BaseEntity;
import com.fexample.fhub.dao.model.classes.Store.Dish;
import com.fexample.fhub.dao.model.enums.Delivery;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "c_order_table")
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
    @JoinTable(name = "r_order_dish_table", joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")})
    private List<Dish> dishes;

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPayed() {
        return payed;
    }

    public void setPayed(int payed) {
        this.payed = payed;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}