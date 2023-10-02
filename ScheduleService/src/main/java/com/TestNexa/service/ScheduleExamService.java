package com.TestNexa.service;

import java.util.List;
import java.util.Optional;

import com.TestNexa.entity.ScheduleExam;


public interface ScheduleExamService {

	public List<ScheduleExam> getAllScheduleExams();

	public Optional<ScheduleExam> getScheduleExamById(Long id);

	public ScheduleExam createScheduleExams(ScheduleExam options);

	public ScheduleExam updateScheduleExams(ScheduleExam options);

	public void deleteScheduleExams(Long id);
}
