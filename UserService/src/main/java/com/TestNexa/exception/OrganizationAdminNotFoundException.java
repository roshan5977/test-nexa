package com.TestNexa.exception;

public class OrganizationAdminNotFoundException extends RuntimeException{

	public OrganizationAdminNotFoundException(String msg) {
		super(msg);
	}
	public OrganizationAdminNotFoundException(String msg,Throwable cause) {
		super(msg,cause);
	}
}
