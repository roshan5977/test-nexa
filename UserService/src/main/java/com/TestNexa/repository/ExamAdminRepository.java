package com.TestNexa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TestNexa.entity.ExamAdmin;
@Repository
public interface ExamAdminRepository extends JpaRepository<ExamAdmin, Long>{

}
