package com.TestNexa.exception;

public class ExamAdminNotFoundException extends RuntimeException{

	public ExamAdminNotFoundException(String message) {
		super(message);
	}

	public ExamAdminNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
