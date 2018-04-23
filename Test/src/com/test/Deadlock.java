package com.test;

public class Deadlock implements Runnable{
	
	Object lock1 = new Object();
	
	Object lock2 = new Object();
	
	public static void main(String[] args){
		Deadlock lock = new Deadlock();
		Thread th1 = new Thread(lock,"1");
		Thread th2 = new Thread(lock,"2");
		
		th1.start();
		th2.start();
	}

	@Override
	public void run() {
		
		
		if(Thread.currentThread().getName().equals("1")){
			
			synchronized (lock1) {
				
				System.out.println("Acquired on lock1.");
				
				synchronized (lock2) {
					
					System.out.println("Acquired on lock2.");
				}
			}	
		}
		
		else if(Thread.currentThread().getName().equals("2")){
			
			synchronized (lock2) {
				
				System.out.println("Acquired on lock1.");
				
				synchronized (lock1) {
					
					System.out.println("Acquired on lock2.");
				}
			}
		}
	}
}
