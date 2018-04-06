package com.test;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SpiralTraversalMatrix {
	
	Map<Node, String> map = new HashMap<>();
	
	class Node {
		int row;
		int column;
		int value;
		
		Node(int row, int column, int value){
			this.row = row;
			this.column = column;
			this.value = value;
		}
		
		public int hashcode(){
			int prime = 37;
			int r = row+7;    //1+7+3+11, 3+7+1+11
			int c = column+11;
			return prime+r+c;
		}
		
		public boolean equals(Object obj){
			
			if(obj==null) return false;
			if(!(obj instanceof Node)) return false;
			
			Node node = (Node) obj;
			if(this.row == node.row && this.column==node.column){
				return true;
			}
			return false;
		}
	}
	
	
	/**
	 * Traverse matrix in spiral order.
	 * 
	 * @param array
	 */
	
	private void traverseMatrixSpiral(Node[][] array){
		
		int maxRowLimit = array.length;
		int maxColumnLimit = array[maxRowLimit-1].length;
		int noOfElements = maxColumnLimit*maxRowLimit;
		int nCount = 1;
		int row = 0;
		int column = 0;
		int minRow = 0;
		int minColumn = 0;
		while(true){
			String[] rule = ruleBooks(nCount);
			
			if (rule[0].equals("COLUMN") && rule[1].equals("INCR")){
				if(map.containsKey(array[row][column])){
					column++;
					continue;
				}
				else {
					System.out.print(array[row][column].value+" ");
					map.put(array[row][column],"NULL");
					column++;
				}
			}
			
			else if (rule[0].equals("ROW") && rule[1].equals("INCR")){
				if(map.containsKey(array[row][column])){
					row++;
					continue;
				}
				else {
					System.out.print(array[row][column].value+" ");
					map.put(array[row][column],"NULL");
					row++;
				}
			}
			
			else if (rule[0].equals("COLUMN") && rule[1].equals("DECR")){
				if(map.containsKey(array[row][column])){
					column--;
					continue;
				}
				else {
					System.out.print(array[row][column].value+" ");
					map.put(array[row][column],"NULL");
					column--;
				}
			}

			else if(rule[0].equals("ROW") && rule[1].equals("DECR")){
				if(map.containsKey(array[row][column])){
					row--;
				}
				else {
					System.out.print(array[row][column].value+" ");
					map.put(array[row][column],"NULL");
					row--;
				}
			}
			
			//Check condition to make new iteration.
			if(column == maxColumnLimit && rule[1].equals("INCR")){
				nCount++;
				column = maxColumnLimit-1;
			}
			else if (column == maxColumnLimit && rule[1].equals("DECR")){
				nCount++;
				column = maxColumnLimit-1;
			}
			else if(column < minColumn && rule[1].equals("DECR")){
				nCount++;
				column = minColumn;
			}
			
			if(row == maxRowLimit && rule[1].equals("INCR")){
				nCount++;
				row = maxRowLimit-1;
			}
			else if(row == maxRowLimit && rule[1].equals("DECR")){
				nCount++;
				row = maxRowLimit - 1;
			}
			
			else if(row < minRow && rule[1].equals("DECR")){
				nCount++;
				row = minRow;
			}
			
			if(nCount > 4){
				nCount = 1;
				maxColumnLimit = maxColumnLimit-1;
				maxRowLimit = maxRowLimit - 1;
				row = minRow = row +1;
				column = minColumn = column+1;
				
			}
			
			if(map.size() == noOfElements){
				System.out.println("Iteration Ended");
				break;
			}
			
		}
	}
	
	
	private String[] ruleBooks(int iteration){
		String[] array = new String[2];
		if(iteration == 1){
			array[0] = "COLUMN";
			array[1] = "INCR";
		}
		else if(iteration == 2){
			array[0] = "ROW";
			array[1] = "INCR";
		}
		else if(iteration == 3){
			array[0] = "COLUMN";
			array[1] = "DECR";
		}
		
		else{
			array[0] = "ROW";
			array[1] = "DECR";
		}
		
		return array;
	}
	
	/**
	 * Populate matrix
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	private Node[][] populateMatrix(int row, int column){
		
		Node[][] array= new Node[row][column];
		
		Random rand = new Random();
		for(int i=0;i<row;i++){
			
			for(int j=0;j<column;j++){
				int number = rand.nextInt(1000); 
				number  = number < 100 ? number+100 : number;
				Node node = new Node(i, j, number);
				array[i][j] = node;
			}
		}
		
		return array;
	}
	
	
	private void displayMatrix(Node[][] matrix){
		int row = matrix.length;
		int column = matrix[0].length;
		
		for(int i=0;i<row;i++){
			
			for(int j=0;j<column;j++){
				System.out.print(matrix[i][j].value+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String...strigs){
		SpiralTraversalMatrix obj = new SpiralTraversalMatrix();
		Node[][] matrix = obj.populateMatrix(6, 6);
		System.out.println("Display Matrix: ");
		obj.displayMatrix(matrix);
		System.out.println("Printing Spiral: ");
		obj.traverseMatrixSpiral(matrix);
		
	}
}
