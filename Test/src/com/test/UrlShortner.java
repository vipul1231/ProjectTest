package com.test;

import java.util.ArrayList;
import java.util.List;

public class UrlShortner {

	public static void main( String[] args){
		
		int n = 12345;
		int convertToBase = 62;
		String[] number = Integer.toString(n).split("");
		//System.out.println(12345%8); 
		String array = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		String[] input = array.split("");
		
		int result = 0;
		for(int i=0;i<number.length;i++){
		
			int digit = Integer.parseInt(number[i]);
			int power = (number.length-1) - i;
			result += digit*Math.pow(convertToBase, power);	
		}
		System.out.println("Base 62"+result);
		
		List<String> list1 = new ArrayList<>();
		while(n != 0){
			System.out.println(n%62+"--");
			list1.add(input[n%62]);
			n = n/62;
			System.out.println(n+" ");
		}
		
		number = list1.toArray(new String[list1.size()]);
		
		System.out.println(list1);
		
		
		int id = 0; // initialize result
		 
	    // A simple base conversion logic
	    for (int i=0; i < number.length; i++)
	    {
	        if ('a' <= number[i].charAt(i) && number[i].charAt(i) <= 'z')
	          id = id*62 + number[i].charAt(i) - 'a';
	        if ('A' <= number[i].charAt(i) && number[i].charAt(i) <= 'Z')
	          id = id*62 + number[i].charAt(i) - 'A' + 26;
	        if ('0' <= number[i].charAt(i) && number[i].charAt(i) <= '9')
	          id = id*62 + number[i].charAt(i) - '0' + 52;
	    }
	    

	    System.out.println(id);
		
	}
}
