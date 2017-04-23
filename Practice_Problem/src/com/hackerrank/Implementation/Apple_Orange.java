package com.hackerrank.Implementation;

import java.util.Scanner;
import java.util.stream.Stream;

public class Apple_Orange {
    
    public static void main(String[] args){
	Apple_Orange apple_Orange = new Apple_Orange();
	
	Scanner scanner = new Scanner(System.in);
	int[] houseCoordinate  = apple_Orange.convertStringToIntArray(apple_Orange.coordinates(scanner.nextLine()));
	int[] treeCoordinate = apple_Orange.convertStringToIntArray(apple_Orange.coordinates(scanner.nextLine()));
	scanner.nextLine();
	
	int[] apple_Coordinate = apple_Orange.convertStringToIntArray(apple_Orange.coordinates(scanner.nextLine()));
	int[] orange_Coordinate = apple_Orange.convertStringToIntArray(apple_Orange.coordinates(scanner.nextLine()));
	
	
	int appleCount=0,orangeCount=0;
	
	for(int i=0;i<apple_Coordinate.length;i++){
	    apple_Coordinate[i]  = treeCoordinate[0] + apple_Coordinate[i];
	    if(apple_Coordinate[i] >= houseCoordinate[0] && apple_Coordinate[i] <= houseCoordinate[1]){
		appleCount++;
	    }
	}
	
	for(int i=0;i<orange_Coordinate.length;i++){
	    orange_Coordinate[i]  = treeCoordinate[1] + orange_Coordinate[i];
	    if(orange_Coordinate[i] >= houseCoordinate[0] && orange_Coordinate[i] <= houseCoordinate[1]){
		orangeCount++;
	    }
	}
	
	System.out.println(appleCount);
	System.out.println(orangeCount);
	scanner.close();
	
	
	
	
	
	
    }
    
    
    
    
    private String[] coordinates(String input){
	return input.split(" ");
    }
    
    private int[] convertStringToIntArray(String[] input){
	 return Stream.of(input).mapToInt(Integer::parseInt).toArray();
    }
    
    

}
