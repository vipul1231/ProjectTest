package com.test;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class FirstNonRepeating {
	
	String input = "GeeksForGeeksR";
	
	public static void main(String[] args){

		FirstNonRepeating obj = new FirstNonRepeating();
		obj.searchNonRepeating();
	}
	
	
	private void searchNonRepeating(){
		
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		
		String[] inputArray = input.split("");
		
		for(int i=0;i<inputArray.length;i++){
		
			String value = inputArray[i];
			
			if(map.get(value) == null){
				map.put(value, 1);
			}
			else {
				Integer count = map.get(value);
				map.put(value, ++count);
			}
		}
		
		//Start doing counting.
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		
		
		for(Entry<String, Integer> entry: entrySet){
			System.out.println("Key: "+entry.getKey());
			if(entry.getValue() == 1){
				System.out.println("Non repeating Character is :"+entry.getKey());
				break;
			}
		}
	}
}
