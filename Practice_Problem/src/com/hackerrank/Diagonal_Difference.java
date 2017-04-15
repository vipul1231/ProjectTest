package com.hackerrank;

import java.util.Scanner;

public class Diagonal_Difference {
    
    public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	
	int matrixSize  = Integer.parseInt(scanner.nextLine());
	
	String[][] matrix = new String[matrixSize][matrixSize];
	
	int count;
	for(int i=0;i<matrixSize;i++){
	    String[] input = scanner.nextLine().split(" ");
	    count =0;
	    for(int j=0;j<matrixSize;j++){
		matrix[i][j] = input[count];
		count++;
	    }
	}
	
	int row =0, column =0;
	int primary = 0, secondary =0;
	//primary diagonal

	while(row !=matrixSize && column!=matrixSize){
	    int value = Integer.parseInt(matrix[row][column]);
	    primary+=value;
	    ++row;
	    ++column;
	}
	
	row =0;
	column=matrixSize;
	while(row!=matrixSize && column !=0){
	    int value = Integer.parseInt(matrix[row][column-1]);
	    secondary+=value;
	    row++;
	    column--;
	}
	
	System.out.println(Math.abs(primary-secondary));
	
	
	
	
	scanner.close();
    }

}
