package com.DesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

class Observers{

	private List<NotificationListener> listeners = new ArrayList<>();
	
	final static Observers object = new Observers();
	
	private Observers(){
		
	}
	
	public void registerListener(NotificationListener notificationListener){
		listeners.add(notificationListener);
	}
	
	public static Observers getInstance(){
		return object;
	}
	
	/**
	 * 
	 */
	public void notifyRequest(){
		for(NotificationListener notificationListener : listeners){
				notificationListener.addMove();
		}
	}
}

interface NotificationListener {
	
	void addMove();
}

class Identity implements NotificationListener {
	
	
	public Identity() {
		Observers.getInstance().registerListener(this);
	}

	@Override
	public void addMove() {
		System.out.println("Request Received.");
		
	}
}

class Cashable implements NotificationListener{

	
	public Cashable() {
		Observers.getInstance().registerListener(this);
	}
	
	@Override
	public void addMove() {
		// TODO Auto-generated method stub
		
		System.out.println("Cashable Request Received");
		
	}
	
}


public class DemoObserverDesignPattern {
	
	public static void main(String[] args){
		new Identity();
		new Cashable();
		Observers.getInstance().notifyRequest();
	}	
}
