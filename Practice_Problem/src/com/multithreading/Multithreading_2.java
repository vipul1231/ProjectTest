package com.multithreading;

public class Multithreading_2 implements Runnable{
	
	public static final String THREAD_1 = "Thread 1";
	public static final String THREAD_2 = "Thread 2";
	public static final String THREAD_3 = "Thread 3";
	public static final String THREAD_4 = "Thread 4";
	
	public void method1()
	{
		synchronized (this) {
			System.out.println("Obtained lock on method 1");
			try {
				this.wait(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		System.out.println("Lock released from method 1");
	}
	
	public void method2()
	{
		synchronized (this) {
			System.out.println("Obtained lock on method 2");
			try {
				this.wait(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		System.out.println("Lock released from method 2");
	}
	
	public static void method3()
	{
		synchronized (Multithreading_2.class) {
			System.out.println("Obtained lock on method 3");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Lock released from method 3");
	}
	
	public static void method4()
	{
		synchronized (Multithreading_2.class) {
			System.out.println("Obtained lock on method 4");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		System.out.println("Lock released from method 4");
	}

	@Override
	public void run() {
		
		if(Thread.currentThread().getName().equals(THREAD_1))
		{
			System.out.println("Method 1 thread");
			method1();	
		}
	
		else if (Thread.currentThread().getName().equals(THREAD_2)) {
			System.out.println("Method 2 thread");
			method2();
		}
		
		if(Thread.currentThread().getName().equals(THREAD_3)){
			System.out.println("Acquiring lock on thread 3");
			method3();
		}
		
		else if (Thread.currentThread().getName().equals(THREAD_4)) {
			System.out.println("Acquiring lock on thread 4");
			method4();
		}
	}
	
	public static void main(String[] args){
		Multithreading_2 multithreading_2 = new Multithreading_2();
		//Multithreading_2 multithreading_2_1 = new Multithreading_2();
		Thread th1 = new Thread(multithreading_2);
		Thread th2 = new Thread(multithreading_2);
		
		Thread th3 = new Thread(multithreading_2);
		Thread th4 = new Thread(multithreading_2);
		th1.setName(THREAD_1);
		th2.setName(THREAD_2);
		
		th3.setName(THREAD_3);
		th4.setName(THREAD_4);
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}

}
