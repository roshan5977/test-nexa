package com.TestNexa.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ScheduleExam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long schedule_id;
	private Long paper_id;
	private String schedule_examCode;
	private Date exam_start_time;
	private Date exam_end_time;
	private String org_code;
	private Boolean schedule_exam_status;
	private String schedule_name;

}
