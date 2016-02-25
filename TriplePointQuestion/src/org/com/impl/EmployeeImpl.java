package org.com.impl;

import org.com.interfaces.Employee;

/**
 * Impl class for Employee
 * 
 * @author vipult
 *
 */
public class EmployeeImpl implements Employee{
	
	/**
	 * Employee Name
	 */
	String empName;
	
	/**
	 * Employee Designation
	 */
	String empDesignation;
	
	/**
	 * Constructor
	 * 
	 * @param aInName
	 * @param aInDesignation
	 */
	public EmployeeImpl(String aInName, String aInDesignation) {
		this.empName = aInName;
		this.empDesignation = aInDesignation;
	}
	
	@Override
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
}
