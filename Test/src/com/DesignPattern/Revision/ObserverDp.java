package com.DesignPattern.Revision;

import java.util.ArrayList;
import java.util.List;

class TableNotification{
	
	private static final TableNotification INSTANCE = new TableNotification();
	
	public static TableNotification getInstance(){
		return INSTANCE;
	}
	
	List<Notifier> list = new ArrayList<>();
	
	
	public void addNotifier(Notifier notifier){
		list.add(notifier);
	}
	
	public void notifyAllObservers(){
		for(Notifier notifier : list){
			notifier.displayName();
		}
	}
}

abstract class Notifier {
	
	String name;
	
	TableNotification notification;
	
	public Notifier(TableNotification notification) {
		this.notification = notification;
	}
	
	public void addToNotification(Notifier notifier){
		notification.addNotifier(notifier);
	}
	
	abstract public void displayName();
}


class N1 extends Notifier{

	public N1(TableNotification notification) {
		super(notification);
	}

	@Override
	public void displayName() {
		// TODO Auto-generated method stub
		System.out.println("This is N1.");
	}
}

class N2 extends Notifier{

	public N2(TableNotification notification) {
		super(notification);
	}

	@Override
	public void displayName() {
		// TODO Auto-generated method stub
		System.out.println("This is N2.");
	}
	
}

public class ObserverDp {

	void inheritance(){
		System.out.println("Inheritance...");
	}
	
	public static void main(String[] args){
		
		TableNotification tableNotification = TableNotification.getInstance();
		Notifier n1 = new N1(tableNotification);
		Notifier n2 = new N2(tableNotification);
		n1.addToNotification(n1);
		n2.addToNotification(n2);
		
		tableNotification.notifyAllObservers();
		
	}
	
}
