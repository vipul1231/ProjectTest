package testPackage;

enum Singleton
{
	INSTANCE;
	
	private Singleton()
	{
		System.out.println("Singleton");
	}
	
	public static Singleton getInstance()
	{
		return INSTANCE;
	}
}


public class EnumSingleton {
	
	public static void main(String[] args)
	{
	System.out.println(Singleton.getInstance().hashCode());
	System.out.println(Singleton.getInstance());
	System.out.println(Singleton.INSTANCE);
	
	}
}
