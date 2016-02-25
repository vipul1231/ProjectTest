package testPackage;

class B implements Runnable 
{
	
	public void testMethod1()
	{
		sleepThread();
		System.out.println("Method 1");
	}
	
	public synchronized void testMethod2()
	{
		sleepThread();
		System.out.println("Method 2");
	}
	
	public synchronized void testMethod3()
	{
		sleepThread();
		System.out.println("Method 3");
	}
	
	public static synchronized void testMethod4()
	{
		sleepStaticThread();
		System.out.println("Method 4");
	}
	
	public static synchronized void testMethod5()
	{
		sleepStaticThread();
		System.out.println("Method 5");
	}
	
	public void sleepThread()
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sleepStaticThread()
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		if(Thread.currentThread().getName().equals("1"))
		{
			testMethod1();
		}
		if(Thread.currentThread().getName().equals("2"))
		{
			testMethod2();
		}
		if(Thread.currentThread().getName().equals("3"))
		{
			testMethod3();
		}
		if(Thread.currentThread().getName().equals("4"))
		{
			testMethod4();
		}
		if(Thread.currentThread().getName().equals("5"))
		{
			testMethod5();
		}
	}
	
}

public class TestPackage {
	public static void main(String[] args)
	{
		B obj = new B();
		Thread th1 = new Thread(obj);
		Thread th2 = new Thread(obj);
		Thread th3 = new Thread(obj);
		Thread th4 = new Thread(obj);
		Thread th5 = new Thread(obj);
		th1.setName("1");
		th2.setName("2");
		th3.setName("3");
		th4.setName("4");
		th5.setName("5");
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		
	}
}
