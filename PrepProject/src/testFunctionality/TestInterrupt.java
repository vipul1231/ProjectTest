package testFunctionality;

public class TestInterrupt implements Runnable{

	public static void main(String[] args)
	{
		TestInterrupt obj = new TestInterrupt();
		
		Thread th1 = new Thread(obj);
		th1.start();
		th1.interrupt();
		System.out.println("Thread status: "+Thread.interrupted());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("From Run method");
		try{
			Thread.currentThread().interrupt();
			System.out.println(":"+Thread.interrupted());	
		}
		catch(Exception e)
		{
			System.out.println(Thread.interrupted());
		}
	}

}
