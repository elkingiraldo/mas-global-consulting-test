package com.masglobalconsulting.test.employees.exception;

public class EmployeeServiceException extends Exception {
	
	private static final long serialVersionUID = -1722016220373726063L;

	private final EmployeeServiceErrorCodes code;

	public EmployeeServiceException(EmployeeServiceErrorCodes code) {
		super(code.getErrorDetail());
		this.code = code;
	}

	public EmployeeServiceException(String message, Throwable cause, EmployeeServiceErrorCodes code) {
		super(message, cause);
		this.code = code;
	}

	public EmployeeServiceException(String message, EmployeeServiceErrorCodes code) {
		super(message);
		this.code = code;
	}

	public EmployeeServiceException(Throwable cause, EmployeeServiceErrorCodes code) {
		super(code.getErrorDetail(), cause);
		this.code = code;
	}

	public EmployeeServiceErrorCodes getCode() {
		return code;
	}

}
