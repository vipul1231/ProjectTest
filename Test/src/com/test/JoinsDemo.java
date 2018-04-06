package com.test;

public class JoinsDemo implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Arrived thread: "+Thread.currentThread().getName());
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Exiting thread: "+Thread.currentThread().getName());
	}
	
	
	public static void main(String[] args){
	
		JoinsDemo join = new JoinsDemo();
		Thread th1 = new Thread(join,"One");
		Thread th2 = new Thread(join,"Two");
		Thread th3 = new Thread(join,"Three");
		
		
		try {
			th1.start();
			System.out.println("Thread Joins 1: "+Thread.currentThread().getName());
			th1.join();
			System.out.println("Thread Joins 2: "+Thread.currentThread().getName());
			th2.start();
			//th3.start();
			th2.join();
			System.out.println("Thread Joins 3: "+Thread.currentThread().getName());
			//th3.join();
			//System.out.println("Thread Joins 4: "+Thread.currentThread().getName());
			
			//th2.start();
//			th2.join();
//			th3.join();
		}
		catch(Exception e){
			
		}
		
		System.out.println("Main Thread Ends");
		
	}
}
