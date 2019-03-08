package com.masglobalconsulting.test.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masglobalconsulting.test.employees.dto.EmployeeDTO;
import com.masglobalconsulting.test.employees.exception.EmployeeServiceException;
import com.masglobalconsulting.test.employees.service.IEmployeeService;

@RestController
@RequestMapping("/api/employees/v1.0")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping
	public List<EmployeeDTO> getAll() throws EmployeeServiceException {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/id")
	public EmployeeDTO getById(@PathVariable int id) throws EmployeeServiceException {
		return employeeService.getEmployeeById(id);
	}

}
