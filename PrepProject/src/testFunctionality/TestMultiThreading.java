package testFunctionality;

public class TestMultiThreading implements Runnable{
	
    static Thread th1, th2;
    
    final static Object obj = new Object();
    
    final static Object obj1 = new Object();
	
	int counter=0;

	public void run() {
			System.out.println("Inside Run method for thread: "+Thread.currentThread());
			testThreading();
			testThreading1();
			//testMultiThreading();
			System.out.println("End of method thread: "+Thread.currentThread());	
		
	}
	
	private  void testThreading()
	{
		System.out.println("Inside testThreading method: "+Thread.currentThread());
		
		if(Thread.currentThread().getName().equals("Thread 1"))
		{
			synchronized (this) {
				try {
					System.out.println("Going for sleep");
					Thread.sleep(5000);
					System.out.println("Coming out if sleep");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}	
		}
	}
	
	private void testThreading1()
	{
		System.out.println("Inside testThreading1 method: "+Thread.currentThread());
		
		if(Thread.currentThread().getName().equals("Thread 2"))
		{
			synchronized (this) {
				try {
					System.out.println("Going for sleep");
					Thread.sleep(5000);
					System.out.println("Coming out if sleep");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}	
		}
	}
	
	private void testMultiThreading()
	{
		System.out.println("Inside testMultiThreading non static method: "+Thread.currentThread());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(Thread.currentThread().getName().equals("Thread 1"))
		{
			synchronized (th1) {
				try {
					Thread.currentThread().wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
			
		if(Thread.currentThread().getName().equals("Thread 2"))
		{
			synchronized (this) {
	     		Thread.currentThread().notify();	
				}	
		}
	}
	
	@SuppressWarnings("unused")
	private void testMultiThreading1()
	{
		System.out.println("Inside testMultiThreading1 non static method: "+Thread.currentThread());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		TestMultiThreading obj  = new TestMultiThreading();
		
		th1 = new Thread(obj);
		th1.setName("Thread 1");
		th1.setPriority(Thread.NORM_PRIORITY);
		th2 = new Thread(obj);
		th2.setName("Thread 2");
		th2.setPriority(Thread.NORM_PRIORITY);
		th2.start();
		th1.start();
	}
}
