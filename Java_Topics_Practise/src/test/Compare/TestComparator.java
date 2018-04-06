package test.Compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class compare{
    private int a;
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public String getTemp() {
        return temp;
    }
    public void setTemp(String temp) {
        this.temp = temp;
    }
    private String temp;
    
    public compare(int a, String temp) {
	// TODO Auto-generated constructor stub
	this.a = a;
	this.temp = temp;
    }
    
    public String toString() {
	return this.a+" "+this.temp;
    }
    
}

public class TestComparator {
    
    
    static Comparator<compare> compInt = new Comparator<compare>() {

	public int compare(compare o1, compare o2) {
	    // TODO Auto-generated method stub
	    if(o1.getA() > o2.getA()) {
		return 1;
	    }
	    
	    else if(o1.getA() == o2.getA()) {
		return 0;
	    }
	    
	    else {
		return -1;
	    }
	}
    };
    
    static Comparator<compare> compString = new Comparator<compare>() {

	public int compare(compare o1, compare o2) {
	    // TODO Auto-generated method stub
	    return o1.getTemp().compareTo(o2.getTemp());
	}
    };

    public static void main(String[] args) {

	List<compare> list = new ArrayList<compare>();
	compare cmp2 = new compare(3, "B");
	compare cmp1 = new compare(1, "A");
	compare cmp3 = new compare(2, "C");
	
	list.add(cmp3);
	list.add(cmp1);
	list.add(cmp2);
	
	for(compare cmp : list) {
	    System.out.println(cmp);
	}
	System.out.println();
	Collections.sort(list,compInt);
	
	for(compare cmp : list) {
	    System.out.println(cmp);
	}
	
	
	list.add(cmp3);
	list.add(cmp1);
	list.add(cmp2);
	
	Collections.sort(list, compString);
	
	
	for(compare cmp : list) {
	    System.out.println(cmp);
	}
	System.out.println();
	Collections.sort(list,compInt);
	
	for(compare cmp : list) {
	    System.out.println(cmp);
	}

    }

}
