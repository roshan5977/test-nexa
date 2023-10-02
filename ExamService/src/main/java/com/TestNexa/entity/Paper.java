package com.TestNexa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Paper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paper_id;
	private String paper_name;
	private String paper_subject;
	private Long paper_duration;
	private Long paper_NoOfQuestions;
	private Long paper_TotalMark;
	private String paper_description;
	private String org_code;
	private String need_random;
	private Boolean autosubmit_enable;

}
