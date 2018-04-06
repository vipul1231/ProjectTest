package com.test;

import java.util.Scanner;

public class MergeSort {
	
	
	private void merge(int[] leftArray, int[] rightArray, int[] sortedArray){
		
		//Now do sorting on array
		
		int lLength = leftArray.length;
		int rLength = rightArray.length;
		int i=0;
		int j=0;
		int k=0;
		
		while(i<lLength && j <rLength){
		
			if(leftArray[i] < rightArray[j]){
				sortedArray[k] = leftArray[i];
				i++;
			}
			else {
				sortedArray[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		
		while(i<lLength){
			sortedArray[k] = leftArray[i];
			i++;
			k++;
		}
		
		while(j<rLength){
			sortedArray[k] = rightArray[j];
			j++;
			k++;
		}	
	}
	

	private void performMergeSort(int[] array){

		int n = array.length;
		
		if(n == 1){
			return;
		}
		int mid = n/2;	
		int[] leftArray = new int[mid];
		int[] rightArray = new int[n-mid];
		System.arraycopy(array, 0, leftArray, 0, leftArray.length);
		System.arraycopy(array, leftArray.length, rightArray, 0, rightArray.length);
		performMergeSort(leftArray);
		performMergeSort(rightArray);
		merge(leftArray, rightArray, array);
	}
	
	public static void main(String[] args){
		MergeSort obj = new MergeSort();
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		int[] inputArray = new int[number];
		for(int i=0;i<number;i++){
			inputArray[i] = scanner.nextInt();
		}
		obj.performMergeSort(inputArray);
		
		for(int arr : inputArray){
			System.out.println(arr);
		}
		
		scanner.close();
	}
}
