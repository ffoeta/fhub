package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.Store.Ingridient;
import com.fexample.fhub.dao.model.classes.User.User;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoRequestEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoResponseEntity;

import java.util.UUID;

public class IngridientDto  implements DtoResponseEntity<Ingridient>, DtoRequestEntity<Ingridient> {

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
