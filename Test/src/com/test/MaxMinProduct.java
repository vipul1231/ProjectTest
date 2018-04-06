package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MaxMinProduct {
	
	
	int min=0, max=0;
	
	public static void main(String[] args){
	
		MaxMinProduct obj = new MaxMinProduct();
		Scanner scanner = new Scanner(System.in);
		List<String> operation = new ArrayList<>();
		int noOfOperation = Integer.parseInt(scanner.nextLine());
		
		for(int i=0;i<noOfOperation;i++){
			operation.add(scanner.nextLine());
		}
		
		noOfOperation = Integer.parseInt(scanner.nextLine());
		Queue<Integer> queue = new PriorityQueue<>();
		int finalProduct = 0;
		for(int i=0;i<noOfOperation;i++){
			
			String opr = operation.get(i);
			if(opr.contains("push")){
				int number = Integer.parseInt(scanner.nextLine());
				queue.add(number);
				int result = obj.computeMinAndMax(number);
				
				if(result == 0){
					finalProduct = obj.min*obj.max;	
					System.out.println(finalProduct);
				}
				else {
					//reCalculateMinAndMax
					obj.reCalculateMinMax(queue);
					finalProduct = obj.min*obj.max;
					System.out.println(finalProduct);
				}
				
			}
			else if(opr.contains("pop")){
				int number = queue.poll();
				int result = obj.computeMinAndMax(number);
				
				if(result == 0){
					finalProduct = obj.min*obj.max;
					System.out.println(finalProduct);
				}
				else {
					//reCalculateMinMax
					obj.reCalculateMinMax(queue);
					finalProduct = obj.min*obj.max;
					System.out.println(finalProduct);
				}
			}
		}
		
		//System.out.println("Final product: "+finalProduct);
		scanner.close();
	}
	
	/**
	 * Re calculate Min and Max values.
	 *
	 * @param queue
	 */
	private void reCalculateMinMax(Queue<Integer> queue){

		for(Integer value : queue){
			if(min == 0 && max == 0){
				min = value;
				max = value;
			}
			else {
				
				if(value > max){
					max = value;
				}
				else if (value < max){
					min = value;
				}
			}
		}
	}
	
	
	/**
	 * 
	 * @param number
	 * @return
	 */
	private int computeMinAndMax(int number){
		
		if(min == 0 && max==0){
			min = number;
			max = number;
			return 0;
		}
		else if(number > max){
			max = number;
			return 0;
		}
		else if(number < min){
			min = number;
			return 0;
		}
		
		//if number is equal to min or max
		
		if(min == number){
			return 1;
		}
		
		else if(max == number){
			return 1;
		}
		
		return 0;
	}
}
