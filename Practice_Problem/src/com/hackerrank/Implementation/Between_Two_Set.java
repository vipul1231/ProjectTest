package com.hackerrank.Implementation;

import java.util.Scanner;

public class Between_Two_Set {
    
    public static void main(String[] args){
	
	Between_Two_Set obj = new Between_Two_Set();
	Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        
        int result = b[0];
        for(int i=0;i<b.length;i++){
            result = obj.findGCDOfNumbers(result, b[i]);
        }
        
        int result2 = a[0];
        for(int j=0;j<a.length;j++){
            result2 = obj.findLCMOfNumber(result2, a[j]);
        }
        
        System.out.println(result);
        System.out.println(result2);
    
  
        
        in.close();
    }
    
    private int findGCDOfNumbers(int a, int number){
	
	while(number > 0){
	    int temp = number;
	    number = a % number;
	    a = temp;
	}
	return a;
    }
    
    private int findLCMOfNumber(int a, int number){
	return a * (number / findGCDOfNumbers(a, number));
    }
    
}
