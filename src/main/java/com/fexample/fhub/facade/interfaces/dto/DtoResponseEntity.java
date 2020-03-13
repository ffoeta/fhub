package com.fexample.fhub.facade.interfaces.dto;

public interface DtoResponseEntity<T> {

    public DtoResponseEntity<T> fromModel(T t);
}