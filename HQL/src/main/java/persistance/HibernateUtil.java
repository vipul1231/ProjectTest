package persistance;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	  private static final SessionFactory sessionFactory = buildSessionFactory();

	    private static SessionFactory buildSessionFactory() {
	        try {
	        	
	        	return new Configuration().configure("hibernate.cfg3.xml").buildSessionFactory();
	        	//cf.configure("hibernate.cfg.xml");
	        	//System.out.println("Building session factory");
	        	//return cf.buildSessionFactory();
	        }
	        catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	    
	    public static void shutdown() {
	    	// Close caches and connection pools
	    	getSessionFactory().close();
	    }

}
