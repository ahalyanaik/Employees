package edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.EmployeeNotFoundException;
import customexception.InvalidChoiceException;
import customsorting.*;

public class EmployeeManagementSystemImpl implements EmployeeManagementSystem{
	Scanner scan = new Scanner(System.in);
	Map<String, Employee> db = new LinkedHashMap<String, Employee>();

	@Override
	public void addEmployee() {
		System.out.println("Enter Name: ");
		String name = scan.next();
		System.out.println("Enter Age: ");
		int age = scan.nextInt();
		System.out.println("Enter Salary: ");
		double salary = scan.nextDouble();
		Employee e = new Employee(name, age, salary);
		db.put(e.getId(), e);
		System.out.println("Employee Record Inserted Successfully");
		System.out.println("Your Id is: "+e.getId());
	}

	@Override
	public void displayEmployee() {
		System.out.println("Enter the Employee Id: ");
		String id = scan.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println(db.get(id));
		}
		else {
			try {
				throw new EmployeeNotFoundException("Employee with "+id+" is Not Found to Display");
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllEmployees() {

		if(!db.isEmpty()) {
			System.out.println("Employee Details are as Follows:");
			System.out.println("-------------------------------");
			Set<String> keys = db.keySet();
			for(String key:keys) {
				System.out.println(db.get(key));
			}
		}
		else {
			try {
				throw new EmployeeNotFoundException("No Employee Records Found to Display");
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}		
	}

	@Override
	public void removeEmployee() {
		System.out.println("Enter the Employee Id: ");
		String id = scan.next().toUpperCase();
		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("Employee Record with "+id+" is Deleted Successfully");
		}
		else {
			try {
				throw new EmployeeNotFoundException("Employee with the id "+id+" is not Found");
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllEmployees() {
		if(!db.isEmpty()) {
			db.clear();
			System.out.println("Emplyee Records Deleted Successfuly");
		}
		else {
			try {
				throw new EmployeeNotFoundException("No Employee Records Found to delete");
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void updateEmployee() {
		System.out.println("Enter the Employee Id: ");
		String id = scan.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("1. Update Employee Name: \n2. Update Employee Age: \n3. Update Employee Salary: ");
			System.out.println("Enter the Choice: ");
			int choice = scan.nextInt();
			switch(choice) {
			case 1: System.out.println("Enter the Name: ");
			String name = scan.next();
			db.get(id).setName(name);
			break;

			case 2: System.out.println("Enter the Age: ");
			int age = scan.nextInt();
			db.get(id).setAge(age);
			break;

			case 3: System.out.println("Enter the Salary: ");
			double salary = scan.nextDouble();
			db.get(id).setSalary(salary);
			break;

			default:try {
				throw new InvalidChoiceException("Invalid Choice Entered, Kindly Enter the Valid Choice");
			}
			catch(InvalidChoiceException e) {
				System.out.println(e.getMessage());
			}
			}
		}
		else {
			try {
				throw new EmployeeNotFoundException("Employee with the id "+id+" is not Found");
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countEmployees() {
		System.out.println("No of Employee Records Present: "+db.size());
	}

	@Override
	public void sortEmployees() {
		Set<String> keys = db.keySet();
		List<Employee> l = new ArrayList<Employee>();
		for(String key:keys) {
			Employee e = db.get(key);
			l.add(e);
		}
		System.out.println("1. Sort Employee By Id\n2. Sort Employee By Name\n3. Sort Employee By Age");
		System.out.println("4. Sort Employee By Salary\n Enter the Choice: ");
		int choice = scan.nextInt();
		switch(choice) {
		case 1:Collections.sort(l, new SortEmployeeById());
		for(Employee e:l)
			System.out.println(e);
		break;

		case 2:Collections.sort(l, new SortEmployeeByName());
		for(Employee e:l)
			System.out.println(e);
		break;

		case 3:Collections.sort(l, new SortEmployeeByAge());
		for(Employee e:l)
			System.out.println(e);
		break;

		case 4:Collections.sort(l, new SortEmployeeBySalary());
		for(Employee e:l)
			System.out.println(e);
		break;
		default:try {
			throw new InvalidChoiceException("Invalid Choice Entered, Kindly Enter the Valid Choice");
		}
		catch(InvalidChoiceException e) {
			System.out.println(e.getMessage());
		}
		}
	}

	@Override
	public void employeeWithHighestSalary() {
		Set<String> keys = db.keySet();
		List<Employee> l = new ArrayList<Employee>();
		for(String key:keys) {
			Employee e = db.get(key);
			l.add(e);
		}
		Collections.sort(l, new SortEmployeeBySalary());
		System.out.println(l.get(l.size()-1));
	}

	@Override
	public void employeeWithLowestSalary() {
		Set<String> keys = db.keySet();
		List<Employee> l = new ArrayList<Employee>();
		for(String key:keys) {
			Employee e = db.get(key);
			l.add(e);
		}
		Collections.sort(l, new SortEmployeeBySalary());
		System.out.println(l.get(0));
	}
}
