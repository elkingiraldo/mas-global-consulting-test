package com.masglobalconsulting.test.employees.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masglobalconsulting.test.employees.commons.Constants;
import com.masglobalconsulting.test.employees.dto.EmployeeDTO;
import com.masglobalconsulting.test.employees.dto.HourlySalaryDTO;
import com.masglobalconsulting.test.employees.dto.MonthlySalaryDTO;
import com.masglobalconsulting.test.employees.entity.EmployeeEntity;
import com.masglobalconsulting.test.employees.exception.EmployeeServiceErrorCodes;
import com.masglobalconsulting.test.employees.exception.EmployeeServiceException;
import com.masglobalconsulting.test.employees.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepo;

	public List<EmployeeDTO> getAllEmployees() throws EmployeeServiceException {

		List<EmployeeEntity> dBEmployeeList = employeeRepo.retrieveAllEmployees();
		List<EmployeeDTO> EmployeeListToReturn = new ArrayList<EmployeeDTO>();

		if (dBEmployeeList.size() == 0) {
			return EmployeeListToReturn;
		}

		for (EmployeeEntity entity : dBEmployeeList) {
			EmployeeListToReturn.add(handleReturnDTO(entity));
		}

		return EmployeeListToReturn;
	}

	public EmployeeDTO getEmployeeById(int id) throws EmployeeServiceException {
		EmployeeEntity specificEmployee = employeeRepo.findEmployeeById(id);
		if (specificEmployee == null) {
			throw new EmployeeServiceException(EmployeeServiceErrorCodes.EMPLOYEE_NOT_FOUND);
		} else {
			return handleReturnDTO(specificEmployee);
		}
	}

	private EmployeeDTO handleReturnDTO(EmployeeEntity entity) {
		if (entity.getContractTypeName().equalsIgnoreCase(Constants.HOURLY_CONTRACT_NAME)) {
			return new HourlySalaryDTO(entity.getId(), entity.getName(), entity.getContractTypeName(),
					entity.getRoleId(), entity.getRoleName(), entity.getRoleDescription(), entity.getHourlySalary());
		} else {
			return new MonthlySalaryDTO(entity.getId(), entity.getName(), entity.getContractTypeName(),
					entity.getRoleId(), entity.getRoleName(), entity.getRoleDescription(), entity.getMonthlySalary());
		}
	}

}
