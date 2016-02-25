package testFunctionality;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashCodeTest {
	
	int a = 0;
	
	long s;
	
	float e;
	
	boolean w;
	
	double i;
	
	String name ="vipul";


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + Float.floatToIntBits(e);
		long temp;
		temp = Double.doubleToLongBits(i);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (s ^ (s >>> 32));
		result = prime * result + (w ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashCodeTest other = (HashCodeTest) obj;
		if (a != other.a)
			return false;
		if (Float.floatToIntBits(e) != Float.floatToIntBits(other.e))
			return false;
		if (Double.doubleToLongBits(i) != Double.doubleToLongBits(other.i))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (s != other.s)
			return false;
		if (w != other.w)
			return false;
		return true;
	}
	
	static Set<HashCodeTest> set = new HashSet<HashCodeTest>();
	
	static Map<HashCodeTest, Integer> map = new HashMap<>();
	
	public static void main(String[] args)
	{
	HashCodeTest obj = new HashCodeTest();
	HashCodeTest obj1 = new HashCodeTest();
	
	System.out.println(obj.hashCode());
	System.out.println(obj1.hashCode());
	
	set.add(obj);
	set.add(obj1);
	
	map.put(obj, 1);
	map.put(obj1, 1);
	
	System.out.println(set.size());
	System.out.println(map.size());
	
	}
}
