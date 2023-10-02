package com.TestNexa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_answer_id;
	private Long question_id;
	private Boolean is_correct;
	private String answer_text;
	private Long mark_obtained;
	private Long user_id;
	private Long paper_id;
}
