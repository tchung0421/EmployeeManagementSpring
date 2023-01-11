package com.snva.ems.uiservice;

import com.snva.ems.bean.Employee;
import com.snva.ems.service.exception.EmployeeServiceException;
import com.snva.ems.util.ReadUtil;
import com.snva.ems.service.EmployeeServiceImpl;
import com.snva.ems.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/**
 *This is an EmployeeUIServiceImpl class which implements the IEmployeeUIService
 *interface and defines all the abstract method of the interface.
 */
@Service
public class EmployeeUIServiceImpl implements IEmployeeUIService
{
	@Autowired
	private ReadUtil reader;

	@Autowired
	private IEmployeeService employeeService;

	/**
	 *This is the default constructor of the class which creates objects of
	 *all the instance variables of the class.
	 */
	public EmployeeUIServiceImpl()
	{
		reader = new ReadUtil();
		employeeService =new EmployeeServiceImpl();
	}
	/**
	 *This function read an employee detail and add that employee to the list.
	 */
	public void AddNewEmployee()
	{
		Employee employee=new Employee();
		employee.setFirstName(reader.readString("Input Your First name","String cannot be empty"));
		employee.setLastName(reader.readString("Input your Last name","Sring cannot be empty"));
		employee.setDesignation(reader.readString("Input Designation","String cannot be empty"));
		employee.setContactNumber(reader.readDouble("Input Contact number","Input correct values"));
		employee.setSalary(reader.readDouble("Input Your Salary","Input Correct Values"));
		employee.setDateOfBirth(reader.readDate("Input Date of Birth (DD-MM-YYYY)","enter valid date format(DD-MM-YYYY)"));
		employee.setDateOfJoining(reader.readDate("Input Date Of Joining (DD-MM-YYYY)","enter valid date format(DD-MM-YYYY)"));
		employeeService.addNewEmployee(employee);
	}
	/**
	 * This function remove an employee if the list contains that employee.
	 * It reads the employee name from the user and search for it in the list then
	 * make a call for removing that employee.
	 * @exception EmployeeServiceException This exception is thrown when user
	 * want to see the employee detail and the list is empty.
	 */
	public void removeEmployee(){
		List<Employee> employeelist1;

		try{
			List<Employee> employeelist= employeeService.showAllEmployeeInformation();
			employeelist1=new ArrayList<Employee>();
			String name = reader.readString("Enter Employee name(or any part of name) : ","String cannot be empty");
			employeelist1=searchEmployeeByName(name);
			employeeService.removeEmployeeByName(employeelist1);

		}catch(EmployeeServiceException e){
			System.out.println(e.getMessage());
		}catch(NullPointerException e){
			System.out.println("Emloyee not found with this name");
		}
	}
	/**
	 * This function shows the information of all the employee containing in the list.
	 * @exception EmployeeServiceException thrown when user want to see the employee
	 * detail and the list is empty.
	 */
	public void showAllEmployee()
	{
		try
		{
			List<Employee> employeelist= employeeService.showAllEmployeeInformation();
			System.out.println("All Employees Information : \n ");
			printList(employeelist);

		}catch(EmployeeServiceException e){
			System.out.println(e.getMessage());
		}
	}
	/**
	 * This function search an employee in the list by its name.
	 * @param Name. It can be first name,last name or full name of the employee
	 * @return List. Returns the list of employee having the name from which search is initiated.
	 * @exception EmployeeServiceException This exception is thrown when user
	 * want to see the employee detail and the list is empty.
	 * @exception StringIndexOutOfBoundException Thrown by String methods to
	 * indicate that an index is either negative or greater than the size of the
	 * string.
	 * @exception NullPointerException Thrown when an application
	 * attempts to use null in a case where an object is required.
	 */
	 public List<Employee> searchEmployeeByName(String name) throws NullPointerException {
		List<Employee> employeelist1 = null;
		try {
			name = name.toLowerCase();
			List<Employee> employeelist= employeeService.showAllEmployeeInformation();
			employeelist1 = new ArrayList<Employee>();
			Iterator<Employee> employeelistiterator= employeelist.iterator();
			while(employeelistiterator.hasNext()) {
				Employee employee=employeelistiterator.next();
				String fullName = (employee.getFirstName()+" "+employee.getLastName()).toLowerCase();
				if(fullName.contains(name))	{
					employeelist1.add(employee);
				}
			}
			printList(employeelist1);
		}catch(EmployeeServiceException e){
			System.out.println(e.getMessage());
		}
		if((employeelist1==null) || (employeelist1.size()==0))
			throw new NullPointerException();

		return employeelist1;
	}
	 /**
	  * This function sorts the complete list according to first name. It uses the
	  * another class which implements the comparator interface and
	  * its function compareTo().
	  * @exception EmployeeServiceException exception is thrown when user want to
	  * see the employee detail and the list is empty.
	  * @exception ClassCastException Thrown to indicate that the code has attempted
	  * to cast an object to a subclass of which it is not an instance.
	  * @exception UnsupportedOperationException Thrown to indicate that the requested
	  * operation is not supported.
	  */
	public void sortEmployee()
	{
		List<Employee> employeelist1=null;
		try
		 {
			List<Employee> employeelist= employeeService.showAllEmployeeInformation();
			employeelist1.addAll(employeelist);

			System.out.println(" Before Sorting ");
			System.out.println("---------------------");
			printList(employeelist);

			System.out.println(" After sorting ");
			System.out.println("---------------------");
			Collections.sort(employeelist1,new FirstNameCompare());
			printList(employeelist1);

		 }catch (EmployeeServiceException e){
			System.out.println(e.getMessage());
		 }catch(ClassCastException e){
			System.out.println(e.getMessage());
		 }catch(UnsupportedOperationException e){
			System.out.println(e.getMessage());
		 }
	 }

	/**
	 * This function prints the details of an Employee.
	 * @param employee Parameter of the employee bean.
	 */
	private void printInfo(Employee employee)
	{
		System.out.println("---------------------------------------");
		System.out.println("Employee ID  "+employee.getEmployeeId());
		System.out.println("First Name : "+employee.getFirstName());
		System.out.println("Last Name : "+employee.getLastName());
		System.out.println("Designation :"+employee.getDesignation());
		System.out.println("Salary : "+employee.getSalary());
		System.out.println("Date Of Birth : "+employee.getDateOfBirth());
		System.out.println("Date of Joining : "+employee.getDateOfJoining());
		System.out.println("-----------------------------------------");
		System.out.println();
	}
	/**
	 * This function prints the details of all Employee which are in the list.
	 * @param employeelist Parameter of the List(Employee bean).
	 */
	private void printList(List<Employee> employeelist)
	{
		Iterator<Employee> employeelistiterator=employeelist.iterator();
		while(employeelistiterator.hasNext())
		{
			Employee employee=employeelistiterator.next();
			System.out.println("---------------------------------------");
			System.out.println("Employee ID : "+employee.getEmployeeId());
			System.out.println("First Name : "+employee.getFirstName());
			System.out.println("Last Name : "+employee.getLastName());
			System.out.println("Designation : "+employee.getDesignation());
			System.out.println("Contact Number : "+employee.getContactNumber());
			System.out.println("Salary : "+employee.getSalary());
			System.out.println("Date Of Birth : "+employee.getDateOfBirth());
			System.out.println("Date Of Joining : "+employee.getDateOfJoining());
			System.out.println("-----------------------------------------");
			System.out.println();
		}
	}
}
