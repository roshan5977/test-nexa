package com.TestNexa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long res_id;
	private Long paper_id;
	private Long user_id;
	private String grade;
	private Long user_mark_obtained;
	private Long exam_total_mark;
	private Long schedule_id;
	private Long org_code;

}
