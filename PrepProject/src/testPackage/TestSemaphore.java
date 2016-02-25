package testPackage;

import java.util.concurrent.Semaphore;

public class TestSemaphore implements Runnable{
	
	public void testMethod()
	{
		
	}
	
	
	Semaphore semaphore = new Semaphore(2);
	
	public static void main(String[] args)
	{
		TestSemaphore obj = new TestSemaphore();
		Thread th1 = new Thread(obj);
		Thread th2 = new Thread(obj);
		Thread th3 = new Thread(obj);
		
		th1.setName("Thread 1");
		th2.setName("Thread 2");
		th3.setName("Thread 3");
		th1.start();
		th2.start();
		th3.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			semaphore.acquire();
			
			System.out.println("Lock acquired by Thread: "+Thread.currentThread().getName());
			
			Thread.sleep(3000);
			
			semaphore.release();
			
			System.out.println("Lock release by Thread"+Thread.currentThread().getName());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
