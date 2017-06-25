package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Vipul_Anky
 *
 */

class Index {
    int row;
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }
    int column;
    
}

class Node {
    int rowIndex;
    int columnIndex;
    List<Index> possibleLinkage = new ArrayList<>();
    
    public int getRowIndex() {
        return rowIndex;
    }
    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }
    public int getColumnIndex() {
        return columnIndex;
    }
    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }
    public List<Index> getPossibleLinkage() {
        return possibleLinkage;
    } 
}

public class Turtle {

    Node[][] nodes = null;
    int N, M;
    
    public static void main(String[] args){
	Turtle turtle = new Turtle();
	//System.out.println(5%2);
	int[][] array = turtle.createArray();
	turtle.traverse(array);

    }
    
    private void traverse(int[][] array){
	
	int i=0, j=0;
	int index = i*N+M;
	nodes = new Node[N][M];
	
	nodes[i][j] = createNode(i, j);
	List<Integer> list = new ArrayList<>();
	
	while(i!=N && j!=M){
	 
	    //move diagonal first
	    boolean result = processMovement(array, i+1, j+1);
	    if(result){
		nodes[i+1][j+1] = createNode(i+1, j+1);
		Node node = nodes[i][j];
		List<Index> linkage = node.getPossibleLinkage();
		Index link = new Index();
		link.setRow(i+1);
		link.setColumn(j+1);
		linkage.add(link);
		i +=1;
		j +=1;
				
	    }
	    else {
		// move right then
		result = processMovement(array, i, j + 1);
		if (result) {
		    nodes[i][j + 1] = createNode(i, j + 1);
		    Node node = nodes[i][j];
		    List<Index> linkage = node.getPossibleLinkage();
		    Index link = new Index();
		    link.setRow(i);
		    link.setColumn(j + 1);
		    linkage.add(link);
		    j += 1;
		}
		
		else {
		    //move down then
		    result = processMovement(array, i + 1, j);
		    if(result){
			
			nodes[i+1][j] = createNode(i + 1, j);
			    Node node = nodes[i][j];
			    List<Index> linkage = node.getPossibleLinkage();
			    Index link = new Index();
			    link.setRow(i+1);
			    link.setColumn(j);
			    linkage.add(link);
			    i += 1;
		    }
		    else {
			//no further move possible
			break;
		    }
		}
	    }
	}
    }
    
    
    /**
     * Create a new Node foe given row and column.
     * 
     * @param i
     * @param j
     * @return
     */
    private Node createNode(int i, int j){
	
	Node node  = new Node();
	node.setRowIndex(i);
	node.setColumnIndex(j);	
	return node;
    }
    
    /**
     * Process movement for turtle
     * 
     * @param array
     * @param N
     * @param M
     * @return
     */
    private boolean processMovement(int[][] array, int N, int M){
	int value = array[M][N];
	//TODO : process move when 
	if(value == 2){
	    return true;
	}
	else if(value%2==0){
	    return false;
	}
	else {
	    Node node = nodes[N][M];
	    
	    return true;
	}
    }
    
    /**
     * Create the input Array.
     * 
     * @return
     */
    private int[][] createArray(){
	Scanner scanner = new Scanner(System.in);
	
	N = scanner.nextInt();
	M = scanner.nextInt();

	int[][] array = new int[N][M];
	
	for(int i=0;i<N;i++){
	    
	    for(int j=0;j<M;j++){
		array[i][j] = scanner.nextInt();
	    }
	}
	
	scanner.close();
	displayArray(array, N, M);
	return array;
    }
    
    /**
     * Display your array
     * 
     * @param array
     * @param m
     * @param n
     */
    private void displayArray(int[][] array, int m, int n){
	
	for(int i=0;i<m;i++){
	    
	    for(int j=0;j<n;j++){
		System.out.println(array[i][j]);
	    }
	}
    }
    
}
