package testFunctionality;

import java.io.Serializable;

public class Employee extends Person implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7871232405201321959L;
	
	
	int employeeNo;
	String Name;
	String Department;
	String project;
	transient Address Address;
	
	public Address getAddress() {
		return Address;
	}
	public void setAddress(Address address) {
		Address = address;
	}
	public int getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	@Override
	void eat() {
		// TODO Auto-generated method stub
		
	}
	

}
