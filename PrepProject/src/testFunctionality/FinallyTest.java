package testFunctionality;

enum Singleton1
{
INSTANCE;
	
	private Singleton1()
	{
		System.out.println("Here");
	}
	
	
	public void testENUM()
	{
		System.out.println("From Test ENUM");
	}
	
	class testEnum
	{
		public void testThisEnum()
		{
			System.out.println("From test");
		}
	}
}

public class FinallyTest {
	
	
	
	public static void main(String[] args)
	{
	System.out.println(Singleton1.INSTANCE);
	
	Singleton1.testEnum obj = Singleton1.INSTANCE.new testEnum();
	
	Singleton1.INSTANCE.testENUM();
	
	FinallyTest obj1 = new FinallyTest();
	try {
		obj1.testFinallyFunction();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//obj.testThisEnum();
		
	}
	
	public void finalize()
	{
		System.out.println("Finalize called.");
	}
	
	private void testFinallyFunction() throws Exception
	{
		try{
			System.out.println("My name is vipul");
			throw new Exception();
		}
		catch(Exception e)
		{
			System.out.println("this is from exception");
			return;
			
		}
		finally
		{
			//System.exit(1);
			System.out.println("From Finally");
		}	
	}
}


class Student
{
	
}
