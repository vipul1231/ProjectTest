package sortingAlgos;

import java.util.Random;

abstract class Basic_Functionality {
	
    protected static final int MAX_LENGTH = 5;
	
	int[] intAray = new int[MAX_LENGTH];
	
    protected void assignValuesToArray()
    {
    	Random rand = new Random();
    	for(int i=0;i<MAX_LENGTH;i++)
    	{
    		intAray[i]=rand.nextInt(100);
    	}
    }
     
    protected void displayArray()
    {
    	System.out.print("String Content: ");
    	for(int i=0;i<MAX_LENGTH;i++)
    	{
    		System.out.print(intAray[i]+" ");
    	}
    }
    
    protected void doSwap(int[] array, int index1,int index2)
    {
    	int a = array[index1];
    	array[index1] = array[index2];
    	array[index2] = a;
    }

}
