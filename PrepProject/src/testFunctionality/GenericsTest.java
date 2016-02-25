package testFunctionality;

import java.util.Comparator;

interface Pair<K,V>
{
	public K getkey();
	
	public V getValue();
}

public class GenericsTest<E, K, V> implements Comparator<E>, Pair<K,V>{
	
	private K key;
	
	private V value;
	
	public GenericsTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	GenericsTest (K k,V v)
	{
		this.key = k;
		this.value = v;
	}
	
	
	@Override
	public int compare(E o1,E o2) {
		// TODO Auto-generated method stub
		if(o1.equals(o2))
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	

	
	public static <T extends Comparable<T>> T maximum(T x, T y, T z)
	{
		T max = x;
		
		if(y.compareTo(max) > 0)
		{
			max = y;
		}
		
		if(z.compareTo(max) > 0)
		{
			max = z;
		}
		
		return max;
	}
	
	/**
	 * Generic function
	 * 
	 * @param array
	 */
	public static <E> void printArray(E[] array)
	{
		for(E element : array)
		{
			System.out.println("Element: "+ element);
		}
	}
	
	public static void main(String[] args)
	{
		GenericsTest<Integer, String, Integer> obj = new GenericsTest<Integer, String, Integer>("Vipul",4);
		
		System.out.println("Key: "+obj.getkey());
		
		System.out.println("Value:"+obj.getValue());
		
		Integer[] integerArray = {1,2,3,4,5};
		Double[] doubleArray = {1.1,2.2,3.3,4.4,5.5};
		Character[] charArray = {'H','L','L','O'};
		
		System.out.println("Printing integer array: ");
		printArray(integerArray);
		
		System.out.println("Printing double array: ");
		printArray(doubleArray);
		
		System.out.println("printing character array: ");
		printArray(charArray);
		
		//Finding maximum if this array!!
		System.out.println("Maximum is: "+maximum(3, 4, 5));
		
		System.out.println("Maximum is: "+obj.compare(3, 3));
	}



	@Override
	public K getkey() {
		// TODO Auto-generated method stub
		return key;
	}



	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}


	public void setKey(K key) {
		this.key = key;
	}



	public void setValue(V value) {
		this.value = value;
	}
}