package Hibernate.HQL;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.HibernateUtil;

public class App {
	
	static Random number = new Random();
	
	 public static void main(String[] args)
	    {
		 	/*//first save the new object in RDBMS
	        System.out.println("Saving object to the database.");
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        
	        Transaction tx=  session.beginTransaction();
	        Stock stock = new Stock();
	        Integer integer = number.nextInt()%100; 
	        stock.setStockId(2);
	        stock.setStockCode("4716");
	        stock.setStockName("GENG");
	        
	        session.save(stock);
			tx.commit();
	        session.close();
	        */
	        //Now get the object from database once it is saved
	        System.out.println("Getting the data from the database.");
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        
	        session.beginTransaction();
	        
	        Query query = session.createQuery("From Stock");
	        
	        List<Stock> lStock = (List<Stock>)query.list();
	        
	        
	        for(int i=0;i<lStock.size();i++)
	        {
	        	System.out.println("Stock Id:" + lStock.get(i).getStockId());
		        System.out.println("Stock Code: "+lStock.get(i).getStockCode()+" Stock Name:"+lStock.get(i).getStockName());	
	        }
	               
	        session.close();
	        
	        
	        /*s.setStockName("Vipul");
	        
	        session.save(s);
	        session.flush();
	        
	        session.beginTransaction().commit();
	        
	        session.close();*/
	        
	        
	        
	        
	        
	        //Now delete that object from database
	        /*System.out.println("Deleting the data from the database.");
	        session = HibernateUtil.getSessionFactory().openSession();
	        
	        session.beginTransaction();
	        session.createSQLQuery("Select ID from stock");
	        
	        s = (Stock) session.get(Stock.class, new Integer(6));
	        System.out.println("Deleting the object: "+s);
	        session.delete(s);
	        session.flush();
	        session.beginTransaction().commit();
	        session.close();*/
	    }

}
