package com.test;

import java.util.Scanner;

public class LensKart {
	
	
	public static void main(String[] args){
		
		QuickSort quickSort = new QuickSort();
		Scanner scanner = new Scanner(System.in);
		int nTest = scanner.nextInt();
		
		for(int i=0;i<nTest;i++){
			
			int number = scanner.nextInt();
			int[] array = new int[number];
			int maxDiff = 0;
			for(int j=0;j<number;j++){
				array[j]  = scanner.nextInt();
				
				if(j!=0){
					if((array[j-1] < array[j]) && (array[j] - array[j-1] > maxDiff)){
						maxDiff = array[j] - array[j-1];
						System.out.println("Max Diff"+maxDiff);
					}
				}
			}
			
			quickSort.doQuickSort(array, 0, array.length-1);
			
			System.out.println(quickSort);
			
			if((array[array.length-1] - array[0]) > maxDiff){
				maxDiff = array[array.length-1] - array[0];
			}
			
			System.out.println(maxDiff);
		}
		scanner.close();
	}

}
