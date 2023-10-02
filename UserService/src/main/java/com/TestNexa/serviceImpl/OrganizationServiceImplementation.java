package com.TestNexa.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestNexa.entity.Organization;
import com.TestNexa.exception.OrganizationNotFoundException;
import com.TestNexa.repository.OrganizationRepository;
import com.TestNexa.service.OrganizationService;

@Service
public class OrganizationServiceImplementation implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public List<Organization> getAllOrganization() {
        return organizationRepository.findAll();
    }

    @Override
    public Optional<Organization> getOrganizationById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid organization ID");
        }

        Optional<Organization> organization = organizationRepository.findById(id);

        if (!organization.isPresent()) {
            throw new OrganizationNotFoundException("Organization not found with ID: " + id);
        }

        return organization;
    }

    @Override
    public Organization createOrganization(Organization org) {
        if (org == null) {
            throw new IllegalArgumentException("Organization can't be null");
        }

        Organization createdOrganization = organizationRepository.save(org);

        if (createdOrganization == null) {
            throw new RuntimeException("Failed to create organization");
        }

        return createdOrganization;
    }

    @Override
    public Organization updateOrganization(Organization org) {
        if (org == null || org.getOrg_id() == null) {
            throw new IllegalArgumentException("Organization or ID cannot be null");
        }

        Optional<Organization> existingOrganization = organizationRepository.findById(org.getOrg_id());

        if (!existingOrganization.isPresent()) {
            throw new OrganizationNotFoundException("Organization not found with ID: " + org.getOrg_id());
        }

        Organization updatedOrganization = organizationRepository.save(org);

        if (updatedOrganization == null) {
            throw new RuntimeException("Failed to update organization");
        }

        return updatedOrganization;
    }

    @Override
    public void deleteOrganization(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid organization ID");
        }

        Optional<Organization> existingOrganization = organizationRepository.findById(id);

        if (!existingOrganization.isPresent()) {
            throw new OrganizationNotFoundException("Organization not found with ID: " + id);
        }

        try {
            this.organizationRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete organization with ID: " + id, e);
        }
    }
}
