package com.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Find max sum.
 * 
 * @author vtiwari
 * 
 * Maximum Complexity : O(pow(2,n)) Two to the power n.
 *
 */
public class MaxSum {	
	
	public static void main(String[] string){
		MaxSum obj = new MaxSum();
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		int pow = (int)Math.pow(2, length);
		int[] array = new int[length];
		int[] numberArray = new int[length];
	
		for(int i=0;i<length;i++){
			numberArray[i] = scanner.nextInt();
		}
		int maxSum=-9999;
		for(int i=0;i<pow;i++){
			obj.addOneToBinaryNumbers(array, length-1);
			if(obj.checkConsecutiveZeros(array)){
				int sum = obj.findSum(array, numberArray, length);
				if( sum > maxSum){
					System.out.println("Debug: Test Array: "+Arrays.toString(array) + " Current Max: "+sum);
					maxSum = sum;
				}
			}
		}
		
		System.out.println(maxSum);
		scanner.close();
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
		
		for(int i=0;i<array.length-1;i++){
			
			if(array[i] == 0 && array[i+1] == 0){
				return false;
			}
		}
		return true;
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
