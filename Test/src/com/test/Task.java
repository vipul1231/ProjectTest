package com.test;

public class Task implements Cloneable{
	
	int number;
	String menu;
	FreeCharge freeCharge;
	
	Task(int number, String menu, FreeCharge freeCharge){
		this.number = number;
		this.menu = menu;
		this.freeCharge = freeCharge;
	}
	
	protected Object clone() throws CloneNotSupportedException{
		
		return super.clone();
	}
	
	
	public static void main(String[] args){
		
		Task task = new Task(1, "hello", new FreeCharge());
		System.out.println(task.freeCharge);
		try {
			Task task1 = (Task)task.clone();
			System.out.println(task1.freeCharge);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
