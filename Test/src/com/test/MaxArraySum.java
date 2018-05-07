package com.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class MaxArraySum {
    
	
	List<Integer> finalList = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		
		MaxArraySum maxArraySum = new MaxArraySum();
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		List<Integer> list = null;
		int[] array = null;
		for(int i=0;i<n;i++){
			
			scanner.nextLine();
			list = Arrays.asList(scanner.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
			array = list.stream().mapToInt(h->h).toArray();
			maxArraySum.finalList = list;
			maxArraySum.sort(array, 0, array.length-1);
	
		
		//now iterate through array and find.
		
		double negativeSum = 0;
		double maxSum = 0;
		for(int j=0;j<array.length;j++){
			int number = array[j];
			
			double product = number * (array.length - j);
			double subtract = product - negativeSum;
			
			if(subtract > maxSum){
				maxSum = subtract;
			}
			
			negativeSum += number;	
		}
		
		System.out.println(Math.round(maxSum));
		
		}
	
    	scanner.close();
    }
	
	int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
	
	void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
	
	
}
