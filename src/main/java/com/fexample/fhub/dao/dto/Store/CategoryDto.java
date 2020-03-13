package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.Store.Category;
import com.fexample.fhub.dao.model.classes.User.User;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoRequestEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoResponseEntity;

import java.util.UUID;

public class CategoryDto implements DtoResponseEntity<Category>, DtoRequestEntity<Category>  {

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
