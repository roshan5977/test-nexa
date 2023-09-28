package com.portal.service;

import java.util.List;
import java.util.Optional;

import com.portal.model.Role;

public interface RoleService {

	public List<Role> getAllRole();

	public Optional<Role> getRoleById(Long id);

	public Role createRole(Role role);

	public Role updateRole(Role role);

	public void deleteRole(Long id);

}
