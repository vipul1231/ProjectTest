package testFunctionality;

class A
{	
	A()
	{
		
	}
	
	void processRequest() {
		// TODO Auto-generated method stub
		System.out.println("Process Request in B");
	}
}


class B extends A
{
	B()
	{
		
	}
	
	void processRequest() {
		// TODO Auto-generated method stub
		System.out.println("Process Request in B");
	}
	
	void getManager()
	{
		System.out.println("Get Manager from B");
	}
}

class D extends B
{
	
	
	D()
	{
		
	}
}


public class InheritanceTest {
	
	public static void main(String[] args) throws Exception
	{
     InheritanceTest tst1 = new InheritanceTest();
     tst1.testPloymorphism();
	}
	
	void testPloymorphism()
	{
		D d = new D();
		d.processRequest();
		
	}
}
