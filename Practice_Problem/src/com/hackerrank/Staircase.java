package com.hackerrank;

import java.util.Scanner;

public class Staircase {
    
    public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	int a = scanner.nextInt();
	int space = a-1;
	for(int i=1;i<=a;i++){
	    int countSpace=0;
	    while(countSpace != space){
		System.out.print(" ");
		countSpace++;
	    }
	    for(int j=0;j<i;j++){
		System.out.print("#");
	    }
	    space--;
	    System.out.println();
	}
	
	scanner.close();
    }

}
