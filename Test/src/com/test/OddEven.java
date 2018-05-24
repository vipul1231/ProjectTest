package com.test;

public class OddEven implements Runnable{

	Object lock = new Object();
	
	boolean odd = false ,even = false;
	
	int count = 0;
	
	public static void main(String[] args){
		OddEven oddEven = new OddEven();
		Thread thOdd = new Thread(oddEven);
		Thread thEven = new Thread(oddEven);
		
		thOdd.start();
		thEven.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try{
			while(count!=50){
				synchronized (lock) {

					if(odd == false){
						count++;
						System.out.println(count+" "+Thread.currentThread().getName());
						odd = true;
						even = false;
						lock.notify();
						lock.wait();
					}
					
					else if(odd == true && even == false){
						count++;
						System.out.println(count+" "+Thread.currentThread().getName());
						even = true;
						odd = false;
						lock.notify();
						lock.wait();
					}
				}	
			}	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
