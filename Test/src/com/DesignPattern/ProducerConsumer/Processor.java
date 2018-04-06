package com.DesignPattern.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

public class Processor {

	List<String> list = new ArrayList<>();
	
	private static final int MAX_SIZE = 10;
	
	public void addObjectToList(String obj){
		
		synchronized (this) {
			if(list.size() < MAX_SIZE){
				System.out.println("Adding Object: "+obj);
				list.add(obj);
				this.notifyAll();
			}
			else {
				try {
					System.out.println("List is FULL. Cannot insert.");
					this.notifyAll();
					this.wait();
					System.out.println("Producer Lock Released.");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public String removeObjectsFromList(){
		
		synchronized (this) {
			if(list.size() > 0){
				int size = list.size();
				this.notifyAll();
				return list.remove(size-1);	
			}
			else {
				System.out.println("List is empty. Nothing to consume.");
				try {
					this.wait();
					System.out.println("Consumer Lock Released.");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}	
		}
	}
}
