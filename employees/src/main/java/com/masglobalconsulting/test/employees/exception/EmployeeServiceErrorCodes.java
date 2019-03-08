package com.masglobalconsulting.test.employees.exception;

import org.springframework.http.HttpStatus;

/**
 * Errors found into the service
 * 
 * @author elkin.giraldo
 *
 */
public enum EmployeeServiceErrorCodes implements IEmployeeServiceErrorMsg {
	
	GENERAL_EXCEPTION("general.exception", HttpStatus.INTERNAL_SERVER_ERROR),
	FAIL_TO_RETRIEVE_EMPLOYEES("employee.repository.fail.to.retrieve.employee", HttpStatus.INTERNAL_SERVER_ERROR);
	
	private String message;
	private HttpStatus httpStatus;
	private String errorDetail;

	private EmployeeServiceErrorCodes(String message, HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	private EmployeeServiceErrorCodes(String message, String errorDetail, HttpStatus httpStatus) {
		this.message = message;
		this.errorDetail = errorDetail;
		this.httpStatus = httpStatus;
	}

	private EmployeeServiceErrorCodes(String message) {
		this.message = message;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
