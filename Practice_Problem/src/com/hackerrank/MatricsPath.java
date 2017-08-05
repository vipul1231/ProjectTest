package com.hackerrank;

import java.util.Scanner;

public class MatricsPath {
    
    public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	
	int a = scanner.nextInt();
	int b = scanner.nextInt();
	
	int[][] array = new int[a+1][b+1];
	int[][] dup = new int[a+1][b+1];
	
	
	for(int i=1;i<=a;i++){
	    for(int j=1;j<=b;j++){
		array[i][j] = scanner.nextInt();
	    }
	}
	
	
	System.out.println("Printing");
	for (int i = 1; i <= a; i++) {

	    for (int j = 1; j <= b; j++) {
		System.out.print(array[i][j]+" ");
	    }
	    System.out.println();
	}
	
	/*for(int i=0;i<a;i++){
	    dup[i][0] = 1;
	}
	
	for(int j=0;j<b;j++){
	    dup[0][j] = 1;
	}*/
	
	dup[1][1] = 1;
	for(int i=1;i<=a;i++){
	   
	    for(int j=1;j<=b;j++){
		
		if(i==1 && j==1){
		    continue;
		}
		
		/*if(i==0){
		    dup[i][j] = array[i][j] + array[i][j-1];
		    continue;
		}
		
		else if(j==0){
		    dup[i][j] = array[i][j] + array[i-1][j];
		    continue;
		}*/
		
		
		dup[i][j] = dup[i-1][j] + dup[i][j-1] + dup[i-1][j-1];
		
		if(array[i][j] == 0){
		    dup[i][j] = 0;
		    continue;
		}
	    }
	}
	
	System.out.println(dup[a][b]);
	
	for (int i = 0; i <= a; i++) {

	    for (int j = 0; j <= b; j++) {
		System.out.print(dup[i][j]+" ");
	    }
	    System.out.println();
	}
	
	scanner.close();
	
	
    }
}
