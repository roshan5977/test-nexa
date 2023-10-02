package com.TestNexa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TestNexa.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
