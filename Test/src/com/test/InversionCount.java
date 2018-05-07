package com.test;

/**
 * Can be used in merge sort.
 * 
 * @author vtiwari
 *
 */
public class InversionCount {
	int[] array1 = {1, 3, 7, 8, 10};
	int[] array2 = {3, 5, 6, 10, 12,17};
	
	
	public static void main(String[] args){
		InversionCount inversionCount = new InversionCount();
		
		inversionCount.mergeTwoArray();
		
	}
	
	/**
	 * 
	 */
	private void mergeTwoArray(){
		
		int i = array1.length;
		int j = array2.length;
		
		int[] result = new int[i+j];
		
		
		int count1 = 0;
		int count2 = 0;
		int resultCounter = 0;
		if(i < j){
			
			while(count1 != i){
				placeTheNumbers(result, count1, count2, resultCounter);
			}
		}
		
		if(i > j){
			
			while(count2 != j){
				
				placeTheNumbers(result, count1, count2, resultCounter);
			}
		}
		
		if(count1 != i){
			while(count1!=i){
				result[resultCounter] = array1[count1];
				count1++;
				resultCounter++;
			}
		}
		
		if(count2 != j){
			while(count2!=j){
				result[resultCounter] = array2[count2];
				count2++;
				resultCounter++;
			}
		}
		
		
		for(int t=0;t<result.length;t++){
			System.out.print(result[t]+" ");
		}
	}
	
	/**
	 * Place number according to place.
	 * 
	 * @param result
	 * @param count1
	 * @param count2
	 * @param resultCounter
	 */
	private void placeTheNumbers(int[] result, int count1, int count2, int resultCounter){

		if(array1[count1] < array2[count2]){
			result[resultCounter] = array1[count1];
			resultCounter++;
			count1++;
		}
		
		else if(array1[count1] > array2[count2]) {
			result[resultCounter] = array2[count2];
			resultCounter++;
			count2++;
		}
		
		else if(array1[count1] == array2[count2]){
			result[resultCounter] = array1[count1];
			resultCounter++;
			result[resultCounter] = array2[count2];
			resultCounter++;
			count1++;
			count2++;
		}
	}
}
