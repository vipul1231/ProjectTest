package testFunctionality;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
	
	public static void main(String[] args)
	{
		Serialization obj = new Serialization();
		obj.seralizeObject();
		obj.deseralizeObject();
		
	}
	
	private void seralizeObject()
	{
		Employee emp = new Employee();
		System.out.println("Serializing Object "+emp+". Hashcode: "+emp.hashCode());
		emp.setDepartment("CS");
		emp.setEmployeeNo(1234);
		emp.setName("Vipul");
		Address addr = new Address(234, "Sector 14", "Gurgaon");
		emp.setAddress(addr);
		
		try {
			FileOutputStream fileOut = new FileOutputStream("employee.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
			objectOut.writeObject(emp);
			objectOut.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void deseralizeObject()
	{
		
		Employee emp = null;
		try {
			FileInputStream fileInput = new FileInputStream("employee.ser");
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			
			emp = (Employee) objectInput.readObject();
			System.out.println("Deserializating Object "+emp+". Hashcode: "+emp.hashCode());
			objectInput.close();
			fileInput.close();
		} catch ( IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Employee ID: "+emp.getEmployeeNo());
		System.out.println("Employee Name: "+emp.getName());
		System.out.println("Employee Department: "+emp.getDepartment());
		System.out.println("Employee project: "+emp.project);
		
	}

}
