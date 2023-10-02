package com.TestNexa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TestNexa.entity.Organization;
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
