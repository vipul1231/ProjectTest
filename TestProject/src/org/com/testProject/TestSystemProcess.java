package org.com.testProject;


public class TestSystemProcess {
	

	public void sayHello()
	{
		System.out.println("Hello World");
	}
	
	
	public static void main(String[] args)
	{
		TestSystemProcess obj = new TestSystemProcess();
		TestSingleton1 obj2 = new TestSingleton1(obj);
		obj2.sendMessage();
	}

}
