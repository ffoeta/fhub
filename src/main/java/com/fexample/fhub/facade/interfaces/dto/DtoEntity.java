package com.fexample.fhub.facade.interfaces.dto;

public interface DtoEntity<T> {

    public DtoEntity<T> fromModel(T t);

    public T toModel();
}