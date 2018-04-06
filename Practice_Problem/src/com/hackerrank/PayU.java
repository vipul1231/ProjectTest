package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PayU {
    
    public static void main(String[] args){
	
	Scanner scanner = new Scanner(System.in);
	Integer testcase = scanner.nextInt();
	List<Integer> balls = new ArrayList<>();
	
	for(int i=0;i<testcase;i++){
	    
	    Integer noOfBalls = scanner.nextInt();
	    
	    for(int j=0;j<noOfBalls;j++){
		balls.add(scanner.nextInt());
	    }
	    
	    //Start removing balls
	    boolean flag = false;
	    while(true){
		final int identifier = balls.size();
		balls = balls.stream().filter(k -> k!=identifier).collect(Collectors.toList());
		
		if(balls.size() == identifier){
		    flag = false;
		    break;
		}
		else if(balls.size() == 0){
		    flag = true;
		    break;
		}
	    }
	    
	    if(flag){
		System.out.print("YES");
	    }
	    else
		System.out.print("NO");
	    }
	    
	    
	    System.out.println(balls);
	    scanner.close();
    }
}
