package com.snva.ems.uiservice;

import com.snva.ems.bean.Employee;

import java.util.List;

/**
 * IEmployeeUIService is an interface which defines various abstract functions
 * for the UIService layer.
 */
public interface IEmployeeUIService
{
	public void AddNewEmployee();
	public void removeEmployee();
	public void showAllEmployee();
	public List<Employee> searchEmployeeByName(String name);
	public void sortEmployee();
}
