package testFunctionality;

public class WaitAndNotifyHandle implements Runnable{
	
	private final Object obj = new Object();
	
	private boolean wasSignalled = false;
	
	public void doWait()
	{
		synchronized (obj) {
			
			if(Thread.currentThread().getName().equals("Thread 1"))
			{
				System.out.println("This is Thread going on wait");
				while(!wasSignalled)
				{
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Thread "+Thread.currentThread().getName()+" came out of wait.");
				}	
			}
			else
			{
				System.out.println("This is Thread 2 going for small sleep");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public void doNotify()
	{
		synchronized (obj) {
			System.out.println("Notified by: "+Thread.currentThread().getName());
			wasSignalled = true;
			obj.notify();
		}
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello my thread name is: "+Thread.currentThread().getName());
		doWait();
		doNotify();
	}
	
	
	public static void main(String[] args)
	{
	 WaitAndNotifyHandle obj1 = new WaitAndNotifyHandle();
	 
	 Thread th1 = new Thread(obj1);
	 th1.setName("Thread 1");
	 Thread th2 = new Thread(obj1);
	 th2.setName("Thread 2");
	 
	 th1.start();
	 th2.start();
	}
}
