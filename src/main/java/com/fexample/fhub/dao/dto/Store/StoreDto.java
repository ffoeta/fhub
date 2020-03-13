package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.Store.Store;
import com.fexample.fhub.dao.model.classes.User.User;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoRequestEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoResponseEntity;

import java.util.UUID;

public class StoreDto  implements DtoResponseEntity<Store>, DtoRequestEntity<Store> {

    private UUID id;
    private String name;

    @Override
    public StoreDto fromModel(Store store) {

        return this;
    }

    @Override
    public Store toModel() {
        return null;
    }
}
