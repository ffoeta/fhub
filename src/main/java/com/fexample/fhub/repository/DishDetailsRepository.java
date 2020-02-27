package com.fexample.fhub.repository;

import com.fexample.fhub.model.DishDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DishDetailsRepository extends JpaRepository<DishDetails, UUID> {
    DishDetails findByid(UUID id);
}