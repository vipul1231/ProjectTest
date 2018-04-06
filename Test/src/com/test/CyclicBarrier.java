package com.test;

import java.util.concurrent.BrokenBarrierException;

public class CyclicBarrier implements Runnable{

	java.util.concurrent.CyclicBarrier cyclicBarrier;
	
	
	public CyclicBarrier(java.util.concurrent.CyclicBarrier cyclicBarrier) {
		// TODO Auto-generated constructor stub
		this.cyclicBarrier = cyclicBarrier;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		try {
			System.out.println("Waiting for all thread to join."+Thread.currentThread().getName());
			
			cyclicBarrier.await();
			
			System.out.println("Barrier has crossed."+Thread.currentThread().getName());
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args){
	
		java.util.concurrent.CyclicBarrier obj = new java.util.concurrent.CyclicBarrier(3, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Cyclic Barrier is tripped.");
			}
		});
		
		
		Thread th1 = new Thread(new CyclicBarrier(obj),"Thread 1");
		Thread th2 = new Thread(new CyclicBarrier(obj),"Thread 2");
		Thread th3 = new Thread(new CyclicBarrier(obj),"Thread 3");
		
		th1.start();
		th2.start();
		th3.start();
		
	}
}
