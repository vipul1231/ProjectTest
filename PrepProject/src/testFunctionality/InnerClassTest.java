package testFunctionality;

class TestClass
{
	private static String str = "Vipul"; 
	
	public class InnerNonStaticClass {
		
		public InnerNonStaticClass() {
		System.out.println("Inner Non static class constructor.");
		}
		
		public class innerClass
		{
			void testMethod1()
			{
				System.out.println("3: "+str);
			}
		}
		
		void newTestMehtod()
		{
			TestClass.this.testMethod();
		}
	}	
	
	public static class InnerStaticClass
	{	
		public InnerStaticClass() {
		System.out.println("Inner static class constructor."+str);
		}
		
		static void testStaticMethod()
		{
			System.out.println("Static class");
			testStaticOuterMethod();
		}
	}
	
	public void testMethod()
	{
		System.out.println("2: "+str);
	}
	
	public static void testStaticOuterMethod()
	{
		System.out.println("Static method from outer class");
	}
}


public class InnerClassTest extends TestClass
{
	
	public static void main(String[] args)
	{
    TestClass obj = new TestClass();
    
    // No need for having outer class reference.
    InnerStaticClass obj3 = new InnerStaticClass();
    obj3.testStaticMethod();
    
    // Non static class needs reference of outer class
	InnerNonStaticClass obj2 = obj.new InnerNonStaticClass();
	obj2.newTestMehtod();
	
	}	
}
