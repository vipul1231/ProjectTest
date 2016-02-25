package org.com.testProject;

class A{
	
	int foo()
	{
		return 1123;
	}

}


public class testPolymorphism extends A {

	@Override
	public int foo()
	{
		System.out.println(super.foo());
		return 1122;
	}
	
	public static void main(String[] args)
	{
		A a = new testPolymorphism();
		System.out.println(a.foo());
		String str="vipul";
	}
	
}
