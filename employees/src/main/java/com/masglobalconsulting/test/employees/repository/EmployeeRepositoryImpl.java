package com.masglobalconsulting.test.employees.repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.google.gson.Gson;
import com.masglobalconsulting.test.employees.commons.Constants;
import com.masglobalconsulting.test.employees.entity.EmployeeEntity;
import com.masglobalconsulting.test.employees.exception.EmployeeServiceErrorCodes;
import com.masglobalconsulting.test.employees.exception.EmployeeServiceException;

/**
 * This class takes information from MAS API and transform it as a own
 * repository
 * 
 * @author elkin.giraldo
 *
 */
public class EmployeeRepositoryImpl implements IEmployeeRepository {

	public List<EmployeeEntity> retrieveAllEmployees() throws EmployeeServiceException {
		List<EmployeeEntity> employeeList = new ArrayList<EmployeeEntity>();
		try {
			URL url = new URL(Constants.MAS_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != HttpStatus.OK.value()) {
				throw new EmployeeServiceException(EmployeeServiceErrorCodes.FAIL_TO_RETRIEVE_EMPLOYEES);
			}

			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);

			String output;
			while ((output = br.readLine()) != null) {
				employeeList = takeInformationFromJson(output);
			}
			conn.disconnect();
		} catch (Exception e) {
			throw new EmployeeServiceException(EmployeeServiceErrorCodes.FAIL_TO_RETRIEVE_EMPLOYEES);
		}
		return employeeList;
	}

	public EmployeeEntity findEmployeeById(int id) throws EmployeeServiceException {
		List<EmployeeEntity> employeeList = retrieveAllEmployees();
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getId() == id) {
				return employeeList.get(i);
			}
		}
		return null;
	}

	private List<EmployeeEntity> takeInformationFromJson(String output) {
		Gson gson = new Gson();
		EmployeeEntity[] employeeArray = gson.fromJson(output, EmployeeEntity[].class);
		List<EmployeeEntity> employeeList = Arrays.asList(employeeArray);
		return employeeList;
	}

}
