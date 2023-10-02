package com.TestNexa.exception;

public class QuestionNotFoundException extends RuntimeException {

	public QuestionNotFoundException(String msg) {
		super(msg);
	}

	public QuestionNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
