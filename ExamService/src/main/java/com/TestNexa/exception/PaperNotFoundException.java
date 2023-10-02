package com.TestNexa.exception;

public class PaperNotFoundException extends RuntimeException {

	public PaperNotFoundException(String msg) {
		super(msg);
	}

	public PaperNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
