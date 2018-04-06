package com.test;

public class QuickSort {
	int[] input = new int[]{2,4,8,5,1,9,7,6};
	
	public QuickSort(int[] array) {
		// TODO Auto-generated constructor stub
		this.input = array;
	}
	
	public QuickSort(){
		
	}
	
	private int partition(int[] array, int low, int high){
		
		int pivot = array[high];
		int i = low -1;

		for(int j=low;j<high;j++){
			
			if(array[j] < pivot){
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		
		int temp = array[i+1];
		array[i+1] = pivot;
		array[high] = temp;
		
		return i+1;
	}
	
	
	public void doQuickSort(int[] array, int low, int high){	
		if(low < high){
			
		int pi = partition(array, low, high);
		doQuickSort(array, low, pi-1);
		doQuickSort(array, pi+1, high);
		
		}
	}
	
	
	public String toString(){
		for(int i =0 ;i<input.length;i++){
			System.out.print(input[i]+" ");
		}
		return " <== Finished";
	}
	
	
	public static void main(String[] args){
		QuickSort quickSort = new QuickSort(new int[8]);
		int length = quickSort.input.length;
		quickSort.doQuickSort(quickSort.input, 0, length-1);
		System.out.println(quickSort);
	}

}
