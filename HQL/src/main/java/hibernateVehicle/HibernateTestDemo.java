package hibernateVehicle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import persistance.HibernateUtil;

public class HibernateTestDemo {
	
	public static void main(String[] args)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Vehicle vehicle = new Vehicle();
		
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Bike");
		twoWheeler.setStreeingTwoWheeler("Bike Streeing Handle");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("Car");
		fourWheeler.setStreeingTwoWheeler("Car Streeing Handle");
		
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
