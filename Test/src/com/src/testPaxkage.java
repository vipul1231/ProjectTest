package com.src;

class B
{
	int i =99;
	public void A()
	{
		System.out.println("From A");
	}
	
	B()
	{
		System.out.println("Coms");
		A();
	}
}

public class testPaxkage extends B{
	
	int i = -1;
	
	public static void main(String[] args)
	{
		B b = new testPaxkage();
		System.out.println(b.i);
		b.A();
	}
	
	public void A()
	{
		System.out.println("Derived Class");
	}
	

}
