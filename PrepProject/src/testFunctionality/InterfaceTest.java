package testFunctionality;

interface testInterface
{
	public void testThisInterface();
	
	interface innerTestInterface
	{
		abstract void innerImplementation();
	}
	
	
	class classInsideTheInterface
	{
		public void testMethod()
		{
		System.out.println("This is test method");	
		}
	}
}

abstract class newInterfaceTest extends testInterface.classInsideTheInterface 
		implements testInterface, testInterface.innerTestInterface
{
	
}

public class InterfaceTest extends newInterfaceTest{

	public void testThisInterface() {
		// TODO Auto-generated method stub
		System.out.println("OuterInterface");
	
	}
	public void innerImplementation() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)
	{
		testInterface obj = new InterfaceTest();
		innerTestInterface obj1 = (innerTestInterface)obj;
		
		//Access to class defined2k
	    testInterface.classInsideTheInterface obj2 = new testInterface.classInsideTheInterface();
	    obj2.testMethod();
	}
    
}
