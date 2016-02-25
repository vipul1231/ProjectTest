package testFunctionality;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainCyclicBarrierTest {
	
	public static void main(String[] args)
	{
		CyclicBarrier barrier =  new CyclicBarrier(3);
		
		Thread serviceThread1 = new Thread(new CyclicBarrierTest(barrier));
		Thread serviceThread2 = new Thread(new CyclicBarrierTest2(barrier));
		
		System.out.println("Starting both the service: "+new Date());
		
		serviceThread1.start();
		serviceThread2.start();
		
		try {
			
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		barrier.reset();
		System.out.println("End of cyclic barrier.");
	}

}
