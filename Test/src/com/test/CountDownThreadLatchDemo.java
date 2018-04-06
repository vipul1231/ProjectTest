package com.test;

import java.util.concurrent.CountDownLatch;

public class CountDownThreadLatchDemo implements Runnable{
	
	CountDownLatch latch;
	
	
	public CountDownThreadLatchDemo(CountDownLatch latch) {
		// TODO Auto-generated constructor stub
		this.latch = latch;
	}

	public static void main(String[] args){
		CountDownLatch latch = new CountDownLatch(3);
		CountDownThreadLatchDemo obj = new CountDownThreadLatchDemo(latch);
		Thread th1 = new Thread(obj);
		Thread th2 = new Thread(obj);
		Thread th3 = new Thread(obj);
		th1.start();
		th2.start();
		th3.start();
	}

	@Override
	public void run() {
		System.out.println("Thread :"+Thread.currentThread().getName()+" is at barrier.");
		latch.countDown();
		latch.countDown();
		latch.countDown();
		System.out.println("Barrier crossed");
		
	}
	

}
