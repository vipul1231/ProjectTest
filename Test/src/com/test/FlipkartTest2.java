package com.test;

import java.util.HashMap;
import java.util.Map;

public class FlipkartTest2 {
	
	
	static Map<String,Integer> map = new HashMap<>();
	
	static {
		//programmer
		map.put("p", 1);
		map.put("r", 3);
		map.put("o", 1);
		map.put("g", 1);
		map.put("a", 1);
		map.put("m", 2);
		map.put("e", 1);
	}
	
	public static void main(String[] args){
	
	
		FlipkartTest2 obj =new  FlipkartTest2();
		System.out.println(obj.parkingFree("progxrammerrxproxgrammer"));
		System.out.println(obj.parkingFree("programmerprogrammer"));
	}
	
	
	int parkingFree(String start){
		
		Map<String, Integer> dummy = new HashMap<>();
		String[] array = start.split("");
		System.out.println(array.length);
		
		int end1=0, start1=0;
		boolean oneFound= false;
		for(int i=0;i<array.length;i++){
			if(map.containsKey(array[i])){
				
//				if(oneFound && !valueUpdated){
//					start1 = i;
//					valueUpdated = true;
//				}
				
				
				if(dummy.get(array[i]) == null){
					dummy.put(array[i], 1);
				}
				else {
					int value = dummy.get(array[i]);
					dummy.put(array[i],++value);
				}
			}
		
			if(compareTwoMaps(dummy, map)){
				
//				if(oneFound){
//					System.out.println("SecondFound: End:"+end1+" Start: "+start1);
//					break;
//				}
				
				System.out.println("Equals");
				end1 = i+1;
				dummy.clear();
				oneFound = true;
				break;
			}
		}
		
		if(oneFound){
			for(int i=array.length-1;i>=0;i--){
				if(map.containsKey(array[i])){
					
//					if(oneFound && !valueUpdated){
//						start1 = i;
//						valueUpdated = true;
//					}
					
					
					if(dummy.get(array[i]) == null){
						//System.out.println(array[i]);
						dummy.put(array[i], 1);
					}
					else {
						int value = dummy.get(array[i]);
						//System.out.println(array[i]+" "+value);
						dummy.put(array[i],++value);
					}
				}
				
				if(compareTwoMaps(dummy, map)){
					
//					if(oneFound){
//						System.out.println("SecondFound: End:"+end1+" Start: "+start1);
//						break;
//					}
					
					System.out.println("Equals");
					start1 = i-1;
					break;
					
				}
			}
		}
		
		System.out.println("Start: "+start1);
		System.out.println("End: "+end1);
		
		return start1-end1;
		
	}
	
	
	private boolean compareTwoMaps(Map<String, Integer> mapA, Map<String, Integer> mapB){
		 try{
		        for (String k : mapB.keySet())
		        {
		            if (!mapA.get(k).equals(mapB.get(k))) {
		                return false;
		            }
		        } 
		        for (String y : mapA.keySet())
		        {
		            if (!mapB.containsKey(y)) {
		                return false;
		            }
		        } 
		    } catch (NullPointerException np) {
		        return false;
		    }
		    return true;
	}
}
