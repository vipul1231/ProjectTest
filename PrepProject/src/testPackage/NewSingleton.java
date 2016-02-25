package testPackage;

class TestSingleton
{
	private TestSingleton()
	{
		System.out.println("Test Singleton");
	}
	
	public static TestSingleton getInstance()
	{
		return SingletonHolder.instance;
	}
	
	
	static class SingletonHolder
	{
		public SingletonHolder() {
			System.out.println("Constructor is getting called.");
		}
	public static final TestSingleton instance = new TestSingleton();
	}
}

public class NewSingleton {
	
	public static void main(String[] args)
	{
	System.out.println(TestSingleton.getInstance());
	System.out.println(TestSingleton.getInstance());
	}
}
