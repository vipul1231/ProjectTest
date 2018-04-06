package com.test;

import java.util.HashMap;
import java.util.Map;

public class ZeroSum {
	
	int[] array = new int[] {1, 4, -2, -2, 5, -4, 3};
	
	/**
	 * Find Zero Sum.
	 */
	private boolean findZeroSum(){
		Map<Integer, Integer> map = new HashMap<>();
		
		int sum = 0;
		for(int i=0;i<array.length;i++){
			sum = sum +array[i];
			
			if(sum ==0 || array[i]==0 || map.get(sum)!=null){
				return true;
			}
			map.put(sum, array[i]);
		}
		
		return false;
	}
	
	
	
	public static void main(String... args){
		ZeroSum zeroSum = new ZeroSum();
		zeroSum.findZeroSum();
	}
}
