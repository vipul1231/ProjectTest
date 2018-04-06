package com.test;



class Bound<T extends Abs>{

	private T objectRef;
	
	public Bound(T obj){
		this.objectRef = obj;
	}
	
	public void doRunTest(){
		this.objectRef.getMethod();
	}	
}

class superBound{
	
}

class Abs {
	
	void getMethod(){
		System.out.println("Method Abs");
	}
}

class A extends Abs{
	
	void getMethod(){
		System.out.println("Method A");
	}
}

class F extends Abs{
	
	void getMethod(){
		System.out.println("Method F");
	}
}

public class GenericDemo<T> {

	public static void main(String[] args) {
		
		Bound<A> bound  = new Bound<A>(new A());
		bound.doRunTest();
		
	}
}
