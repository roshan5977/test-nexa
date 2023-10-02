package com.TestNexa.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestNexa.entity.Role;
import com.TestNexa.exception.RoleNotFoundException;
import com.TestNexa.repository.RoleRepository;
import com.TestNexa.service.RoleService;

@Service
public class RoleServiceImplementation implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> getAllRole() {
		List<Role> roles = this.roleRepository.findAll();
		if (roles.isEmpty()) {
			throw new RoleNotFoundException("No roles found.");
		}

		return roles;
	}

	@Override
	public Optional<Role> getRoleById(Long id) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid role ID");
		}

		Optional<Role> role = roleRepository.findById(id);

		if (!role.isPresent()) {
			throw new RoleNotFoundException("Role not found with ID: " + id);
		}

		return role;
	}

	@Override
	public Role createRole(Role role) {
		if (role == null) {
			throw new IllegalArgumentException("Role can't be null");
		}


		Role createdRole = roleRepository.save(role);

		if (createdRole == null) {
			throw new RuntimeException("Failed to create role");
		}

		return createdRole;
	}

	@Override
	public Role updateRole(Role role) {
		if (role == null || role.getRole_id() == null) {
			throw new IllegalArgumentException("Role or Role ID cannot be null");
		}

		Optional<Role> existingRole = roleRepository.findById(role.getRole_id());

		if (!existingRole.isPresent()) {
			throw new RoleNotFoundException("Role not found with ID: " + role.getRole_id());
		}

		Role updatedRole = roleRepository.save(role);

		if (updatedRole == null) {
			throw new RuntimeException("Failed to update role");
		}

		return updatedRole;
	}

	@Override
	public void deleteRole(Long id) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid role ID");
		}

		Optional<Role> existingRole = roleRepository.findById(id);

		if (!existingRole.isPresent()) {
			throw new RoleNotFoundException("Role not found with ID: " + id);
		}

		try {
			this.roleRepository.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException("Failed to delete role with ID: " + id, e);
		}
	}

}
