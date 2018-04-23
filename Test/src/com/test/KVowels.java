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
					indexes.add(j+1);
					symbol.add(array[j]);
				}
			}
			
			System.out.println(indexes);
			System.out.println(symbol);
			
			int largest = -1;
			int candyCounter = 0;
			
			int max = 0;
			
			Set<String> candyEaten = new HashSet<>();
			for(int k=0;k<indexes.size();k++){
				
				for(int h = k;h<indexes.size();h++){
					int index = indexes.get(h);
					String candy = symbol.get(h);
					
					if(candyEaten.contains(candy)){
						continue;
					}
					else if(candyCounter == candlesToPick && !candyEaten.contains(candy)){
						int diff = (index-1) - k;
						if(diff > max){
							max = diff;
							break;
						}	
					}
					
					candyEaten.add(candy);
					candyCounter++;	
				}
			}
			
			
			/**
			 * if(first == 0){
					while(true){
						
						int endPostion = indexes.get(k+candlesToPick);
						String fCandyType = symbol.get(k+candlesToPick);
						String currentCandyType = symbol.get(k);
						
						
						if(fCandyType != currentCandyType){
							int diff = (endPostion-1) - first;
							if(diff > max){
								max = diff;
								break;
							}	
						}
						candyCounter++;
					}
					
					first = 1;
				}
			 * 
			 */
			
			
			System.out.println(largest);
		}
	
		scanner.close();
	}
}
