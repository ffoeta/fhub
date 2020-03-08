package com.fexample.fhub.dao.dto.Order;

import com.fexample.fhub.dao.model.classes.Order;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;

public class OrderDto implements DtoEntity<Order> {

    @Override
    public OrderDto fromModel(Order order) {

        return this;
    }

    @Override
    public Order toModel() {

        return null;
    }
}
