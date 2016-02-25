package testFunctionality;

import java.util.HashMap;
import java.util.Map;


class testOverride
{	
	void getMethod() throws Exception
	{
		System.out.println("Exception Testing");
	}
	
}


public class CollectionTest extends testOverride{
	
	
	@Override
	void getMethod() throws RuntimeException
	{
		System.out.println("Exception");
	}

	static Map<String, CollectionTestClass> obj = null;

	public static void main(String[] args) {
		
		obj = new HashMap<>();
		
		CollectionTest obj1 = new CollectionTest();
		CollectionTest obj2 = new CollectionTest();
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println(obj1.equals(obj2));
		
	}

}
