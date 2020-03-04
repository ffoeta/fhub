package com.fexample.fhub.dao.model.classes;
import lombok.Data;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "c_dish_details_table")
@Data
public class DishDetails extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "r_details_image_table", joinColumns = {@JoinColumn(name = "details_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "image_id", referencedColumnName = "id")})
    List<Image> images;
}