package com.fexample.fhub.dao.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "c_store_details_table")
@Data
public class StoreDetails extends BaseEntity{

    @Column(name = "description")
    private String description;
}