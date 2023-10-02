package com.TestNexa.service;

import java.util.List;
import java.util.Optional;

import com.TestNexa.entity.Organization;

public interface OrganizationService {
	public List<Organization> getAllOrganization();

	public Optional<Organization> getOrganizationById(Long id);

	public Organization createOrganization(Organization org);

	public Organization updateOrganization(Organization org);

	public void deleteOrganization(Long id);
}
