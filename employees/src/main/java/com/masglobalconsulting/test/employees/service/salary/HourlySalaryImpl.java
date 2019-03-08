package com.masglobalconsulting.test.employees.service.salary;

public class HourlySalaryImpl implements ISalary {

	@Override
	public double getAnualSalary(double salaryRelated) {
		return 120*salaryRelated*12;
	}

}
