package org.com.testProject;

class TestSingleton1 {
	
	private TestSystemProcess lTest;
	
	public void sendMessage()
	{
		lTest.sayHello();
	}
		
	public TestSingleton1(TestSystemProcess obj) {
		lTest = obj;
	}
}
