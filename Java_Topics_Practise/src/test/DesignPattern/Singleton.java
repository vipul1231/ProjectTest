package test.DesignPattern;

/**
 * 
 * @author Vipul_Anky
 *
 */
public class Singleton {

    //private static Singleton INSTANCE = null;

    private Singleton() {

    }
    
    // Stop from creating the clone.
    protected Object clone() {	
	return SingletonHelper.INSTANCE;
    }
    
    // This method stop creating object while serialization.
    protected Object readResolve() {
	return SingletonHelper.INSTANCE;
    }
    
    static class SingletonHelper {
	private static final Singleton INSTANCE = new Singleton();
    }
    
    public static Singleton getInstance() {
	return SingletonHelper.INSTANCE;
    }

//    public static Singleton getInstance() {
//
//	synchronized (Singleton.class) {
//	    if (INSTANCE == null) {
//		synchronized (Singleton.class) {
//		    INSTANCE = new Singleton();
//			return INSTANCE;    
//		}
//	    }
//
//	    else {
//		return INSTANCE;
//	    }
//	}
//    }
    
    
//	This way we can create singleton through ENUM.
//    private enum Singleton1 {
//	INSTANCE;
//    }
}
