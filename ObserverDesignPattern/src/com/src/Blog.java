package com.src;

import java.util.ArrayList;
import java.util.List;

public class Blog implements Subject{
	
	public List<Observer> observerList;
	public boolean stateChange;
	
	public Blog() {	
		this.observerList = new ArrayList<Observer>();
		stateChange = false;
	}

	@Override
	public void registerObserver(Observer observer) {
				
		observerList.add(observer);
	}

	@Override
	public void notifyObserver() {
		
		if(stateChange)
		{
			for(Observer ob : observerList)
			{
				ob.update();
			}
		}
	}

	@Override
	public void unRegisterObserver(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public Object getUpdate() {
		Object changedState = null;
		
		if(stateChange)
		{
			changedState = "Observer Design Pattern";
		}
		return changedState;
	}
	
	public void postNewArticle()
	{
		stateChange = true;
		notifyObserver();
	}
}
