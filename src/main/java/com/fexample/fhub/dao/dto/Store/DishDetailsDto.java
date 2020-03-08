package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.DishDetails;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

import java.util.UUID;

public class DishDetailsDto  implements DtoEntity<DishDetails> {

    private UUID id;
    private String name;

    @Override
    public DishDetailsDto fromModel(DishDetails dishDetails) {

        return this;
    }

    @Override
    public DishDetails toModel() {
        return null;
    }
}
