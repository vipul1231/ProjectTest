package testFunctionality;


class MyTread extends Thread
{
	public void run()
	{
		System.out.println("Running thread from MyThread");
	}
}

public class SplitTest extends Thread{
	
	public void start()
	{
		System.out.println("From start");
	}
	
	public void run()
	{
		System.out.println("From Run");
	}
	
	public static void main(String[] args)
	{
		SplitTest obj1 = new SplitTest();
		SplitTest obj2 = new SplitTest();
		
		obj1.run();
		obj2.run();
		
		/**
		 * New Program 
		 */
		
		Thread t = new MyTread();
		t.run();
		t.start();
	}
}
