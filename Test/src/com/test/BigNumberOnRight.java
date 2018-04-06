package com.test;

public class BigNumberOnRight {
	
	int[] array = {12,14,2,3,6,7,2};
	
	public static void main(String[] args){
		
		BigNumberOnRight obj = new BigNumberOnRight();
		obj.replaceNumberOnRight();
		System.out.println(obj);
	}
	
	private int[] replaceNumberOnRight(){
	
		int currentMax = 0;
		for(int i=array.length-1;i>=0;i--){
		
			int number = array[i];
			if(i==array.length-1){
				array[i] = -1;
			}
			if(number > currentMax){
				if(i!=array.length-1){
					array[i] = currentMax;
				}
				currentMax = number;
			}	
			else {
				array[i] = currentMax;
			}
		}
		return array;
	}
	
	public String toString(){
		
		
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		
		return null;
	}
}
