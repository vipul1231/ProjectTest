package test.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    
    List<Observer> list = new ArrayList<>();
    
    private int state;
    
    public int getState() {
	return state;
    }
    
    public void attach(Observer obj) {
	list.add(obj);
    }
    
    public void setState(int state) {
	this.state = state;
	notifyAllObserver();
    }
    
    public void notifyAllObserver() {
	for(Observer obsever : list) {
	    obsever.update();
	}
    }
}
