package com.masglobalconsulting.test.employees.entity;

public class EmployeeEntity {

	private int id;
	private String name;
	private String contractTypeName;
	private int roleId;
	private String roleName;
	private String roleDescription;
	private double hourlySalary;
	private double monthlySalary;

	public EmployeeEntity() {
	}

	public EmployeeEntity(int id, String name, String contractTypeName, int roleId, String roleName,
			String roleDescription, double hourlySalary, double monthlySalary) {
		super();
		this.id = id;
		this.name = name;
		this.contractTypeName = contractTypeName;
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.hourlySalary = hourlySalary;
		this.monthlySalary = monthlySalary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContractTypeName() {
		return contractTypeName;
	}

	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public double getHourlySalary() {
		return hourlySalary;
	}

	public void setHourlySalary(double hourlySalary) {
		this.hourlySalary = hourlySalary;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", contractTypeName=" + contractTypeName + ", roleId="
				+ roleId + ", roleName=" + roleName + ", roleDescription=" + roleDescription + ", hourlySalary="
				+ hourlySalary + ", monthlySalary=" + monthlySalary + "]";
	}

}
