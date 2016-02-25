package testPackage;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class ValueComparator implements Comparator<String>
{
	
	Map<String, Integer> base;
	
	public ValueComparator(Map<String, Integer> base) {
		this.base = base;
		System.out.println(this);
		System.out.println(this.base);
	}
	@Override
	public int compare(String o1, String o2) {
		if(base.get(o1) >= base.get(o2))
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	
}

public class SortIntHashMap {
	
	public static void main(String[] args)
	{
	Map<String, Integer> map = new HashMap<>();
	ValueComparator cmp = new ValueComparator(map);
	
	Map<String, Integer> lMap = new TreeMap<>(cmp);
	
	map.put("1", 99);
	map.put("2", 45);
	map.put("3", 65);
	map.put("4", 76);
	map.put("5", 45);
	System.out.println("unsorted Map: "+ map);
	
	lMap.putAll(map);
	
	System.out.println("Sorted Map: "+ lMap);
	
	
	}
}
