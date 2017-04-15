package com.pattern;

import java.util.Scanner;

/**
 * Create Pattern 
 * 
 * [ 1, 2, 3, 4, 5, 6]
 * [ 7, 8, 9, 10, 11, 12]
 * [12, 13, 14, 15, 16, 17]
 * 
 * Print all diagonals values:
 * 
 * [1,
 * 7,2,
 * 12,8,3,
 * 13,9,4,
 * 14,10,5
 * 15,11,6
 * 16,12
 * 17]
 * 
 * 
 * @author Vipul_Anky
 *
 */
public class Pattern implements Runnable{
    
    
    volatile int[][] array = null;
    
    volatile int row = 0;
    volatile int column = 0;
    
    /**
     * Assign unique number to array.
     * 
     * @param row
     * @param column
     */
    private int[][] assignNumberInArray(int row, int column)
    {
	int count = 1;
	int[][] array = new int[row][column];
	for(int i=0;i<row;i++)
	{
	    for(int j=0;j<column;j++)
	    {
		array[i][j]=count;
		count++;
	    }
	    System.out.println();
	}
	return array;
    }
    
    /**
     * Print array.
     * 
     * @param array
     * @param row
     * @param column
     */
    private void printArray(int[][] array, int row, int column)
    {
	for(int i=0;i<row;i++){
	    for(int j=0;j<column;j++){
		System.out.print(array[i][j] + " | ");
	    }
	    System.out.println();
	}
    }
    
    /**
     * Print the pattern.
     * 
     * @param array
     * @param iRow
     * @param iColumn
     */
    private void printPattern(int[][] array, int iRow, int iColumn)
    {
	int row = 0, column = 0;
	
	for(int i=0;i<iRow+iColumn;i++)
	{
	   int pRow = row,pColumn = column;
	   while(validateCoordinate(pRow, pColumn, iRow, iColumn))
	   {
	       System.out.print(array[pRow][pColumn] + " ");
	       --pRow;
	       ++pColumn;
	   }
	   System.out.println();
	   
	   if(row == (iRow-1))
	   {
	       column++;
	   }
	   
	   else{
	       row++;
	   }
	}
    }
    
    /**
     * Validate Coordinates for the row and column
     * 
     * @param row
     * @param column
     * @param mRow
     * @param mColumn
     * @return
     */
    private boolean validateCoordinate(int row, int column, int mRow,int mColumn)
    {
	for(int i=0;i<mRow;i++)
	{
	    for(int j=0;j<mColumn;j++)
	    {
		if(row == i && column == j){
		    return true; 
		}
	    }
	}
	return false;
    }
    
    
    public static void main(String[] args)
    {
	Pattern pattern = new Pattern();
	
	Thread th1 = new Thread(pattern);
	th1.start();
	th1.setName("Assign_Numbers");
	try {
	    th1.join();
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	Thread th2 = new Thread(pattern);
	th2.setName("Display_Number");
	th2.start();
	
	Thread th3 = new Thread(pattern);
	th3.setName("Print_Pattern");
	th3.start();
    }

    @Override
    public void run() {
	// TODO Auto-generated method stub
	synchronized (this) {
	    String threadName = Thread.currentThread().getName(); 
	    
	    if(threadName.equals("Assign_Numbers")){
		System.out.println("Enter the row and column: ");	
		Scanner scanner = new Scanner(System.in);
		row= scanner.nextInt();
		column = scanner.nextInt();
		array = assignNumberInArray(row, column);
		scanner.close();
	    }
	    
	    else if(threadName.equals("Display_Number")){
		System.out.println(threadName+" thread printing array.");
		printArray(array, row, column);
	    }
	    
	    else if(threadName.equals("Print_Pattern")){
		System.out.println(threadName+" thread printing pattern.");
		printPattern(array, row, column);
	    }
	    
	}
    }

}
