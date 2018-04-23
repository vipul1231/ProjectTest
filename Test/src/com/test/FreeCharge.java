package com.test;

public class FreeCharge implements Runnable{
	
	private boolean welcome;
	private boolean to;
	private boolean freecharge;
	private boolean start = true;
	
	public static void main(String[] args){
	
		FreeCharge freeCharge = new FreeCharge();
		
		Thread th1 = new Thread(freeCharge,"t1");
		Thread th2 = new Thread(freeCharge,"t2");
		Thread th3 = new Thread(freeCharge,"t3");
		
		th1.start();
		th2.start();
		th3.start();
	}

	@Override
	public void run() {
		
		
		while(true){
			synchronized (this) {
				//Welcome to FreeCharge.
				//First 
				try {
					if((welcome == false && start == true) || freecharge == true){
						welcome = true;
						freecharge = false;
						start = false;
						System.out.print("Welcome ");
						notifyAll();
						this.wait();
						
					}
					
					//Second
					if(welcome == true && to == false){
						welcome = false;
						to = true;
						System.out.print("To ");
						notifyAll();
						this.wait();
					}
					
					//Third
					if(to == true && freecharge == false){
						to = false;
						freecharge = true;
						System.out.print("Freecharge ");
						System.out.println("\n");
						notifyAll();
						this.wait();
					}	
				}
				
				catch(Exception e) {
					
				}
			}	
		}
	}
}
