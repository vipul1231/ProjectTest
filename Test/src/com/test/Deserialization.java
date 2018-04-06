package com.test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserialization {
	
	public static void main(String[] args)
	{
		try {
			FileInputStream fileInput = new FileInputStream("employee.ser");
			ObjectInputStream objectIn = new ObjectInputStream(fileInput);
			Employee employee = (Employee) objectIn.readObject();
			System.out.println("Department"+ employee.getDepartment()+" Name: "+employee.getName()+" Employee: "+employee.getEmployeeId());
			objectIn.close();
			fileInput.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
