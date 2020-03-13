package com.fexample.fhub.dao.service.Static;

import com.fexample.fhub.dao.model.classes.Static.Link;
import com.fexample.fhub.dao.model.enums.Status;
import com.fexample.fhub.dao.repository.Static.LinkRepository;
import com.fexample.fhub.facade.exception.Controller.ControllerServiceCallException;
import com.fexample.fhub.facade.exception.Service.EntityAlreadyExistsException;
import com.fexample.fhub.facade.exception.Service.EntityNotExistsException;
import com.fexample.fhub.facade.interfaces.service.Static.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    LinkRepository LinkRepository;

    @Override
    public Link saveLink(Link Link) throws EntityAlreadyExistsException {

        Link.setId(UUID.randomUUID());
        Link.setCreated(new Date());
        Link.setUpdated(new Date());
        Link.setStatus(Status.ACTIVE);

        return this.LinkRepository.save(Link);
    }

    @Override
    public Link updateLink(Link Link)  throws EntityNotExistsException {

        Optional<Link> Link2 = this.LinkRepository.findById(Link.getId());

        Link2.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Link " + Link.getId().toString() + " does not exist.")));

        Link.setId(Link2.get().getId());
        Link.setStatus(Link2.get().getStatus());
        Link.setCreated(Link2.get().getCreated());
        Link.setUpdated(new Date());

        return this.LinkRepository.save(Link);
    }

    @Override
    public Link fakeDeleteLinkById(UUID id) throws EntityNotExistsException {

        Optional<Link> Link = this.LinkRepository.findById(id);

        Link.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Link " + id + " does not exist.")));

        Link.get().setStatus(Status.DELETED);
        Link.get().setUpdated(new Date());

        return this.LinkRepository.save(Link.get());
    }

    @Override
    public void deleteLinkById(UUID id) throws EntityNotExistsException {

        Optional<Link> Link = this.LinkRepository.findById(id);

        Link.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Link " + id + " does not exist.")));

        this.LinkRepository.deleteById(id);
    }

    @Override
    public List<Link> findAllLinks(Pageable pageable) {

        return this.LinkRepository.findAll(pageable).getContent();
    }

    @Override
    public Link findById(UUID id) throws EntityNotExistsException {

        Optional<Link> Link = this.LinkRepository.findById(id);

        Link.orElseThrow(() ->
                new ControllerServiceCallException(
                        new EntityAlreadyExistsException("Link " + id + " does not exist.")));

        return Link.get();
    }
}
