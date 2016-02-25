package testFunctionality;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	
	public static void main(String[] args)
	{
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService lexecutorService = Executors.newFixedThreadPool(3);
		
		for(int i=0;i<3;i++)
		{
			lexecutorService.submit(new CountDownThreadLatch(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lexecutorService.shutdown();
		System.out.println("Process Completed.");
	}

}
