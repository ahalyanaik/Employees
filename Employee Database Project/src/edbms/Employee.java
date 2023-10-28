package edbms;

public class Employee {
	private String id;
	private String name;
	private Integer age;
	private Double salary;
	private static int count=101;
	
	public Employee(String name, int age, double salary) {
		id="KLE"+count;
		count++;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public Double getSalary() {
		return salary;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Id: "+id+" Name: "+name+" Age: "+age+" Salary: "+salary;
	}
}
