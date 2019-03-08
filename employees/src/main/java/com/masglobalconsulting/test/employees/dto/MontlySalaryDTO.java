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
public class MontlySalaryDTO extends EmployeeDTO {

	private double monthlySalary;
	private double anualSalary;

	public MontlySalaryDTO(int id, String name, String contractTypeName, int roleId, String roleName,
			String roleDescription, double monthlySalary) {
		super(id, name, contractTypeName, roleId, roleName, roleDescription);
		this.monthlySalary = monthlySalary;
		setAnualSalary(monthlySalary);
	}

	public double getAnualSalary() {
		return anualSalary;
	}

	private void setAnualSalary(double employeeMonthlySalary) {
		SalaryFactory factory = new SalaryFactory();
		ISalary salary = factory.getSalary(Constants.MONTHLY_CONTRACT_NAME);
		double employeeAnualSalary = salary.getAnualSalary(employeeMonthlySalary);

		this.anualSalary = employeeAnualSalary;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

}
