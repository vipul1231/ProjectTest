package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This program finds anagram of any string.
 * 
 * TODO: Write recursive approach as well.
 * 
 * ex dog = [god, ogd, odg, gdo, dgo, dog]
 * 
 * @author vtiwari
 *
 */
public class Anagram{
	
	
	private void createAnagram(String word, List<String> words){
		
		StringBuilder stringBuilder = new StringBuilder();
		
		if(words.isEmpty()){
			words.add(word);
		}
		else {
			int size = words.size();
			for(int i=0;i<size;i++){
				String letter = words.remove(0);
				stringBuilder.append(letter);
				for(int j=0;j<letter.length()+1;j++){
					words.add(stringBuilder.insert(j, word).toString());
					stringBuilder.replace(j, j+1, "");
				}
				stringBuilder.delete(0, stringBuilder.length());
			}
		}
		
	}
	
	
	private void getObject(String value){
		List<String> list = new ArrayList<>();
		String[] array = value.split("");
		for(int i=0;i<array.length;i++){
			createAnagram(array[i], list);
		}
		
		System.out.println(list);
	}

	public static void main(String[] args){
		Anagram obj = new Anagram();
		Scanner scanner = new Scanner(System.in);
		obj.getObject(scanner.nextLine());
		scanner.close();
	}
}