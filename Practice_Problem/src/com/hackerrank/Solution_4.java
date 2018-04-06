package com.hackerrank;

import java.util.Scanner;

public class Solution_4 {
    
    public static void main(String[] args){
	 
    Scanner s = new Scanner(System.in);
    String N = s.nextLine();
    int number = Integer.parseInt(N);
    
    for (int i = 0; i <number; i++) {
	String[] numbers = s.nextLine().split(" ");
	System.out.println(Long.parseLong(numbers[0])+Long.parseLong(numbers[1]));
    }
    
    s.close();
    }
}
