package com.hackerrank.Implementation;

import java.util.Scanner;

public class Kangaroo {
    
    public static void main(String[] args){
	
	Scanner scanner =  new Scanner(System.in);
	
	int start = scanner.nextInt();
	int jump = scanner.nextInt();
		
	int start1 = scanner.nextInt();
	int jump1 = scanner.nextInt();
	
	boolean flag = false;
	int k1 = start,k2 = start1;
	
	for(int i=0;i<10000;i++){
	    k1 = k1+jump;
	    k2 = k2+jump1;
	    
	    if(k1==k2){
		flag = true;
		break;
	    }
	}
	
	if(flag==true){
	    System.out.println("YES");
	}
	else{
	    System.out.println("NO ");
	}
	
	scanner.close();
    }

}
