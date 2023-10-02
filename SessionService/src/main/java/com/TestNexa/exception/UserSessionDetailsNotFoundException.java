package com.TestNexa.exception;


public class UserSessionDetailsNotFoundException extends RuntimeException {

	public UserSessionDetailsNotFoundException(String msg) {
		super(msg);
	}

	public UserSessionDetailsNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
