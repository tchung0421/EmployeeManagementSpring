package com.snva.ems.service;

import com.snva.ems.bean.Employee;
import com.snva.ems.service.exception.EmployeeServiceException;

import java.util.List;

/**
 * IEmployeeService is an interface which defines various abstract functions
 * for the service layer.
 */
public interface IEmployeeService
{
	public void addNewEmployee(Employee employee);
	public void removeEmployeeByName(List<Employee> employeelist);
	public List<Employee> showAllEmployeeInformation() throws EmployeeServiceException;
	
}
