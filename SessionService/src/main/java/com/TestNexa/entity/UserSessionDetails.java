package com.TestNexa.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserSessionDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_session_id;
	private LocalDateTime login_time;
	private LocalDateTime logout_time;
	private Boolean status;
	private Long paper_id;
	private String org_code;
	private Long schedule_id;
	private Long user_id;
	private LocalDateTime schedule_exam_end_time;
	private Long paper_duration;
}
