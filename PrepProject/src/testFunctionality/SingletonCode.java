package testFunctionality;

class Singleton implements Cloneable{
	
	private static volatile Singleton instance = null;
	
	private Singleton()
	{
		
	}
	
	public static Singleton getInstance()
	{
		if(instance == null)
		{
			synchronized(Singleton.class)	
			{
				if(instance == null)
				{
					instance = new Singleton();	
				}
			}	
		}
		return instance;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException 
	{
		throw new CloneNotSupportedException(this.getClass().getName()+" is Singleton");
	}
}


public class SingletonCode{
	
	public static void main(String[] args)
	{
		try {
			System.out.println("First Instance: "+Singleton.getInstance().clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Second Instance: "+Singleton.getInstance());
	}
}