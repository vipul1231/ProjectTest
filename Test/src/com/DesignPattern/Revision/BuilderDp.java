package com.DesignPattern.Revision;

interface Item {
	
	float getPrice();
	Packing packing();
	String name();
}


abstract class Burger implements Item {
	
	public Packing packing(){
		return new Wrapper();
	}
}

class VegBurger extends Burger{

	@Override
	public float getPrice() {
		// TODO Auto-generated method stub
		return 21.3f;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Veg Burger";
	}
}

class EggBurger extends Burger{

	@Override
	public float getPrice() {
		// TODO Auto-generated method stub
		return 29.4f;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Egg Burger";
	}
}

interface Packing{
	String packingType();
}

class Wrapper implements Packing{

	@Override
	public String packingType() {
		// TODO Auto-generated method stub
		return "Wrapper";
	}	
}

abstract class ColdDrink implements Packing {

	@Override
	public String packingType() {
		// TODO Auto-generated method stub
		return "Bottle";
	}
}


public class BuilderDp {

}
