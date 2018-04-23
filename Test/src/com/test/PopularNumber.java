package com.test;

public class PopularNumber {
	
	int[] array = {2, 3, 3, 5, 3, 4, 1, 7};
	
	public static void main(String[] args){
		PopularNumber popularNumber = new PopularNumber();
		popularNumber.maxInArray(8);
	}
	
	/**
	 * Max in array.
	 */
	private void maxInArray(int n){
		
		for(int i=0;i<array.length;i++){
			array[array[i]%n] += n;
		}
		
		int max = 0;
		int index = 0;
		
		for(int i=0;i<array.length;i++){
			if(array[i] > max){
				max = array[i];
				index = i;
			}
			System.out.println("Number: "+array[i]);
		}
		
		System.out.println(max+" "+index);
		
		for(int i=0;i<array.length;i++){
			array[i] = array[i]%n;
			System.out.println(array[i]);
		}
	}
}
