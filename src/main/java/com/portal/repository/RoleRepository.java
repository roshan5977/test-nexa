package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
