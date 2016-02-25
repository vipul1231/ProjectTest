package testFunctionality;

import java.util.HashMap;
import java.util.Map;

public class TestNewArrayList {

	static String list = "tweter";
    static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args)
	{
		char[] chr = list.toCharArray();
		
		for(int i=0;i<=chr.length;i++)
		{
			
			
			map.put(Character.toString(chr[i]), 1);
		}
	}
	
}
