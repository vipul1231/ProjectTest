package com.test;

public class QuickSort {
	
	int[] array ={10,80,30,90,70,50,70};
	
	
	public static void main(String[] args){
		QuickSort obj = new QuickSort();
		obj.sort(0,obj.array.length-1);
	}
	
	
	
	private void sort(int low, int high){
		
		if(low < high){
			
			int pi = partition(low, high);
			
			sort(low, pi-1);
			sort(pi+1, high);
		}
	}
	
	
	private int partition(int low, int high){
			
		int pivot = array[high];
		
		int i = low - 1;
		
		
		for(int j = low ;j<high;j++){
			
			if(array[j] <= pivot){
				
				i++;
				
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}			
		}
		
		//Swap the pivot
		int temp = array[i+1];
		array[i+1] = array[high];
		array[high] = temp;
		
		return i+1;
		
	}
}
