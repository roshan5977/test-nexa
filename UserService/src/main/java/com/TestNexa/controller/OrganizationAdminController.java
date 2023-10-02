package com.TestNexa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TestNexa.entity.OrganizationAdmin;
import com.TestNexa.exception.OrganizationAdminNotFoundException;
import com.TestNexa.service.OrganizationAdminService;

@RestController
@RequestMapping("/organizationadmin")
public class OrganizationAdminController {
    @Autowired
    private OrganizationAdminService organizationAdminService;

    @PostMapping("/save")
    public ResponseEntity<OrganizationAdmin> saveOrganizationAdmin(@RequestBody OrganizationAdmin organizationAdmin) {
        return ResponseEntity.ok(organizationAdminService.createOrganizationAdmin(organizationAdmin));
    }

    @PutMapping("/update")
    public ResponseEntity<OrganizationAdmin> updateOrganizationAdmin(@RequestBody OrganizationAdmin organizationAdmin) {
        return ResponseEntity.ok(organizationAdminService.updateOrganizationAdmin(organizationAdmin));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrganizationAdmin(@PathVariable Long id) {
        organizationAdminService.deleteOrganizationAdmin(id);
        return id + " Deleted Successfully";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<OrganizationAdmin>> getAllOrganizationAdmins() {
        return ResponseEntity.ok(organizationAdminService.getAllOrganizationAdmin());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<OrganizationAdmin> getOrganizationAdminById(@PathVariable Long id) {
        Optional<OrganizationAdmin> organizationAdminById = organizationAdminService.getOrganizationAdminById(id);
        if (!organizationAdminById.isPresent()) {
            throw new OrganizationAdminNotFoundException("OrganizationAdmin not found");
        }
        return ResponseEntity.ok(organizationAdminById.get());
    }
}
