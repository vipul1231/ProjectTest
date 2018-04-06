package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class obj implements Comparable<obj>{
	Integer a;

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	@Override
	public int compareTo(obj o) {
		// TODO Auto-generated method stub
		return this.getA().compareTo(o.getA());
	}
	
}


public class CompareO {
	
	
	public static void main(String[] args){
	
		
		List<obj> list = new ArrayList<>();
		list.add(new obj());
		list.add(new obj());
		
		
		Collections.sort(list);
		
	}
}
