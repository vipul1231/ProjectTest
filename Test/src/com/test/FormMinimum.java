package com.test;

import java.util.Scanner;

/**
 * Sequence : DDIDDIID
 * Output: 3 2 1 6 5 4 7 9 8 
 * 
 * @author vtiwari
 *
 */
public class FormMinimum {
	
	
	private void calculateMinimum(String[] input){

		int lastPrinted = 0;;
		int max = 0;
		
		for(int i=0;i<input.length;i++){
			
			//Calculate first letter to which is extra
			if(i==0){
				if(input[i].equals("I")){
					lastPrinted = 1;
					max = 1;
					System.out.print(lastPrinted+"");
				}
				
				else {
					int count = 0;
					int noOfNextD = 0;
					while(count!= input.length && input[count].equals("D")){
						noOfNextD += 1;
						count++;
					}
					
					max = noOfNextD + 1;
					lastPrinted = max;
					System.out.print(lastPrinted+"");
				}
			}
		
			//Compute next available sequence
			if(input[i].equals("D")){
				
				lastPrinted -= 1;
				System.out.print(lastPrinted+"");
				
			}
			
			else if(input[i].equals("I")){
				//Always compute next no of D's
				
				int count  = i+1;
				int noOfNextD = 0;
				while(count!= input.length && input[count].equals("D")){
					noOfNextD += 1;
					count++;
				}
			
				//When no D is available Just increment the max.
				if(noOfNextD == 0){
					lastPrinted = max+1;
					max = lastPrinted;	
				}
				else {
					//First increment the max by 1 and add no of D's to it.
					max +=1;
					max = max+noOfNextD;
					lastPrinted = max;
				}
				
				System.out.print(lastPrinted +"");
			}
		}
		
	}
	
	
	public static void main(String[] args){
		
		FormMinimum formMinimum = new FormMinimum();

		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		
		
		for(int i=0;i<n;i++){
			String[] array = scanner.nextLine().split("");
			System.out.println();
			formMinimum.calculateMinimum(array);
		}
		scanner.close();
		
	}
}
