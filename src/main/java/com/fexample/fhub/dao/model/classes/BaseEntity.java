package com.fexample.fhub.dao.model.classes;

import com.fexample.fhub.dao.model.enums.Status;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseEntity {

    @PrePersist
    public void prePersist() {
        if(this.getStatus() == null) 
            this.setStatus(Status.NOT_ACTIVE);
    }

    @Id
    private UUID id;

    @CreatedDate
    @Column(name = "created")
    private Date created;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updated;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
 }