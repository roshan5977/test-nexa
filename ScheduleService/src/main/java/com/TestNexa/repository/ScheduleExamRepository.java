package com.TestNexa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TestNexa.entity.ScheduleExam;

@Repository
public interface ScheduleExamRepository extends JpaRepository<ScheduleExam, Long> {

}
