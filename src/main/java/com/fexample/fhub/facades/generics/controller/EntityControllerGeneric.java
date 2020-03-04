package com.fexample.fhub.facades.generics.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fexample.fhub.facades.interfaces.dto.DtoEntity;
import com.fexample.fhub.facades.interfaces.service.BaseEntityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class EntityControllerGeneric<T, TE extends DtoEntity<T> , R extends BaseEntityService<T>> {

    @Autowired
    private R service;

    @GetMapping("find")
    public ResponseEntity<Map<Object, Object>> find(){

        List<T> entities = service.findAll();

        Map<Object, Object> response = new HashMap<>();

        response.put("count", entities.size());
        response.put("items", entities);

        return ResponseEntity.ok(response);
    }

    @PostMapping("save")
    public ResponseEntity<Map<Object, Object>> save(@RequestBody TE te){
        
        T entity = te.toModel();
        entity = service.save(entity);

        Map<Object, Object> response = new HashMap<>();

        response.put("count", 1);
        response.put("items", entity);

        return new ResponseEntity<Map<Object, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Map<Object, Object>> delete(@RequestBody TE te){

        Map<Object, Object> response = new HashMap<>();

        T entity = te.toModel();

        try {
            service.delete(entity);
        } catch (Exception e){
            System.out.println(e);
            response.put("message", "error");
            return new ResponseEntity<Map<Object, Object>>(response, HttpStatus.OK);
        }

        return new ResponseEntity<Map<Object, Object>>(response, HttpStatus.OK);
    }

}