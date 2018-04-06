package com.test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WordLadder {
	
	String[] dictionary= {"POON","PLEE","SAME","POIE","PLEA","PLIE", "POIN"};
	
	private boolean isAdjacent(String word, String dict){
		
		String[] word1 = word.split("");
		String[] word2 = dict.split("");
		
		int count =0;
		for(int i=0;i<word1.length;i++){
			if(!word1[i].equals(word2[i])){
				count++;
			}
			
			if(count > 1){
				break;
			}
		}
		
		if(count == 1){
			return true;
		}
		else {
			return false;
		}
	}
	
	private void showDictionary(){
		
		for(int i=0;i<dictionary.length;i++){
			System.out.print (dictionary[i]+" ");
		}
		System.out.println();
	}
	
	private int findShortestChain(String start, String target){
		PriorityQueue<String> queue = new PriorityQueue<>(Arrays.asList(dictionary));
		PriorityQueue<String> result = new PriorityQueue<>();
		result.add(start);
		
		while(!result.isEmpty()){
			
			String word = result.peek();
			
			for(String data : queue){
				
				if(isAdjacent(word, data)){
					result.add(data);
					queue.remove(data);
					
					if(data.equals(target)){
						return result.size();
					}
					break;
				}
			}
		}
		
		return result.size();
	}
	
	public static void main(String[] args){
		WordLadder wordLadder = new WordLadder();
		System.out.print("Below is the dictionary value: ");
		wordLadder.showDictionary();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter start: ");
		String start = scanner.nextLine();
		System.out.print("Enter target: ");
		String target = scanner.nextLine();
		int size = wordLadder.findShortestChain(start, target);
		
		System.out.println("Size: "+size);
		scanner.close();
		
	}
}
