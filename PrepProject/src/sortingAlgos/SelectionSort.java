package sortingAlgos;

public class SelectionSort extends Basic_Functionality{
	
	public static void main(String[] args)
	{
		SelectionSort obj = new SelectionSort();
		obj.assignValuesToArray();
		obj.displayArray();
		obj.doSelectionSort();
		obj.displayArray();
	}
	
	private void doSelectionSort()
	{
		for(int i=0;i<MAX_LENGTH;i++)
		{
			int minValue = intAray[i];
			int minindex = i;
			for(int j=i;j<MAX_LENGTH;j++)
			{
				if(intAray[j]<minValue)
				{
					minValue=intAray[j];
					minindex = j;
				}
			}
			doSwap(intAray, i, minindex);
			displayArray();
			System.out.println();
		}
	}

}
