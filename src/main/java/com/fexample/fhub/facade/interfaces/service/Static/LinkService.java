package com.fexample.fhub.facade.interfaces.service.Static;

import com.fexample.fhub.dao.model.classes.Static.Link;
import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface LinkService {

    //save Link
    Link saveLink(Link Link) throws EntityAlreadyExistsException;

    //update Link
    Link updateLink(Link Link) throws EntityNotExistsException;

    //disable Link by name
    Link fakeDeleteLinkById(UUID id) throws EntityNotExistsException;

    //delete Link by name
    void deleteLinkById(UUID id) throws EntityNotExistsException;

    //find all Links
    List<Link> findAllLinks(Pageable pageable);

    //find by name
    Link findById(UUID id) throws EntityNotExistsException;
}