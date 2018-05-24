package com.test;

import java.util.function.Consumer;
import java.util.function.Supplier;

class Person{
	private String name;
	private int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String toString(){
		return this.name+" "+this.age;
	}
}

public class SupplierAndConsumerTest {

	
	public static void main(String[] args){
		Supplier<Person> supplier = () -> {
			return new Person("Vipul",23);
		};
	
		Person person = supplier.get();
		System.out.println(person);
		
		Consumer<Person> consumer = (per) -> {
			System.out.println(per.getName()+" Accepted");
		};
		
		Consumer<Person> consumer1 = (x) -> {
			System.out.println("Consumer 1");
		};
		
		consumer.andThen(consumer1).accept(person);
	}
}
