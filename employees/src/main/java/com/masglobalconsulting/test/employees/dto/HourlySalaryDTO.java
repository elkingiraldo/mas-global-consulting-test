package com.masglobalconsulting.test.employees.dto;

import com.masglobalconsulting.test.employees.commons.Constants;
import com.masglobalconsulting.test.employees.service.salary.ISalary;
import com.masglobalconsulting.test.employees.service.salary.SalaryFactory;

/**
 * Employee DTO with the respective salary
 * 
 * @author elkin.giraldo
 *
 */
public class HourlySalaryDTO extends EmployeeDTO {

	private double hourlySalary;
	private double anualSalary;

	public HourlySalaryDTO(int id, String name, String contractTypeName, int roleId, String roleName,
			String roleDescription, double hourlySalary) {
		super(id, name, contractTypeName, roleId, roleName, roleDescription);
		this.hourlySalary = hourlySalary;
		setAnualSalary(hourlySalary);
	}

	public double getAnualSalary() {
		return anualSalary;
	}

	private void setAnualSalary(double employeeHourlySalary) {
		SalaryFactory factory = new SalaryFactory();
		ISalary salary = factory.getSalary(Constants.HOURLY_CONTRACT_NAME);
		double employeeAnualSalary = salary.getAnualSalary(employeeHourlySalary);

		this.anualSalary = employeeAnualSalary;
	}

	public double getMonthlySalary() {
		return hourlySalary;
	}

	public void setMonthlySalary(double hourlySalary) {
		this.hourlySalary = hourlySalary;
	}

}
