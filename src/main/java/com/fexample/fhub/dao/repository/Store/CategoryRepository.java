package com.fexample.fhub.dao.repository.Store;

import com.fexample.fhub.dao.model.classes.Store.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    Category findByName(String name);

    Page<Category> findAll(Pageable pageable);
}
