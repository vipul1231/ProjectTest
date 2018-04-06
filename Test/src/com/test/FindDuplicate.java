package com.test;

public class FindDuplicate {
	
	int[] array = {10, 2, 3, 1, 3, 6, 6,7,7};

	public static void main(String[] args){
	
		
		FindDuplicate findDuplicate = new FindDuplicate();
		findDuplicate.traverseArray();
		
		
	}
	
	
	private void traverseArray() {
		
		for(int i=0;i<array.length;i++){
			if (Math.abs(array[i]) -1 < array.length  && array[Math.abs(array[i])] >= 0)
				array[Math.abs(array[i])] = -array[Math.abs(array[i])];
            else
                System.out.print(Math.abs(array[i]) + " ");
		}
		
		System.out.println("######");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}
