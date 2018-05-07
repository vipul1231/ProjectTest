package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class KVowels {
	
	
	public static void main(String[] args){
	
		Scanner scanner = new Scanner(System.in);
		
		int nTest = Integer.parseInt(scanner.nextLine());
		Set<String> vowels = new HashSet<>();
		vowels.add("a");
		vowels.add("e");
		vowels.add("i");
		vowels.add("o");
		vowels.add("u");
		
		for(int i=0;i<nTest;i++){
			
			String[] inputs = scanner.nextLine().split(" ");
			int length = Integer.parseInt(inputs[0]);
			int candlesToPick = Integer.parseInt(inputs[1]);
			
			String[] array = scanner.nextLine().split("");
			List<Integer> indexes = new ArrayList<>();
			List<String> symbol = new ArrayList<>();
			for(int j=0;j<length;j++){
				if(vowels.contains(array[j])){
					indexes.add(j);
					symbol.add(array[j]);
				}
			}
			
			System.out.println(indexes);
			System.out.println(symbol);
			
			int candyCounter = 0;
			int max = 0;
			
			Set<String> candyEaten = new HashSet<>();
			for(int k=0;k<indexes.size();k++){
				
				int count = k;
				while(true){
					
					if(count == indexes.size()){
						break;
					}
					
					int index = indexes.get(count);
					String candy = symbol.get(count);
					
					if(candyEaten.contains(candy)){
						count++;
						continue;
					}
					else if(candyCounter == candlesToPick && !candyEaten.contains(candy)){
						
						if(k==0){
							int diff = (index-1) - k;
							if(diff > max){
								max = diff;
								break;
							}	
						}
						else {
							int diff = (index-1) - indexes.get(k-1);
							if(diff > max){
								max = diff;
								break;
							}
						}
							
					}
					
					candyEaten.add(candy);
					candyCounter++;
					count++;	
				}
				candyEaten.clear();
				candyCounter = 0;
			}
			
			
			System.out.println(max);
		}
	
		scanner.close();
	}
}
