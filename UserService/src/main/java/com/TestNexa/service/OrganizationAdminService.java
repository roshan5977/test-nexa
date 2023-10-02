package com.TestNexa.service;

import java.util.List;
import java.util.Optional;

import com.TestNexa.entity.OrganizationAdmin;

public interface OrganizationAdminService {
	public List<OrganizationAdmin> getAllOrganizationAdmin();

	public Optional<OrganizationAdmin> getOrganizationAdminById(Long id);

	public OrganizationAdmin createOrganizationAdmin(OrganizationAdmin org);

	public OrganizationAdmin updateOrganizationAdmin(OrganizationAdmin org);

	public void deleteOrganizationAdmin(Long id);
}
