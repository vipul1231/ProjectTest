package com.hackerrank.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixRotation {
    
    int[][] globalMatrix;
    
    public static void main(String[] args){
	
	MatrixRotation matrixRotation = new MatrixRotation();
	Scanner scanner = new Scanner(System.in);
	int row = scanner.nextInt();
	int column = scanner.nextInt();
	int[][] matrix = new int[row][column];
	int rotations = scanner.nextInt();
	for(int i=0;i<row;i++){
	    
	    for(int j=0;j<column;j++){
		matrix[i][j] = scanner.nextInt();
	    }
	}
	
	matrixRotation.displayMatrix(matrix, row, column);
	matrixRotation.findCircleInMatrix(matrix, row, column);
	
	scanner.close();
    }
    
    
    private void displayMatrix(int[][] matrix, int row, int column){
	for(int i=0;i<row;i++){
	    for(int j=0;j<column;j++){
		System.out.print(matrix[i][j]+" ");
	    }
	    System.out.println();
	}
    }
    
    private void findCircleInMatrix(int[][] matrix, int row, int column){
	
	int constantRow = row;
	int constantColumn = column;
	int row_1 = 0;
	int column_1 = 0;
	boolean rowTraversal = true;
	boolean  columnTraversal = false;
	while(true){
	    List<Integer> list = new ArrayList<>();
	    if(rowTraversal){
		for(int i=0;i<constantRow;i++){
		list.add(matrix[row_1][i]);
		}
		rowTraversal=false;
		continue;
	    }
	    
	    if(columnTraversal){
		for(int i=0;i<constantColumn;i++){
		list.add(matrix[i][constantColumn]);    
		}
		rowTraversal = true;
	    }
	}
    }
}
