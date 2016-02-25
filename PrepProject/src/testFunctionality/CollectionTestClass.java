package testFunctionality;

import java.util.Random;

public class CollectionTestClass {
	
	@Override
	public int hashCode()
	{
     Random obj = new Random();
	 return	obj.nextInt(100);
	}

}
