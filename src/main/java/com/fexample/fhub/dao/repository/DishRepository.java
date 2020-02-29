package com.fexample.fhub.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.fexample.fhub.dao.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, UUID> {
    Dish findByName(String name);
}