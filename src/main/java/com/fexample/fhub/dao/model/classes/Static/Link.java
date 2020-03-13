package com.fexample.fhub.dao.model.classes.Static;

import com.fexample.fhub.dao.model.classes.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "c_link_table")
public class Link extends BaseEntity {

    @Column(name = "url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
