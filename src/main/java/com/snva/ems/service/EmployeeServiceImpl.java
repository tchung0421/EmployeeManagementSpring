/**
 *
 */
package com.snva.ems.service;

import com.snva.ems.bean.Employee;
import com.snva.ems.service.exception.EmployeeServiceException;
import com.snva.ems.util.ReadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * This is an EmployeeService class that implements the interface IEmployeeService
 * and also defines all the function of the interface
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService
{
	@Autowired
	List<Employee> employeeList;

	@Autowired
	ReadUtil readUtil;
	/**
	 *This is a default constructor of the class which creates objects of
	 *all the instance variables of the class.
	 */
	/*public EmployeeServiceImpl()
	{
		employeelist = new ArrayList<Employee>();

		//m_readUtil=new ReadUtil();
	}*/
	/**
	 * This function adds a new employee to the list. It calls the in-built
	 * function add to add an employee to the list.
	 * @param employee parameter of the Employee bean.
	 * @exception UnsupportedOperationException Thrown to indicate that the
	 * requested operation is not supported.
	 * @exception ClassCastException Thrown to indicate that the code has attempted to
	 * cast an object to a subclass of which it is not an instance.
	 * @exception NullPointerException Thrown when an application attempts to use null
	 * in a case where an object is required.
	 * @exception IllegalArgumentException Thrown to indicate that a method has been
	 * passed an illegal or inappropriate argument
	 */
	public void addNewEmployee(Employee employee)
	{
		try
		{
		    employeeList.add(employee);

		}catch(UnsupportedOperationException e){
			System.out.println(e.getMessage());
		}catch(ClassCastException e){
			System.out.println(e.getMessage());
		}catch(NullPointerException e){
			System.out.println(e.getMessage());
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}

	}

	/**
	 *This function shows the information of all the employees.
	 *@return Returns the complete list of the employee.
	 *@exception EmployeeServiceException This exception is thrown when user want
	 *to see the employee detail but the list is empty.
	 */
	public List<Employee> showAllEmployeeInformation() throws EmployeeServiceException
	{
		if(employeeList.size()==0)
		{
			throw new EmployeeServiceException(EmployeeServiceException.NO_EMPLOYEE_FOUND);
		}
		return employeeList;
	}
	/**
	 * This function removes the complete employee detail searched by name. If more
	 * than one employee of same name exist than function removes the employee
	 * by the index in the list displayed to it.
	 * @param employeelist. Contains list of employees searched by the name given by user.
	 * @exception ConcurrentModificationException This exception may be thrown by methods that have detected concurrent
	 * modification of an object when such modification is not permissible.
	 * @exception IndexOutOfBoundsException Thrown to indicate that an index of some sort
	 * is out of range.
	 */
	public void removeEmployeeByName(List<Employee> employeelist1)
	{
		int index1=0;
		int size=employeelist1.size();
		try
		{
			if(size==1)
			{
				Employee employee=employeelist1.get(0);
				employeeList.remove(employee);
				System.out.println("Employee Removed successfully");
			}
			else
				{
					index1= readUtil.readInt("enter which number of employee you want to remove","enter correct value");
					index1=index1-1;
					Employee employee=employeelist1.get(index1);
					employeeList.remove(employee);
					System.out.println("Employee Removed successfully");
				}

		}catch(ConcurrentModificationException e){
			System.out.println(e.getMessage());
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
	}
}
