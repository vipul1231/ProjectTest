package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClass implements Runnable {

	Object lock = new Object();
	static volatile int count =0;

	@Override
	public void run() {	
		while(count!=50){
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName()+ " "+count);
				count++;
				lock.notify();
				try {
					lock.wait();
					System.out.println("Resumes: "+Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}

	public static void main(String[] args) {
		TestClass obj = new TestClass();

		Thread th1 = new Thread(obj);
		Thread th2 = new Thread(obj);
		
		th1.start();
		th2.start();
		ExecutorService executor = Executors.newFixedThreadPool(1);
		
		executor.submit(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Run this method");
			}
		});
		
		Runnable runnable = () -> {
			System.out.println("Lambda Run method");
		};
		executor.submit(runnable);
		
		Thread th4 = new Thread(() -> System.out.println("Thread"));
		th4.start();
		
		executor.shutdown();
		
//		try {
//			th1.join();
//			th2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
