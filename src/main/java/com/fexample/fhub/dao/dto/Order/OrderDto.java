package com.fexample.fhub.dao.dto.Order;

import com.fexample.fhub.dao.model.classes.Order.Order;
import com.fexample.fhub.dao.model.classes.User.User;
import com.fexample.fhub.facade.interfaces.dto.DtoEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoRequestEntity;
import com.fexample.fhub.facade.interfaces.dto.DtoResponseEntity;

public class OrderDto implements DtoResponseEntity<Order>, DtoRequestEntity<Order>  {

    @Override
    public OrderDto fromModel(Order order) {

        return this;
    }

    @Override
    public Order toModel() {

        return null;
    }
}
