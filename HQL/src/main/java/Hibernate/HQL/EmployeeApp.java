package Hibernate.HQL;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.HibernateUtil;

public class EmployeeApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		sc.close();
		
		try
		{
			EmployeeApp emloyeeApp = new EmployeeApp();
			emloyeeApp.addEmployee("Manoj", "tiwari", 4000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	private void addEmployee(String firstname, String lastname, Integer salary)
	{
		Set<Certificate> set = new HashSet<Certificate>();
		Certificate cert = new Certificate("B.Tech");
		
		set.add(cert);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Employee emp = new Employee(firstname,lastname,salary);
		Address addr = new Address("175","delhi","delhi","122014");
		/*for(Certificate cert : set)
		{
			cert.setEmployee(emp);
		}*/
		
		cert.setEmployee(emp);
		emp.setAddress(addr);
		emp.setSet(set);
		session.save(emp);
		session.persist(emp);
		tx.commit();
		session.flush();;
		session.close();	
		//Now Fetch the object from database
		
				
	}
}
