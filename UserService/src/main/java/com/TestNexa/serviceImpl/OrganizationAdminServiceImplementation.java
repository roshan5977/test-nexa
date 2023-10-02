package com.TestNexa.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestNexa.entity.OrganizationAdmin;
import com.TestNexa.exception.OrganizationAdminNotFoundException;
import com.TestNexa.repository.OrganizationAdminRepository;
import com.TestNexa.service.OrganizationAdminService;

@Service
public class OrganizationAdminServiceImplementation implements OrganizationAdminService {

    @Autowired
    private OrganizationAdminRepository organizationAdminRepository;

    @Override
    public List<OrganizationAdmin> getAllOrganizationAdmin() {
        return organizationAdminRepository.findAll();
    }

    @Override
    public Optional<OrganizationAdmin> getOrganizationAdminById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid organization admin ID");
        }

        Optional<OrganizationAdmin> organizationAdmin = organizationAdminRepository.findById(id);

        if (!organizationAdmin.isPresent()) {
            throw new OrganizationAdminNotFoundException("OrganizationAdmin not found with ID: " + id);
        }

        return organizationAdmin;
    }

    @Override
    public OrganizationAdmin createOrganizationAdmin(OrganizationAdmin orgAdmin) {
        if (orgAdmin == null) {
            throw new IllegalArgumentException("OrganizationAdmin can't be null");
        }

        OrganizationAdmin createdOrgAdmin = organizationAdminRepository.save(orgAdmin);

        if (createdOrgAdmin == null) {
            throw new RuntimeException("Failed to create OrganizationAdmin");
        }

        return createdOrgAdmin;
    }

    @Override
    public OrganizationAdmin updateOrganizationAdmin(OrganizationAdmin orgAdmin) {
        if (orgAdmin == null || orgAdmin.getOrg_admin_id() == null) {
            throw new IllegalArgumentException("OrganizationAdmin or ID cannot be null");
        }

        Optional<OrganizationAdmin> existingOrgAdmin = organizationAdminRepository.findById(orgAdmin.getOrg_admin_id());

        if (!existingOrgAdmin.isPresent()) {
            throw new OrganizationAdminNotFoundException("OrganizationAdmin not found with ID: " + orgAdmin.getOrg_admin_id());
        }

        OrganizationAdmin updatedOrgAdmin = organizationAdminRepository.save(orgAdmin);

        if (updatedOrgAdmin == null) {
            throw new RuntimeException("Failed to update OrganizationAdmin");
        }

        return updatedOrgAdmin;
    }

    @Override
    public void deleteOrganizationAdmin(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid organization admin ID");
        }

        Optional<OrganizationAdmin> existingOrgAdmin = organizationAdminRepository.findById(id);

        if (!existingOrgAdmin.isPresent()) {
            throw new OrganizationAdminNotFoundException("OrganizationAdmin not found with ID: " + id);
        }

        try {
            this.organizationAdminRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete OrganizationAdmin with ID: " + id, e);
        }
    }
}
