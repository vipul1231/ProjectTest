package testFunctionality;

public class DeadLockExample2 {
	
	public static Object obj1 = new Object();
	public static Object obj2 = new Object();
	
	
	public static void main(String[] args)
	{
		  ThreadDemo1 T1 = new ThreadDemo1();
	      ThreadDemo2 T2 = new ThreadDemo2();
	      T1.start();
	      T2.start();
	}
	
	public static class ThreadDemo1 extends Thread
	{
		public void run()
		{
			synchronized (obj1) {
				System.out.println("Thread 1: Holding lock 1.");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 2: Going to hold lock on obj2");
				synchronized (obj2) {
					System.out.println("Holding Lock 1 and 2.");
				}
				
			}
		}
	}
	
	public static class ThreadDemo2 extends Thread
	{
		public void run()
		{
			synchronized (obj2) {
				System.out.println("Thread 2: Holding lock 2.");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 2: Going to hold lock on obj1");
				synchronized (obj1) {
					System.out.println("Holding lock 1 and 2.");
				}
			}
			
		}
	}
}
