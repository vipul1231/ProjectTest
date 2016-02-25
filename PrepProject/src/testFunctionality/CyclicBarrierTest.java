package testFunctionality;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest implements Runnable{
	
	CyclicBarrier cyclicBarrier = null;
	
	public CyclicBarrierTest(CyclicBarrier aInCyclicBarrier)
	{
		cyclicBarrier = aInCyclicBarrier;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Starting service one.....");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Service one wait is finished.....waiting for other to finish....");
		
		try {
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
		}
		System.out.println("Service one is finished successfully.");
	}
}
