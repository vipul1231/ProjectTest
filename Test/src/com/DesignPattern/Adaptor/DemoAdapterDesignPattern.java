package com.DesignPattern.Adaptor;


interface Vehicle {
	String getEmployeeId();
	String vehicleName();
}

interface Employee {
	String getName();
	String getEmployeeId();
}

class EmpImpl implements Employee {
	
	String name;
	String employeeId;
	
	public EmpImpl(String employeeId,String name) {
		this.name = name;
		this.employeeId = employeeId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getEmployeeId() {
		return employeeId;
	}
}

class VehicleImpl implements Vehicle {
	String employeeId;
	String vehicleName;
	
	public VehicleImpl(String empId, String vehicleName) {
		
		this.employeeId = empId;
		this.vehicleName = vehicleName;
	}

	@Override
	public String getEmployeeId() {
		return employeeId;
	}

	@Override
	public String vehicleName() {
		return vehicleName;
	}
}

class VehicleToEmployeeAdapter implements Vehicle{
	
	Employee employee;
	
	
	public  VehicleToEmployeeAdapter(Employee emp) {
		// TODO Auto-generated constructor stub
		this.employee = emp;
	}

	@Override
	public String getEmployeeId() {
		// TODO Auto-generated method stub
		return employee.getEmployeeId();
	}

	@Override
	public String vehicleName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}


public class DemoAdapterDesignPattern {
	
	public static void main(String[] args){
		Vehicle vehicle1 = new VehicleImpl("122asd", "Tata Veara");
		Vehicle vehicle2 = new VehicleImpl("122asq", "Tata Safari");
		
		Employee employee1 = new EmpImpl("122asd", "Suraj Deshmukh");
		Employee employee2 = new EmpImpl("122asq", "Vipul Tiwari");
		
		
	}
}
