package com.test;


public class ThreadLocalTest implements Runnable{
	
	ThreadLocal<String> value = new ThreadLocal<String>(){
		protected String initialValue(){
			return "Hello";
		}
	};
	
	

	public static void main(String[] args){
		
		ThreadLocalTest obj = new ThreadLocalTest();
		
		for(int i=0;i<5;i++){
			Thread th1 = new Thread(obj);
			th1.start();
		}
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Thread "+Thread.currentThread().getName()+" Default Formatter: "+value.get());
		
		value.set("Vipul");
		
		System.out.println("Thread "+Thread.currentThread().getName()+" Formatter: "+value.get());
		
	}
}
