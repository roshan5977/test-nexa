package com.TestNexa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TestNexa.entity.OrganizationAdmin;
@Repository
public interface OrganizationAdminRepository extends JpaRepository<OrganizationAdmin, Long>{

}
