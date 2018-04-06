package com.DesignPattern.Singleton;

public class Singleton {
	
	private Singleton(){
	}
	
	private static class SingletonHelper{
		private static final Singleton INSTANCE = new Singleton();
	}
	
	public Singleton getInstance(){
		return SingletonHelper.INSTANCE;
	}
	
	protected Object readResolve(){
		return SingletonHelper.INSTANCE;
	}
	
	
	protected Object clone() throws CloneNotSupportedException{
		return SingletonHelper.INSTANCE;
	}
	
	public boolean equals(Object obj){
		
		if(obj==null){
			return false;
		}
		
		else if(!(obj instanceof Singleton)){
			return false;
		}
		
		else {
			Singleton obj1 = (Singleton) obj;
			if(this == obj1 || this.equals(obj1)){
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Singleton obj = new Singleton();
		System.out.println(obj.getInstance());
		System.out.println(obj.getInstance());
	}
	
	
	
//	public Singleton getInstance(){
//		
//		if(instance == null){
//			
//			instance = new Singleton();
//			return instance;
//		}
//		else {
//			return instance;
//		}
//		
//	}
	
}
