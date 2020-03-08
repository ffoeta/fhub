package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.Category;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

import java.util.UUID;

public class CategoryDto implements DtoEntity<Category> {

    private UUID id;
    private String name;

    @Override
    public CategoryDto fromModel(Category category) {

        return this;
    }

    @Override
    public Category toModel() {
        return null;
    }
}
