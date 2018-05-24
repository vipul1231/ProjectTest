package com.DesignPattern.Revision;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.test.Anagram;

class Single {
	
	private static Single single = null;
	
	private Single(){
		if(Single.single != null){
			throw new InstantiationError("Not supported");
		}
	}
	
	//Double check locking.
	public static Single getInstance(){
		
		if(single == null){	
			synchronized (Single.class) {
				
				if(single == null){
					single = new Single();
				}		
			}
		}
		return single;
	}
	
	//Singleton through inner class.
	public static class SingleInstance{
		public static final Single INSTANCE = new Single();
	}
	
	public static Single returnStaticClassSingleInstance(){
		return SingleInstance.INSTANCE;
	}
	
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
	public void typeHello(){
		System.out.println("Hello World!");
		
	}
}


class ObjectCannotBeCloned extends Exception{

	private static final long serialVersionUID = 8228157978578534286L;

	public ObjectCannotBeCloned(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	
}

/**
 * Enum Singleton
 * @author vtiwari
 *
 */
enum Singleton {
	
	INSTANCE
}


public class SingletonDp {

	public static void main(String[] args){
		Single obj = Single.getInstance();
		System.out.println(obj);
		try {
			System.out.println(obj.clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Use reflection
		try {
			Class<Single> classReturned =(Class<Single>) Class.forName("com.DesignPattern.Revision.Single");
			Constructor[] cons = Single.class.getDeclaredConstructors();
			
			for(Constructor constructor : cons){
				constructor.setAccessible(true);
				try {
					Single single = (Single) constructor.newInstance();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
