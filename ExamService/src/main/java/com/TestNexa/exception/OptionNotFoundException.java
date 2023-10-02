package com.TestNexa.exception;

public class OptionNotFoundException extends RuntimeException {

	public OptionNotFoundException(String msg) {
		super(msg);
	}

	public OptionNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
