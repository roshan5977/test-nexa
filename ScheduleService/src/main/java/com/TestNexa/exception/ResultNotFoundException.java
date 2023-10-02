package com.TestNexa.exception;

public class ResultNotFoundException extends RuntimeException {

	public ResultNotFoundException(String str) {
		super(str);
	}

	public ResultNotFoundException(String str, Throwable cause) {
		super(str, cause);
	}
}
