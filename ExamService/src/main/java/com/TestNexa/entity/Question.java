package com.TestNexa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long question_id;
	private String question_type;
	private Long exam_id;
	private Long question_mark;
	private String question_text;
	private Boolean correct_answer;
	private String org_code;
	@Lob
	private byte[] question_img;
}
