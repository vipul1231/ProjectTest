package com.DesignPattern.ProducerConsumer;

import java.util.concurrent.atomic.AtomicInteger;

public class Alternate implements Runnable{
	
	
	AtomicInteger atm = new AtomicInteger(1);
	public static void main(String[] args) throws InterruptedException{
		
		Alternate obj = new Alternate();
		
		Thread th1 = new Thread(obj);
		Thread th2 = new Thread(obj);
		
		
		th2.start();
		
		th1.start();
		//th1.join();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (atm.get() !=100) {
			synchronized (this) {
				int value = atm.getAndIncrement();
				System.out.println(value + " " + Thread.currentThread().getName());
				this.notify();
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//this.notify();
			}
		}
		
		System.out.println("End");

//		for (int i = 0; i < 100; i++) {
//
//			synchronized (this) {
//				if (i % 2 == 0) {
//					System.out.println(i + " " + Thread.currentThread().getName());
//					i++;
//					this.notifyAll();
//					try {
//						this.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//
//				else {
//					System.out.println(i + " " + Thread.currentThread().getName());
//					i++;
//					this.notifyAll();
//					try {
//						this.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}

	}
	
	

}
