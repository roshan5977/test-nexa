package com.TestNexa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TestNexa.entity.Organization;
import com.TestNexa.exception.OrganizationNotFoundException;
import com.TestNexa.service.OrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/save")
    public ResponseEntity<Organization> saveOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(organizationService.createOrganization(organization));
    }

    @PutMapping("/update")
    public ResponseEntity<Organization> updateOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(organizationService.updateOrganization(organization));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
        return id + " Deleted Successfully";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Organization>> getAllOrganizations() {
        return ResponseEntity.ok(organizationService.getAllOrganization());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Organization> getOrganizationById(@PathVariable Long id) {
        Optional<Organization> organizationById = organizationService.getOrganizationById(id);
        if (!organizationById.isPresent()) {
            throw new OrganizationNotFoundException("Organization not found");
        }
        return ResponseEntity.ok(organizationById.get());
    }
}
