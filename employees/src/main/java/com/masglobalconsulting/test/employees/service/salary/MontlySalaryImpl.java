package com.masglobalconsulting.test.employees.service.salary;

public class MontlySalaryImpl implements ISalary {

	@Override
	public double getAnualSalary(double salaryRelated) {
		return salaryRelated*12;
	}

}
