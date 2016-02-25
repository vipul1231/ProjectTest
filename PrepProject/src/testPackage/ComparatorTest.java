package testPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Dog implements Comparator<Dog>, Comparable<Dog>{
	
	String name;
	int age;
	
	/**
	 * 
	 * @param name
	 * @param age
	 */
	Dog(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	Dog()
	{
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Dog o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
		
	}

	@Override
	public int compare(Dog o1, Dog o2) {
		// TODO Auto-generated method stub
		//return o1.age-o2.age;
		
		if(o1.age>o2.age)
		{
			return 1;
		}
		
		else if(o1.age<o2.age)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}


public class ComparatorTest
{
	public static void main(String[] args)
	{
		Comparator<Dog> lComparator = new Dog();
		List<Dog> lList = new ArrayList<>();
		lList.add(new Dog("Tommy",12));
		lList.add(new Dog("Lucy",10));
		lList.add(new Dog("Pomerian",13));
		lList.add(new Dog("Putty",9));
		lList.add(new Dog("Tutty",17));
		
		java.util.Collections.sort(lList);
		
		for( Dog d : lList)
		{
			System.out.print(" "+d.getName()+" "+d.getAge());
		}
		
		Collections.sort(lList, lComparator);
		
		System.out.println();
		
		for( Dog d : lList)
		{
			System.out.print(" "+d.getName()+" "+d.getAge());
		}
				
	}
}