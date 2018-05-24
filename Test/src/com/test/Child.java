package com.test;


class Parent extends Thread{
	public Parent() {
		// TODO Auto-generated constructor stub
		System.out.println("Parent");
	}
	
	public void run(){
		System.out.println("bar");
	}
	
	void help(){
		System.out.println("Help");
	}
}

public class Child{
	
	
	Child(){
		
	}
	
	void sum (String i){
		System.out.println("Int");
	}
	
	void sum(float f){
		System.out.println("Float");
	}
	
	protected static void sum(Integer i){
		System.out.println("Integer");
	}
	
	public static <E> void run(E e){
		System.out.println(e);
	}
	
	public static void main(String[] args){
		Parent p = new Parent(){
			public void run(){
				System.out.println("foo");
			}
		};
		
		p.start();
		
		Integer i1 = new Integer(14);
		Integer i2 = new Integer(14);
		
		System.out.println(i1.hashCode()+" "+i2.hashCode());
	}
}
