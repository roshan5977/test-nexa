package com.TestNexa.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TestNexa.entity.Role;
import com.TestNexa.exception.RoleNotFoundException;
import com.TestNexa.service.RoleService;


@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.createRole(role));
    }

    @PutMapping("/update")
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.updateRole(role));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return id + " Deleted Successfully";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRole());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Optional<Role> roleById = roleService.getRoleById(id);
        if(!roleById.isPresent()) {
        	throw new RoleNotFoundException("Role Not found");
        }
        return ResponseEntity.ok(roleById.get());
    }
}

