package com.TestNexa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TestNexa.entity.UserSessionDetails;
@Repository
public interface UserSessionDetailsRepository extends JpaRepository<UserSessionDetails, Long>{

}
