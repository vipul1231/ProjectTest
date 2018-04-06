package com.DesignPattern.Factory;


abstract class Vehicle {
	
	abstract String getCompany();
	
}

class Car extends Vehicle {

	@Override
	String getCompany() {
		return null;
	}
}

class Maruti extends Car {
	
	String marutiCarName;

	public String getMarutiCarName() {
		return marutiCarName;
	}

	public void setMarutiCarName(String marutiCarName) {
		this.marutiCarName = marutiCarName;
	}
}

class Truck extends Vehicle {

	@Override
	String getCompany() {
		return null;
	}	
}

class AshokeLeyLand extends Truck {
	
	String ashokeLeyLand;

	public String getAshokeLeyLand() {
		return ashokeLeyLand;
	}

	public void setAshokeLeyLand(String ashokeLeyLand) {
		this.ashokeLeyLand = ashokeLeyLand;
	}
	
	
}

abstract class AbstractFactory {
	public abstract Car getCar(String company);
	public abstract Truck getTruck(String company);
}

class CarFactory extends AbstractFactory {

	@Override
	public Car getCar(String company) {
		
		if(company.equals("Maruti")){
			return new Maruti();
		}
		
		return null;
	}

	@Override
	public Truck getTruck(String company) {
		return null;
	}
	
}

class TruckFactory extends AbstractFactory {

	@Override
	public Car getCar(String company) {
		return null;
	}

	@Override
	public Truck getTruck(String company) {
		if(company.equals("AshokeLeyLand")){
			return new AshokeLeyLand();
		}
		return null;
	}
	
}

public class AbstractFactoryDesignPattern {

}
