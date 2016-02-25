package sortingAlgos;

public class InsertionSort extends Basic_Functionality{
	
	public static void main(String[] args)
	{
		InsertionSort obj = new InsertionSort();
		obj.assignValuesToArray();
		obj.displayArray();
		obj.doInsertionSort();
		obj.displayArray();
	}
	
	private void doInsertionSort()
	{
		for(int i=0;i<MAX_LENGTH;i++)
		{
			int temp=i;
			while(temp!=0)
			{
				if(temp-1<0)
				{
					continue;
				}
				if(intAray[temp-1]>intAray[temp])
				{
					doSwap(intAray, temp-1, temp);
				}
				temp--;
			}
			System.out.println();
			displayArray();
		}
	}

}
