package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Input : 
 * 10
 * 1 1 1 1 6 6 4 4 4 9
 * 
 * 
 * @author vtiwari
 *
 */
public class SequenceCount {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Integer length = scanner.nextInt();
		
		List<String> list = new ArrayList<>();
		int count = 0;
		
		int currentNumber=0;
		for(int i=0;i<length;i++){
			int number = scanner.nextInt();	
			
			if(i==0){
				currentNumber = number;
				count++;
			}
			else {
	
				if(currentNumber == number){
					count++;
				}
				else {
					StringBuilder string = new StringBuilder();
					string.append(currentNumber +"-"+count);
					list.add(string.toString());
					count = 1;
					currentNumber = number;
				}
			}
			
			if(i==length-1){
				list.add(currentNumber +"-"+count);
			}
			
		}
		
		for(String str : list){
			System.out.println(str);	
		}
		
		scanner.close();
	}
}
