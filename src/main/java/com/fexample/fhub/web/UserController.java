package com.fexample.fhub.web;

import com.fexample.fhub.dao.dto.User.UserExtended;
import com.fexample.fhub.dao.model.classes.User;
import com.fexample.fhub.facades.generics.controller.EntityControllerGeneric;
import com.fexample.fhub.facades.interfaces.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController extends EntityControllerGeneric<User, UserExtended, UserService>{}