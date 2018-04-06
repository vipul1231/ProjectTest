package com.hackerrank;

import java.util.Scanner;

/**
 * Input:
 * 	5	
	1 2 3 4 5
	2
	1 2
	2 3
   Output: 5 2 3 4 1 
   	
 * 
 * @author Vipul_Anky
 *
 */
public class Professor {
    
    public static void main(String[] args){
	Professor professor = new Professor();
	
	Scanner scanner = new Scanner(System.in);
	
	int noOfInteger = Integer.parseInt(scanner.nextLine());
	
	String[] array = scanner.nextLine().split(" ");
	
	int noOfOperands = Integer.parseInt(scanner.nextLine());
	
	for(int i=0 ;i< noOfOperands;i++){
	    String[] swapIntegers = scanner.nextLine().split(" ");
	    int lastIndex= Integer.parseInt(swapIntegers[1]);
	    int firstIndex = Integer.parseInt(swapIntegers[0]);
	    while(true){
		//index = professor.findIndexOfNumber(array, Integer.toString(index));
		int index = professor.findIndexOfNumber(array, Integer.toString(firstIndex));
		int indexToSwap = (noOfInteger-1) - index;
		professor.swap(array, index, indexToSwap);
		firstIndex++;
		
		if(firstIndex > lastIndex){
		    break;
		}
	    }  
	}
	
	professor.displayArray(array);
	
	scanner.close();
	
    }
    
    public void displayArray(String[] array){
	for(int i=0;i<array.length;i++){
	    System.out.print(array[i]+" ");
	}
    }
    
    public void swap(String[] array, int a, int b){
	
	String temp = array[a];
	array[a] = array[b];
	array[b] = temp;
    }
    
    public int findIndexOfNumber(String[] array, String number){
	for(int i=0;i<array.length;i++){
	    if(array[i].equals(number)){
		return i;
	    }
	}
	return 0;
    }

}
