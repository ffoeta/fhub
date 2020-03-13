package com.fexample.fhub.dao.dto.Store;

import com.fexample.fhub.dao.model.classes.Store.StoreDetails;
import com.fexample.fhub.dao.model.classes.User.User;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoRequestEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoResponseEntity;

import java.util.UUID;

public class StoreDetailsDto  implements DtoResponseEntity<StoreDetails>, DtoRequestEntity<StoreDetails> {

    private UUID id;
    private String name;

    @Override
    public StoreDetailsDto fromModel(StoreDetails storeDetails) {

        return this;
    }

    @Override
    public StoreDetails toModel() {
        return null;
    }
}
