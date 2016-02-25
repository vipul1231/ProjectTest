package testFunctionality;

import java.util.Random;

public class ComparableCode implements Comparable<CollectionTestClass> {
	

	public static void main(String[] args)
	{
		ComparableCode obj = new ComparableCode();
		CollectionTestClass obj1 = new CollectionTestClass();
		//CollectionTestClass obj2 = new CollectionTestClass();
		
		System.out.println(obj.compareTo(obj1));
		
	}
	
	@Override
	public int hashCode()
	{
		Random rand = new Random();
		return rand.nextInt(100);
	}

	@Override
	public int compareTo(CollectionTestClass o) {
		// TODO Auto-generated method stub
		int int1= this.hashCode();
		int int2= o.hashCode();
		
		System.out.println("This class hashCode: "+int1);
		System.out.println("Test Class HashCode: "+int2);
		
		if(int1>int2)
		{
			return 1;
		}
		else if(int1<int2)
		{
			return 2;
		}
		else
		{
			return 0;	
		}
	}

}
