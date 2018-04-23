package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Apple {
	private String color;
	private Double weight;
	
	public String getColor() {
		return color;
	}
	public Double getWeight() {
		return weight;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	Apple(String color, Double weight) {
		this.color = color;
		this.weight = weight;
	}

	public String toString(){
		return " { Apple: color:"+this.color+" weight: "+weight;
	}
}


public class PredicateTest {
	
	public static Predicate<Apple> isWeightAboveFifty(){
		return apple -> apple.getWeight() > 50;
	}
	
	public static void filterApple(List<Apple> list , Predicate<Apple> predicate){
		list  = list.stream().filter(predicate).collect(Collectors.toList());
		System.out.println(list);
	}
	
	public static void main(String[] args){
		List<Apple> list = new ArrayList<>();
		list.add(new Apple("Red", 10.03));
		list.add(new Apple("Pink", 9.57));
		list.add(new Apple("Orange", 76.88));
		filterApple(list, isWeightAboveFifty());
		
	}
}
