package com.test;

import java.io.Serializable;

public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1287149254523389582L;
	int employeeId;
	String name;
	String Department;
	
	Employee(int employeeId, String name, String Department)
	{
		this.Department = Department;
		this.employeeId = employeeId;
		this.name = name;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
}
