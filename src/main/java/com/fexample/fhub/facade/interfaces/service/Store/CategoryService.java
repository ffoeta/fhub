package com.fexample.fhub.facade.interfaces.service.Store;

import com.fexample.fhub.dao.model.classes.Store.Category;
import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    //save Category
    Category saveCategory(Category Category) throws EntityAlreadyExistsException;

    //update Category
    Category updateCategory(Category Category) throws EntityNotExistsException;

    //disable Category by name
    Category fakeDeleteCategoryById(UUID id) throws EntityNotExistsException;

    //delete Category by name
    void deleteCategoryById(UUID id) throws EntityNotExistsException;

    //find all Categories
    List<Category> findAllCategories(Pageable pageable);

    //find by name
    Category findByName(String name) throws EntityNotExistsException;

    //find by id
    Category findById(UUID id) throws EntityNotExistsException;
}
