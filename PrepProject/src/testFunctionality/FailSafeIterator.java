package testFunctionality;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeIterator {
	
	public static void main(String[] args)
	{
		System.out.println("Trying ConcurrentHashMap");
		Map<String, String> lMap = new ConcurrentHashMap<>();
		Map<String, String> lMap2 = new HashMap<>();
		FailSafeIterator obj = new FailSafeIterator();
		FailSafeIterator obj1 = new FailSafeIterator();
		obj.putValuesToMap(lMap);
		obj.iterateOnMap(lMap);
		
		//Will produce concurrent modification exception.
		System.out.println("Trying Normal HashMap");
		obj1.putValuesToMap(lMap2);
		obj1.iterateOnMap(lMap2);
	}
	
	
	private void putValuesToMap(Map<String, String> lMap)
	{
		lMap.put("Vipul", "Tiwari");
		lMap.put("Mridul", "Tiwari");
	}
	
	private void iterateOnMap(Map<String, String> lMap)
	{
		Set<String> lSet = lMap.keySet();
		
		Iterator<String> lter = lSet.iterator();
		
		while(lter.hasNext())
		{
			System.out.println(lter.next());
			lMap.put("Ramesh", "Chandra");
		}
	}
}
