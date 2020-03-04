package com.fexample.fhub.facades.interfaces.service;

import java.util.List;
import java.util.UUID;

public interface BaseEntityService<T> {

    T save(T t);

    T delete(T t);

    T findById(UUID id);

    T find(T t);

    T findByName(String name);

    List<T> findAll();
}