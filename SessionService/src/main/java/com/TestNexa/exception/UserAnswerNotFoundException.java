package com.TestNexa.exception;

public class UserAnswerNotFoundException extends RuntimeException {

	public UserAnswerNotFoundException(String msg) {
		super(msg);
	}

	public UserAnswerNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
