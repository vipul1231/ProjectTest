package com.test;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class EmptyClass {
	
	public static void main(String[] args){
		
		Map<Integer,String> map = new TreeMap<>();
		
		map.put(1, "Hello");
		map.put(2, "Hello");
		map.put(7, "Hello");
		map.put(3, "Hello");
				
		for(Entry<Integer, String> entry :map.entrySet())
		{
			System.out.println(entry.getKey());
		}
	}
}
