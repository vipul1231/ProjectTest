package testPackage;

import java.util.HashMap;
import java.util.Map;

final class key
{

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
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
		key other = (key) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	final private int id;
	
	final private String address;

	key(int id, String Class)
	{
		this.id = id;
		this.address = Class;
	}
	
	public String getAddress() {
		return address;
	}

	public int getId() {
		return id;
	}
}

public class ImmutableKeyHashMap {
	
	public static void main(String[] args)
	{
		Map<key, String> lMap = new HashMap<>();
		
		key key1 = new key(1,"Add");
		key key2 = new key(1, "Add");
		key key3 = new key(3, "Subtract");
		
		System.out.println("HashCode for "+key1+" is "+key1.hashCode());
		System.out.println("HashCode for "+key2+" is "+key2.hashCode());
		System.out.println(key1.equals(key2));
		
		
		
		lMap.put(key1, "Vipul");
		lMap.put(key2, "Ankita");
		lMap.put(key3, "Nitika");
		
		
		
		
		System.out.println(lMap.get(key2));
		System.out.println(lMap.get(key1));
		
		
	}

}
