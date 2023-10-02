package com.TestNexa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TestNexa.entity.Paper;

@Repository
public interface PaperRepository extends JpaRepository<Paper, Long> {

}
