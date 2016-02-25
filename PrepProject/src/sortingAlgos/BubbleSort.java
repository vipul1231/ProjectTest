package sortingAlgos;

public class BubbleSort extends Basic_Functionality{
	
	public static void main(String[] args) {
		BubbleSort obj = new BubbleSort();
		obj.assignValuesToArray();
		obj.displayArray();
		obj.doBubbleSort();
		System.out.println("\nFinal Sorted Array: ");
		obj.displayArray();
	}
	
    private void doBubbleSort()
	{
		for(int i=0;i<MAX_LENGTH;i++)
		{
			for(int j=i+1;j<MAX_LENGTH;j++)
			{
				if(intAray[i]>intAray[j])
				{
					doSwap(intAray, i, j);
				}
			}
			System.out.println();
		displayArray();	
		}
	}
}
