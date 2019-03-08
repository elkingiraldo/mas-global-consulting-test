package com.masglobalconsulting.test.employees.service.salary;

import com.masglobalconsulting.test.employees.commons.Constants;

public class SalaryFactory {

	public ISalary getSalary(String salaryType) {
		if(salaryType.equalsIgnoreCase(Constants.HOURLY_CONTRACT_NAME)) {
			return new HourlySalaryImpl();
		} else {
			return new MontlySalaryImpl();
		}
	}
	
}
