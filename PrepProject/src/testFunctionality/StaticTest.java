package testFunctionality;


class throwException extends Exception
{
	throwException()
	{
		super();
	}
	
	public void throwMethod() throws Exception
	{
		throw new Exception();
	}
}

public class StaticTest {
	
	private static int a=0;
	
	
	private void run()
	{
		System.out.println("Count: "+ a);
	}
	
	public static void main(String[] args)
	{
		StaticTest obj = new StaticTest();
		obj.run();	
		
		throwException obj1 = new throwException();
		
		try {
			try {
				obj1.throwMethod();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		finally
		{
			try {
				obj1.throwMethod();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
