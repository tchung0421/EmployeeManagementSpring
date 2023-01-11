package com.snva.ems.bean;

import java.util.Date;
import java.util.List;

/**
 *This is the employee bean.
 */
public class Employee
{
	private long employeeId;
	private String firstName;
	private String lastName;
	private String designation;
	private Double contactNumber;
	private Double salary;
	private Date dateOfBirth;
	private Date dateOfJoining;
	static int current_id=1;

	private List<Role> roles;

	public Employee() {
		employeeId = current_id++;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Double contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"employeeId=" + employeeId +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", designation='" + designation + '\'' +
				", contactNumber=" + contactNumber +
				", salary=" + salary +
				", dateOfBirth=" + dateOfBirth +
				", dateOfJoining=" + dateOfJoining +
				", roles=" + roles +
				'}';
	}
}
