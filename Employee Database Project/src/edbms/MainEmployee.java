package edbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;
public class MainEmployee {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		EmployeeManagementSystem ems = new EmployeeManagementSystemImpl();
		
		while(true) {
			System.out.println("1. Add Employee\n2. Display Employee\n3. Display All Employees");
			System.out.println("4. Remove Employee\n5. Remove All Employees\n6. Update Employee");
			System.out.println("7. Count Employees\n8. Sort Employees");
			System.out.println("9. Employee with highest Salary\n10. Employee with lowest Salary\n11. Exit");
			System.out.println("Enter the Choice");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:ems.addEmployee();
				break;
			case 2:ems.displayEmployee();
			break;
			case 3:ems.displayAllEmployees();
			break;
			case 4:ems.removeEmployee();
			break;
			case 5:ems.removeAllEmployees();
			break;
			case 6:ems.updateEmployee();
			break;
			case 7:ems.countEmployees();
			break;
			case 8:ems.sortEmployees();
			break;
			case 9:ems.employeeWithHighestSalary();
			break;
			case 10:ems.employeeWithLowestSalary();
			break;
			case 11:System.out.println("Thank You!!!");
			System.exit(0);
			default:try {
				throw new InvalidChoiceException("Invalid Choice Entered, Kindly Enter the Valid Choice");
			}
			catch(InvalidChoiceException e) {
				System.out.println(e.getMessage());
			}
			}
			System.out.println("--------------------------------");
		}
	}

}
