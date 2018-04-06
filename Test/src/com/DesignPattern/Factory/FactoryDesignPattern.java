package com.DesignPattern.Factory;

abstract class Animal {

	String name;

	abstract String sound();

	void setName(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

class Bird extends Animal{

	@Override
	String sound() {
		super.setName("Birds");
		System.out.println("Chi Cho!");
		return "Chi Cho!";
	}
}

class Horse extends Animal{

	@Override
	String sound() {
		super.setName("Horse");
		System.out.println("Hin Hin!");
		return "Hin Hin!";
	}
}

class AnimalFactory {
	
	public Animal getAnimal(String name){
		
		if(name.equals("HORSE")){
			return new Horse();
		}
		else {
			return new Bird();
		}
	}
	
}

public class FactoryDesignPattern {
	
	public static void main(String[] args){
		AnimalFactory animalFactory = new AnimalFactory();
		Animal animal = animalFactory.getAnimal("HORSE");
		System.out.println(animal.sound() +" "+ animal.getName());
	}
}



