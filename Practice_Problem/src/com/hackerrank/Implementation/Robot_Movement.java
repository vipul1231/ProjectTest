package com.hackerrank.Implementation;

import java.util.Scanner;

public class Robot_Movement {
     
    public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the X coordinate: ");
	int a = scanner.nextInt();
	
	System.out.println("Enter the Y coordinate: ");
	int b = scanner.nextInt();
	
	System.out.println(voidMax(a,b));
	scanner.close();
    }
    
    static int voidMax(int m, int n){
	
	if(m==0 || n==0)
	{
		if(m==0)
			return n;
		else
			return m;
	}
	int a[][]=new int[m][n];
	a[0][0]=0;
	for(int i=1; i<m; i++)
		a[i][0]=1;
	for(int j=1; j<n; j++)
		a[0][j]=1;
	for(int i=1;i<m;i++)
	{
		for(int j=1;j<n;j++)
		{
			a[i][j]=a[i][j-1]+a[i-1][j];
		}
	}
	
	for(int i=0;i<m;i++){
	    
	    for(int j=0;j<n;j++){
		System.out.print(a[i][j]+" ");
	    }
	    System.out.println();
	}
	return a[m-1][n-1];
    }
}