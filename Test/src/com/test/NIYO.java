package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NIYO {
	
	static class Mobile {
		String type;
		int ram;
		int memory;
		int price;
		int rating;
		
		Mobile(String type, int ram, int memory, int price, int rating){
			this.type = type;
			this.price = price;
			this.ram = ram;
			this.memory = memory;
			this.rating = rating;
		}
	}
	
	public static void main(String[] args){
		NIYO obj = new NIYO();
		Scanner scanner = new Scanner(System.in);
		List<List<Mobile>> lWindows = obj.createNewList();
		List<List<Mobile>> lAndroid = obj.createNewList();
		List<List<Mobile>> lIos = obj.createNewList();
		
		int input =Integer.parseInt(scanner.nextLine());
		
		for(int i=0;i<input;i++){
			String[] line = scanner.nextLine().split(" ");
			int ram = Integer.parseInt(line[1]);
			int memory = Integer.parseInt(line[2]);
			int price = Integer.parseInt(line[3]);
			int rating = Integer.parseInt(line[4]);
			Mobile mobile = new Mobile(line[0], ram, memory, price, rating);
			
			if(line[0].contains("windows")){
				
				obj.addMobileToDataStructure(lWindows, mobile);
			}
			else if(line[0].contains("android")){
				obj.addMobileToDataStructure(lAndroid, mobile);
			}
			else{
				obj.addMobileToDataStructure(lIos, mobile);
			}
		}
		
		
		int customer = Integer.parseInt(scanner.nextLine());
		for(int j=0;j<customer;j++){
			
			String[] req = scanner.nextLine().split(" ");
			
			if(req[0].equals("windows")){
				obj.calculateRating(lWindows, req);
				
			}
			else if(req[0].equals("android")){
				obj.calculateRating(lAndroid, req);
			}
			else {
				//get the ram req.
				obj.calculateRating(lIos, req);
			}
		}
		scanner.close();
	}
	
	private void addMobileToDataStructure(List<List<Mobile>> listOfList, Mobile mobile){

		if(mobile.ram == 2) {
			if(mobile.memory == 32){
				List<Mobile> list = listOfList.get(0);
				list.add(mobile);
			}
			else {
				List<Mobile> list = listOfList.get(1);
				list.add(mobile);
			}
		}
		else if(mobile.ram == 4){
			if(mobile.memory == 32){
				List<Mobile> list = listOfList.get(2);
				list.add(mobile);
			}
			else {
				List<Mobile> list = listOfList.get(3);
				list.add(mobile);
			}
		}
		else if(mobile.ram == 8){
			if(mobile.memory == 32){
				List<Mobile> list = listOfList.get(4);
				list.add(mobile);
			}
			else {
				List<Mobile> list = listOfList.get(5);
				list.add(mobile);
			}
		}
	}
	
	
	private void calculateRating(List<List<Mobile>> listOfList, String[] req){
		int ram = Integer.parseInt(req[1]);
		if(ram == 2) {
			int reqMemory = Integer.parseInt(req[2]);
			int budget = Integer.parseInt(req[3]);
			if(reqMemory == 32){
				List<Mobile> list = listOfList.get(0);
				getMaxRating(list, budget);
			}
			else if(reqMemory == 64){
				List<Mobile> list = listOfList.get(1);
				getMaxRating(list, budget);
			}	
		}
		else if(ram == 4) {
			int reqMemory = Integer.parseInt(req[2]);
			int budget = Integer.parseInt(req[3]);
			if(reqMemory == 32){
				List<Mobile> list = listOfList.get(2);
				getMaxRating(list, budget);
			}
			else if(reqMemory == 64){
				List<Mobile> list = listOfList.get(3);
				getMaxRating(list, budget);
			}
		}
		else if(ram == 8) {
			int budget = Integer.parseInt(req[3]);
			int reqMemory = Integer.parseInt(req[2]);
			if(reqMemory == 32){
				List<Mobile> list = listOfList.get(4);
				getMaxRating(list, budget);
			}
			else if(reqMemory == 64){
				List<Mobile> list = listOfList.get(5);
				getMaxRating(list, budget);
			}
		}
	}
	
	private void getMaxRating(List<Mobile> list, int budget){
		int maxRating = 0;
		Collections.sort(list, returnComp());
		for(Mobile mobile : list){
			
			//TODO: use binary search.
			if(mobile.price <= budget){
				if(maxRating < mobile.rating){
					maxRating = mobile.rating;
				}
			}
			else if(mobile.price > budget){
				break;
			}
		}
		
		if(maxRating == 0){
			System.out.println(-1);
		}
		else {
			System.out.println(maxRating);	
		}
	}
	
	private Comparator<Mobile> returnComp(){
		Comparator<Mobile> comp = new Comparator<NIYO.Mobile>() {

			@Override
			public int compare(Mobile o1, Mobile o2) {
				// TODO Auto-generated method stub
				if(o1.price == o2.price){
					if(o1.rating == o2.rating){
						return 0;	
					}
					else {
						return o1.rating - o2.rating;
					}
					
				}
				else if(o1.price < o2.price){
					return -1;
				}
				else {
					return 1;
				}
			}
		};
		
		return comp;
	}
	
	
	
	private List<List<Mobile>> createNewList(){
		List<List<Mobile>> listOfList = new ArrayList<>(3);
		listOfList.add(new ArrayList<>());
		listOfList.add(new ArrayList<>());
		listOfList.add(new ArrayList<>());
		listOfList.add(new ArrayList<>());
		listOfList.add(new ArrayList<>());
		listOfList.add(new ArrayList<>());
		return listOfList;
	}
}
