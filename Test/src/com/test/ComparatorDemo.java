package com.test;

import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

class Invertor{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	String version;
	String manufacturer;
	Date date;
	
	
	public Invertor(int id, String name,String version) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.version = version;
		this.manufacturer = "Default";
		this.date = new Date();
	}

}

public class ComparatorDemo {
	
	public static void main(String[] args){
		ComparatorDemo demo = new ComparatorDemo();
		PriorityQueue<Invertor> list = new PriorityQueue<>();
		list.add(new Invertor(3,"Akaya","2.2.1"));
		list.add(new Invertor(1,"Abc","1.0"));
		list.add(new Invertor(2,"Luminious","3.0.1"));
		list.add(new Invertor(4,"zolo","5.3.2"));
		
		System.out.println(list);
		
		for(Invertor ivr : list){
			System.out.print(ivr.id+" ");
		}
		
//		list.sort(demo.returnComparator());
//		System.out.println();
//		for(Invertor ivr : list){
//			System.out.print(ivr.id+" ");
//		}
		
	}
	
	
	public Comparator<Invertor> returnComparator(){
		
		Comparator<Invertor> comp = new Comparator<Invertor>() {

			@Override
			public int compare(Invertor o1, Invertor o2) {
				// TODO Auto-generated method stub
				return o1.id - o2.id;
			}
		};
		
		return comp;
		
	}
}
