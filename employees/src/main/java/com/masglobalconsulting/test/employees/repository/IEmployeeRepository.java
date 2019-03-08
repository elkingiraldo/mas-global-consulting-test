package com.masglobalconsulting.test.employees.repository;

import java.util.List;

import com.masglobalconsulting.test.employees.entity.EmployeeEntity;
import com.masglobalconsulting.test.employees.exception.EmployeeServiceException;

public interface IEmployeeRepository {

	public List<EmployeeEntity> retrieveAllEmployees() throws EmployeeServiceException;
	
	public EmployeeEntity findEmployeeById(int id) throws EmployeeServiceException;

}
