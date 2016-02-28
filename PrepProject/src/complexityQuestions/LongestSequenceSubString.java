package complexityQuestions;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Algo to find longest substring
 * 
 * @author vipult
 *
 */
public class LongestSequenceSubString {
	
	int order;
	
	String str = "asddfffgggggghhhhhhjkttttzzziiiieeeeeeeeeeeeeee";
	
	public int getUniqueCharacter() {
		return order;
	}

	public void setUniqueCharacter(int uniqueCharacter) {
		this.order = uniqueCharacter;
	}
	
	/**
	 * Check the Sub String : Complexity O(n + k) where k stands for number of unique character in String
	 * 
	 * @return
	 */
	private String[] checkTheSubString()
	{
		if(order==0)
		{
			System.out.println("Unique charcter input is ZERO. Please check");
		}
		
		Set<String> hashSet = new LinkedHashSet<>();
		String[] array = str.split("");
		
		//Complexity O(n)
		for(int i=0;i<array.length;i++)
		{
		   hashSet.add(array[i]);
		}
		
		Object[] uniqueCharcterArray = (Object[]) hashSet.toArray();
		hashSet.clear();
		int length = uniqueCharcterArray.length; 
		String[] output = new String[length];
		
		//Complexity O(k)
		for(int i=0;i<length;i++)
		{
			if((i+(order-1)) > uniqueCharcterArray.length-1)
			{
				break;
			}
			String firstCharacter = (String) uniqueCharcterArray[i];
			String lastCharacter = (String) uniqueCharcterArray[i+(order-1)];
			String result = str.substring(str.indexOf(firstCharacter), str.lastIndexOf(lastCharacter)+1);
			output[i] = result;	
		}

		return output;
	}
	
	/**
	 * Now traverse the string
	 * 
	 * @param array
	 */
	private void traverseTheArray(String[] array)
	{
		int max = 0;
		String output = null;
		if(array[0] == null)
		{
			System.out.println("Nothing found after evaluation");
		}
		for(String str : array)
		{
			if(str == null)
			{
				break;
			}
			if(str.length() > max)
			{
				output = str;
				max = str.length();
			}
		}
		
		System.out.println("Longest substring: "+output+" with length: "+max);
	}
	
	public static void main(String[] args)
	{
		LongestSequenceSubString obj = new LongestSequenceSubString();
		obj.setUniqueCharacter(2);
		obj.traverseTheArray(obj.checkTheSubString());
	}
}
