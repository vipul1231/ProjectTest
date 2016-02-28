package complexityQuestions;


/**
 * 
 * @author vipult
 *
 */
public class LongestSubSequenceTest {
	
	int arr[] = {15,10,7,6,9,10,8,30,33,32,34,37,38,35,36};
	
	/**
	 * Bubble sort Complexity O(n^2)
	 */
	private void sortTheArray()
	{
	
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	/**
	 * Class to store length.
	 * 
	 * @author vipult
	 *
	 */
	private class StoreLength
	{
		private int start=0, end =0;

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}
	}
	
	
	/**
	 * Finding Sequence O(n^2)
	 * 
	 * @return
	 */
	private StoreLength[] findSubSequence()
	{
		int firstNumber = 0, nextNumber = 0, mainCounter=0, mainArrayLength = arr.length;
		StoreLength[] completeArray = new StoreLength[100];
		boolean sequenceFound = false;
		int counter = 0;
		for(int i=0;i<mainArrayLength;i++)
		{
			if(!sequenceFound)
			{
				if(counter >= 1)
				{
					StoreLength obj = new StoreLength();
					obj.setStart(firstNumber);
					obj.setEnd(counter);
					completeArray[mainCounter] = obj;
					mainCounter++;
					counter = 0;
				}
				firstNumber = arr[i];
				nextNumber = firstNumber+1;	
			}
			
			else
			{
				nextNumber = nextNumber+1;
				sequenceFound = false;
			}
			
			for(int j=i+1;j<mainArrayLength;j++)
			{
				if(arr[j] == nextNumber)
				{
					sequenceFound = true;
					if(mainArrayLength-1==j)
					{
						sequenceFound = false;
					}
					counter++;
					break;
				}
			}
		}
		return completeArray;
	}
	
	/**
	 * 
	 * 
	 * @param array
	 */
	void traverseArray(StoreLength[] array)
	{
		int firstNumber = 0, numberToBeAdded = 0, max=0; 
		
		if(array[0] == null)
		{
			System.out.println("No Sub Sequence found");
			System.exit(0);
		}
		
		for(int i=0;i<array.length;i++)
		{
			StoreLength object = array[i];
			
			if(object == null)
			{
				break;
			}
			
			if(object.getEnd() > max)
			{
				firstNumber = object.getStart();
				numberToBeAdded = object.getEnd();
				max = object.getEnd();
			}
		}
		
		//form the largest sequence
		
		System.out.print("Longest Sub Sequence: ");
		
		for(int j=0;j<=numberToBeAdded;j++)
		{
			System.out.print(" "+firstNumber);
			firstNumber = firstNumber + 1;
		}
		
	}
	

	public static void main(String[] args)
	{
		LongestSubSequenceTest obj = new LongestSubSequenceTest();
		obj.sortTheArray();
		obj.traverseArray(obj.findSubSequence());
	}
}
