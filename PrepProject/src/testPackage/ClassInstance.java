package testPackage;

class demo
{
	demo()
	{
		
	}
}

class demoFactory
{
	int instanceCount = 0;
	
	public int getInstanceCount() {
		return instanceCount;
	}

	public demo getInstance()
	{
		instanceCount++;
		return new demo();
	}
}

public class ClassInstance {
	
	public static void main(String[] args)
	{
	demoFactory obj = new demoFactory();
	obj.getInstance();
	obj.getInstance();
	obj.getInstance();
	obj.getInstance();
	System.out.println(obj.getInstanceCount());
	}
}
