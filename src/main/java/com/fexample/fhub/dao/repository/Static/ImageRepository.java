package com.fexample.fhub.dao.repository.Static;

import com.fexample.fhub.dao.model.classes.Static.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImageRepository extends JpaRepository<Image, UUID> {
}
