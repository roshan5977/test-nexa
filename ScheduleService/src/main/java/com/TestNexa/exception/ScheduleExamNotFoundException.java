package com.TestNexa.exception;

public class ScheduleExamNotFoundException extends RuntimeException {

	public ScheduleExamNotFoundException(String str) {
		super(str);
	}

	public ScheduleExamNotFoundException(String str, Throwable cause) {
		super(str, cause);
	}
}
