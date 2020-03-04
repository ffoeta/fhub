package com.fexample.fhub.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.fexample.fhub.dao.model.classes.Ingridient;

@Repository
public interface IngridientRepository extends JpaRepository<Ingridient, UUID> {
    Ingridient findByName(String name);
}