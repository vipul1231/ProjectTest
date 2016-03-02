package complexityQuestions;

public class BuildingMaxHeap {
	
	int[] mainArray = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};	
	
	private void buildHeapMax(int i)
	{
		int largest =i;
		int left = i*2; //2*i+1
		int right = i*2+1; //2*i+2
		
		if((left < mainArray.length) && (mainArray[left] > mainArray[largest]))
		{
			largest = left;
		}


		if((right < mainArray.length) && (mainArray[right] > mainArray[largest]))
		{
			largest = right;
		}
		
		
		if(largest != i)
		{
			swap(i, largest);
			buildHeapMax(largest);
		}
	}
	
	
	private void swap(int i, int largest)
	{
		int temp = mainArray[i];
		mainArray[i] = mainArray[largest];
		mainArray[largest] = temp;
	}
	
	private void printArray()
	{
		for(int i=0;i<mainArray.length;i++)
		{
			System.out.println(mainArray[i]);
		}
	}
	
	
	public static void main(String[] args)
	{
		BuildingMaxHeap obj = new BuildingMaxHeap();
		obj.startTheHeapStructure();
		obj.printArray();
	}
	
	private void startTheHeapStructure()
	{
		for(int i=((mainArray.length)-2)/2;i>=0;--i)
		{
			buildHeapMax(i);
		}
	}

}
