package com.masglobalconsulting.test.employees.service;

import java.util.List;

import com.masglobalconsulting.test.employees.dto.EmployeeDTO;
import com.masglobalconsulting.test.employees.exception.EmployeeServiceException;

public interface IEmployeeService {

	public List<EmployeeDTO> getAllEmployees() throws EmployeeServiceException;

	public EmployeeDTO getEmployeeById(int id) throws EmployeeServiceException;

}
