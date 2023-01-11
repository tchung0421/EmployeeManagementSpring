package com.snva.ems;

import com.snva.ems.bean.Employee;
import com.snva.ems.uiservice.IEmployeeUIService;
import com.snva.ems.uiservice.IFileUiService;
import com.snva.ems.util.ReadUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *This is the Runner class
 */
public class Runner
{

	@Autowired
	private ReadUtil readUtil;

	@Autowired
	private IEmployeeUIService EmployeeUIService;

	@Autowired
	private IFileUiService FileUiService;

	/**
	 *This is a default constructor of the class
	 */
	/*public Runner() throws IOException {
		m_readUtil=new ReadUtil();
		m_EmployeeUIService=new EmployeeUIServiceImpl();
		m_FileUiService= new FileUiServiceImpl();
		checkUserOptions();
	}*/

	/**
	 *This function takes the user choice as the menu is displayed and
	 *call the functions accordingly.
	 *
	 */
	public void checkUserOptions() throws IOException {
		int choice=0;
		List<Employee> employeelist=new ArrayList<Employee>();
		do
		{
			displayMainMenu();
			choice= readUtil.readInt("Input Your choice","Input valid Choice");
			switch(choice)
			{
				case 1 : EmployeeUIService.AddNewEmployee();
						break;

				case 2 : EmployeeUIService.removeEmployee();
						break;

				case 3 : EmployeeUIService.showAllEmployee();
						break;

				case 4 :String name= readUtil.readString("Input Employee Name(or any part of name)","String cannot be empty");
						try{
							employeelist= EmployeeUIService.searchEmployeeByName(name);
							System.out.println();
						}catch(NullPointerException e){
							System.out.println("Emloyee not found");
						}						
						break;

				case 5 : EmployeeUIService.sortEmployee();
						break;

				case 6 : FileUiService.processFile();
		          		break;
				case 7: System.out.println("Goodbye");
				default : System.out.println("wrong choice");
			}
		}while(choice!=7);

	}
	/**
	 *This fuction displays the main menu of the system.
	 *
	 */

//	private String m_extension;
//	private String m_date;
//	private String m_totalCallTime;
//	private String m_totalCallNumber;
//	private String m_averageCall;
//	private String m_firstCall;
//	private String m_lastCall;

	private void displayMainMenu()
	{
		System.out.println("     Main Menu     ");
		System.out.println("-------------------");
		System.out.println("1. Add New Employee ");
		System.out.println("2. Remove An Employee ");
		System.out.println("3. Show All Employees Information ");
		System.out.println("4. Search An Employee ");
		System.out.println("5. Sort By First Name ");
		System.out.println("6. Read a Files & Clean it");
		System.out.println("7. Exit ");
	}

	/**
	 * This is the main fuction which runs the default constructor of the class.
	 */
	/*public static void main(String[] args) throws IOException {
		new Runner();
	}*/

}
