package com.test;

class WrongHashCode implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		InterruptTest obj = new InterruptTest();
		obj.m1();
	}
}

public class InterruptTest {
	
	
	public static void m1(){
		System.out.println("Inside M1 "+Thread.currentThread().getName());
	}
	
	
	public static synchronized void main(String[] args){
		System.out.println("Main Thread" + Thread.currentThread().getName());
		Thread th1 = new Thread(new WrongHashCode());
		th1.start();
		
		System.out.println("Main Ends" + Thread.currentThread().getName());
		
	}
}

