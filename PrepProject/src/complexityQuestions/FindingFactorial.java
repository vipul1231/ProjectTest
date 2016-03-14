package complexityQuestions;

public class FindingFactorial {
	
	int number = 1234;
	
	private int[] buildNumberArray()
	{
	
		String strNumber = Integer.toString(number);
		String[] strArray= strNumber.split("");
		
		int[] intArray = new int[strArray.length];
		
		for(int i=0;i<intArray.length;i++)
		{
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		
		return intArray;
	}
	
	
	private void doFactorial(int[] array, int maxCombo)
	{
		int maxComb = calculateFactorial(array.length);
		int start = 0;
		
		
		while(start!=maxComb)
		{
			
		}
	}


	private int calculateFactorial(int number)
	{
		int result=1;
		for(int i=number;i<=1;i--)
		{
			result = result*i;
		}
		return result;
	}
	
	
	public static void main(String[] args)
	{
		
	}

}
