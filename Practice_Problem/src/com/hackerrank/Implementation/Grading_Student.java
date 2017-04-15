package com.hackerrank.Implementation;

import java.util.Scanner;

public class Grading_Student {
    
    public static void main(String[] args){
	
	Grading_Student grading_Student = new Grading_Student();
	Scanner scanner = new Scanner(System.in);
	
	int numberOfTest = Integer.parseInt(scanner.nextLine());
	
	for(int i=0;i<numberOfTest;i++){
	    int number = grading_Student.getNextMultipleOfFive(Integer.parseInt(scanner.nextLine()));
	    System.out.println(number);
	}
	scanner.close();
    }
    
    
    private int getNextMultipleOfFive(int number){
	int cloneTheNumber  = number;
	if(number < 38){
	    return number;
	}
	
	while(cloneTheNumber%5!=0){
	    cloneTheNumber++;
	}
	
	if(cloneTheNumber-number<3){
	    return cloneTheNumber;
	}
	else {
	    return number;
	}
    }

}
