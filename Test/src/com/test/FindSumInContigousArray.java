package com.test;

import java.util.Scanner;

public class FindSumInContigousArray {
	
	
	private void findSum(int length, Scanner scanner){
		
		int maxEndingHere = 0;
		int maxSoFar = 0;
		
		for(int i=0;i<length;i++){

			int value = scanner.nextInt();
			
			if(value > 0){
				
				
				maxEndingHere += value;
				
				if(maxEndingHere > maxSoFar){
					maxSoFar = maxEndingHere;
				}
			}
			else if(maxEndingHere > 0 && value < 0){
				maxEndingHere += value;
				
				if(maxEndingHere > maxSoFar){
					maxSoFar = maxEndingHere;
				}
			}
			
		}
		
		
		System.out.println(maxSoFar);
		
	}
	
	public static void main(String[] args){
		
		FindSumInContigousArray obj = new FindSumInContigousArray();
		
		Scanner scanner = new Scanner(System.in);
		int number  = scanner.nextInt();
		obj.findSum(number, scanner);
		scanner.close();
		
	}
}
