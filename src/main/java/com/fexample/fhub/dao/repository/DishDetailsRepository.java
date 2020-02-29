package com.fexample.fhub.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.fexample.fhub.dao.model.DishDetails;

@Repository
public interface DishDetailsRepository extends JpaRepository<DishDetails, UUID> {
    DishDetails findByid(UUID id);
}