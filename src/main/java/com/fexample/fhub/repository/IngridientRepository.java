package com.fexample.fhub.repository;

import com.fexample.fhub.model.Ingridient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IngridientRepository extends JpaRepository<Ingridient, UUID> {
    Ingridient findByName(String name);
}