package com.test;

public class FindDuplicate {
	
	int[] array = {4, 4, 2, 5, 2, 3, 1};

	public static void main(String[] args){
		
		FindDuplicate findDuplicate = new FindDuplicate();
		findDuplicate.traverseArray();	
	}
	
	
	public void finalize(){
		System.out.println("Finalize");
	}
	
	
	private void traverseArray() {
		
		for(int i=0;i<array.length;i++){
			
			if(array[Math.abs(array[i])] > 0){
				array[Math.abs(array[i])] =  -array[Math.abs(array[i])];
			}
			else {
				System.out.println("Repeated Number: "+Math.abs(array[i]));
			}
		}
		
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}
