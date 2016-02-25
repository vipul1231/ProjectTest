package testPackage;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	
	private final ReentrantLock lock = new ReentrantLock();
	
	final Condition accessrequest = lock.newCondition();
	
	
	private void testTryLock()
	{
		try
		{
			lock.lock();
			System.out.println("Locked by thread"+Thread.currentThread().getName()+" Lock status: ");
	    	System.out.println("Thread: "+Thread.currentThread().getName());
	    	
	    	try {
	    		if(Thread.currentThread().getName().equals("Thread 1"))
	    		{
	    			System.out.println("Thread 1 is going on sleep.");
	    			accessrequest.await();	
	    		}
				Thread.sleep(2000);
				System.out.println("Completing request");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	
	    	/*try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	    
	    finally
	    {
	    	System.out.println("Unlocking thread: "+Thread.currentThread().getName());
	    	if(Thread.currentThread().getName().equals("Thread 2"))
	    	{
	    		accessrequest.signal();
	    	}
	    	lock.unlock();
	    }
	}
	
	public static void main(String[] args)
	{
		final ReentrantLockTest obj = new ReentrantLockTest();
		
		Thread th1 = new Thread()
				{
					public void run()
					{
					obj.testTryLock();
					}
				};
				
		Thread th2 = new Thread()
				{
					public void run()
					{
						obj.testTryLock();
					}
				};		
				th1.setName("Thread 1");
				th2.setName("Thread 2");
				th1.start();
				th2.start();
	}

}
