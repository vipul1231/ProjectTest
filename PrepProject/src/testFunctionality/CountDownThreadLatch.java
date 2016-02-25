package testFunctionality;

import java.util.concurrent.CountDownLatch;

public class CountDownThreadLatch implements Runnable{

	private CountDownLatch latch;
	
	public CountDownThreadLatch(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		System.out.println("Started.");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		latch.countDown();
		
		System.out.println("Run method completed.");
	}

}
