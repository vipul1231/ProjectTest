package com.test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class MapValuesSort {
	
	
	private Comparator<Entry<String, Integer>> returnComp(){
		
		Comparator<Entry<String, Integer>> comp = new Comparator<Map.Entry<String,Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().compareTo(o2.getValue());
			}
		};
		
		return comp;
	}
	
	
	public static void main(String[] args){
		MapValuesSort obj = new MapValuesSort();
		Map<String, Integer> map = new HashMap<>();
		map.put("Vipul", 12);
		map.put("Rohan", 23);
		map.put("Shyam", 24);
		map.put("Harish", 76);
		
		System.out.println(map);
		
		LinkedList<Entry<String,Integer>> list = new LinkedList<>(map.entrySet());
		
		Collections.sort(list,obj.returnComp());
		
		System.out.println(list);
		
	}
}
