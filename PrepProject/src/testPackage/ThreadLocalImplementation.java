package testPackage;

public class ThreadLocalImplementation implements Runnable{
	
	private ThreadLocal<Integer> formater = new ThreadLocal<>();
		 
	
	public static void main(String[] args)
	{
		ThreadLocalImplementation obj = new ThreadLocalImplementation();
		Thread th1 = new Thread(obj);
		Thread th2 = new Thread(obj);
		th1.start();
		th2.start();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		formater.set( (int) (Math.random()*100D));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(formater.get());
	}

}
