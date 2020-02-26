package com.fexample.fhub.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "storedetails")
@Data
public class StoreDetails extends BaseEntity{

    @Column(name = "description")
    private String description;
}