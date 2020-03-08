package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.Ingridient;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

import java.util.UUID;

public class IngridientDto  implements DtoEntity<Ingridient> {

    private UUID id;
    private String name;

    @Override
    public IngridientDto fromModel(Ingridient ingridient) {

        return this;
    }

    @Override
    public Ingridient toModel() {
        return null;
    }
}
