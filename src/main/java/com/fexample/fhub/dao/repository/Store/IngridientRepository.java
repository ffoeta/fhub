package com.fexample.fhub.dao.repository.Store;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.fexample.fhub.dao.model.classes.Store.Ingridient;

@Repository
public interface IngridientRepository extends JpaRepository<Ingridient, UUID> {
    
    Ingridient findByName(String name);

    Page<Ingridient> findAll(Pageable pageable);    
}