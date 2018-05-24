package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Bugs {
	
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		
		
		List<Integer> bugsList = new ArrayList<>();
		
		
		Comparator<Integer> comp = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1 > o2){
					return -1;
				}
				else if(o1 < o2){
					return 1;
				}
				else {
					return 0;
				}
			}
		};
		
		for(int i=0;i<n;i++){
			
			String[] array = scanner.nextLine().split(" ");
			
			if(array.length == 1){
				if(bugsList.size() < 3){
					System.out.println("Not enough enemies");
				}
				else {
					Collections.sort(bugsList, comp);
					int number = bugsList.size()/3;
					System.out.println(bugsList.get(number-1));
				}
			}
			
			else {
				bugsList.add(Integer.parseInt(array[1]));
			}
			
		}
		
		scanner.close();
	}
}
