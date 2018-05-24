package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


/**
 * Input : 
 * 10
1 1 1 1 6 6 4 4 4 9
 * 
 * 
 * @author vtiwari
 *
 */
public class SequenceCount {
	
	public static void main(String[] args){
		SequenceCount sequenceCount = new SequenceCount();
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
		
		Collections.sort(list, sequenceCount.returnComp());
		
		System.out.println(list);
		
		scanner.close();
	}
	
	
	private Comparator<String> returnComp(){
		
		Comparator<String> returnComp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String[] array1 = o1.split("-");
				String[] array2 = o2.split("-");
				
				if(Integer.parseInt(array1[1]) < Integer.parseInt(array2[1])){
					return -1;
				}
				else if(Integer.parseInt(array1[1]) > Integer.parseInt(array2[1])){
					return 1;
				}
				else {
					return 0;
				}
			}
		};
		
		return returnComp;
		
	}
	
}
