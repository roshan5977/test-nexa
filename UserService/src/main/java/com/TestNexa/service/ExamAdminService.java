package com.TestNexa.service;

import java.util.List;
import java.util.Optional;

import com.TestNexa.entity.ExamAdmin;

public interface ExamAdminService {
	public List<ExamAdmin> getAllExamAdmins();

	public Optional<ExamAdmin> getExamAdminById(Long id);

	public ExamAdmin createExamAdmin(ExamAdmin admin);

	public ExamAdmin updateExamAdmin(ExamAdmin admin);

	public void deleteExamAdmin(Long id);
}
