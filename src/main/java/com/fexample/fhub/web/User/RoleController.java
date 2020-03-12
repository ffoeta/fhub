package com.fexample.fhub.web.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fexample.fhub.dao.dto.User.RoleDto;
import com.fexample.fhub.dao.model.classes.User.Role;
import com.fexample.fhub.facade.interfaces.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;


    @GetMapping("all")
    public ResponseEntity<Map<Object, Object>> findAllRoles(@RequestParam(value= "page", defaultValue = "0") int page,
                                                            @RequestParam(value= "size", defaultValue = "10") int size,
                                                            @RequestParam(value= "sort", defaultValue = "name") String sort){
        List<Role> roles = roleService.findAllRoles(PageRequest.of(page, size, Sort.by(sort)));

        Map<Object, Object> response = new HashMap<>();

        response.put("count", roles.size());
        response.put("items", roles);

        return ResponseEntity.ok()
                .body(response);
    }

    @PostMapping("add")
    public ResponseEntity<Map<Object, Object>> AddNewRole(@RequestBody RoleDto roleDto){
        Map<Object, Object> response = new HashMap<>();

        Role role = this.roleService.saveRole(roleDto.toModel());

        response.put("count", 1);
        response.put("items", role);

        return ResponseEntity.ok()
                .body(response);
    }


}