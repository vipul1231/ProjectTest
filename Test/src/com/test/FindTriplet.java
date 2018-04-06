package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @author vtiwari
 *
 */
public class FindTriplet {	
	
	int[] array = null;
	int[] numberArray = null;
	
	public static void main(String[] string){
		FindTriplet obj = new FindTriplet();
		obj.append(new int[] { 1, 2, 3 });
        System.out.println(obj.contains(6));
        System.out.println(obj.contains(9));
        obj.append(new int[] { 4 });
        System.out.println(obj.contains(9));
	}
	
	public void append(int[] list){
		
		if(array == null){
			array = list;
			numberArray = new int[array.length];
		}
		else {
			List<Integer> list1 = Arrays.stream(array).boxed().collect(Collectors.toList());
			List<Integer> list2 = Arrays.stream(list).boxed().collect(Collectors.toList());
			list2.stream().forEach(a -> list1.add(a));
			array = list1.stream().mapToInt(i->i).toArray();
			numberArray = new int[array.length];
		}
	}
	
	private boolean contains(int target){
		int pow = (int)Math.pow(2, array.length);
		for(int i=0;i<pow;i++){
			addOneToBinaryNumbers(numberArray, array.length-1);
			if(checkConsecutiveZeros(numberArray)){
				int sum = findSum(numberArray, array, array.length);
				if( sum == target){
					System.out.println("Debug: Test Array: "+Arrays.toString(array) + " Current target: "+sum);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Find sum for the testArray index contains 1.
	 * 
	 * @param testArray
	 * @param numberArray
	 * @param length
	 * @return
	 */
	private int findSum(int[] testArray,int[] numberArray, int length){
		int sum = 0;
		for(int i=0;i<length;i++){
			
			if(testArray[i]==1){
				sum +=numberArray[i];
			}
		}
		return sum;
	}
	
	/**
	 * Returns false if two consecutive position contains 0.
	 * 
	 * @param array
	 * @return
	 */
	private boolean checkConsecutiveZeros(int[] array){
		
		int count = 0;
		for(int i=0;i<array.length;i++){
			
			if(array[i] == 1){
				count++; 
			}
		}
		if(count == 3)
		return true;
		else 
		return false;
	}
	
	/**
	 * For given binary array add 1.
	 * 
	 * @param array Binary array
	 * @param index length of index
	 */
	private void addOneToBinaryNumbers(int[] array, int index){
		
		if(index == -1){
			return;
		}
		
		int number = array[index];
		
		if(number == 0){
			array[index] = 1;
			return;
		}
		
		else {
			array[index] = 0;
			addOneToBinaryNumbers(array, index-1);
		}
	}
}

