package org.com.testProject;

public class InterruptTesting extends Thread{
	
	 
		public void run(){  
		try{  
		Thread.sleep(4000);  
		System.out.println("task");  
		}catch(InterruptedException e){  
		throw new RuntimeException("Thread interrupted..."+e);  
		}  
		
		}  
		  
		public static void main(String args[]){  
			InterruptTesting t1=new InterruptTesting();  
		t1.start();  
		t1.interrupt();  
		}  
}
