package com.multithreading;

public class Multithreading_1 implements Runnable{
	
	private void method1()
	{
		System.out.println("From Method 1."+Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void method2()
	{
		System.out.println("From Method 2."+Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void method3()
	{
		System.out.println("From static Method 3."+Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void method4()
	{
		System.out.println("From static Method 4."+Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		method1();
		method2();
		method3();
		method4();
	}
	
	public static void main(String[] args)
	{
		Multithreading_1 th1 = new Multithreading_1();
		Thread test_thread1 = new Thread(th1);
		test_thread1.setName("Thread 1");
		Thread test_thread2 = new Thread(th1);
		test_thread2.setName("Thread 2");
		test_thread1.start();
		test_thread2.start();
	}
}
