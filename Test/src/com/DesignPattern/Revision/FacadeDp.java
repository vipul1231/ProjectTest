package com.DesignPattern.Revision;


interface Vehicle {
	
	String type();
}


class Sedan implements Vehicle {

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return "Sedan";
	}
}


class Truck implements Vehicle {

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return "Heavy Duty Trucks";
	}
	
}


class Mahindra {
	
	private Sedan sedan;
	private Truck truck;
	
	public Mahindra() {
		// TODO Auto-generated constructor stub
		this.sedan = new Sedan();
		this.truck = new Truck();
	}
	
	public String sedanType(){
		return sedan.type();
	}
	
	public String truckType(){
		return truck.type();
	}
}

public class FacadeDp {
	
	public static void main(String[] args){
		Mahindra mahindra = new Mahindra();
		System.out.println(mahindra.sedanType());
		System.out.println(mahindra.truckType());
	}
}
