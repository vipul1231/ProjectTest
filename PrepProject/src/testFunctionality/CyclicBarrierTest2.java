package testFunctionality;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 implements Runnable{
	
	CyclicBarrier cyclicBarrier = null;
	
	public CyclicBarrierTest2(CyclicBarrier aInCyclicBarrier)
	{
		cyclicBarrier = aInCyclicBarrier;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
      System.out.println("Starting service two.....");
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Service two wait is finished.....waiting for other to finish....");
		
		try {
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Service two is finished successfully.");
	}

}
