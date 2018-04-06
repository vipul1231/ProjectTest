package com.hackerrank;

import java.util.Scanner;

public class RBS {
    
    static int countSetBits( int n){
	int count = 0;
	 while (n > 0) {           
	        if ((n & 1) == 1) 
	            count++;
	        n >>= 1;  
	 }
	 return count;
    }
    
    public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	int N = scanner.nextInt();
	//double M  = 10000000011;
	Double number = 0d;
	for(int i=1;i<=N;i++){
	    
	    Double a = Math.pow(countSetBits(scanner.nextInt()), i);
	    //int a = findPower(countSetBits(scanner.nextInt()), i);
	    number += a;
	}
	System.out.println(number.intValue()%(10^10+11));
	
	scanner.close();
    }
    
    static int findPower(int number, int power){
	
	int result = 1;
	
	for(int i=0;i!=power;i++){
	    result = result * number;
	}
	
	return result;
	
    }

}
