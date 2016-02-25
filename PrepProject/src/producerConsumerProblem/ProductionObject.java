package producerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;

public class ProductionObject {
	
	private static final int MAX_QUEUE_SIZE = 100; 

	static int numberOfObjects=0;
	
	private Queue<ProductionObject> queue = new LinkedList<>();
	
	private boolean emptyQueueFlag = false;
	
	public synchronized void addQueue(ProductionObject object)
	{
		if(queue.size()==MAX_QUEUE_SIZE)
		{
			System.out.println("Max Queue size reached. Putting Thread "+Thread.currentThread().getName()+" to wait!!.");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Object added to the queue. No: "+numberOfObjects);
		if(emptyQueueFlag == true)
		{
			this.notify();
			emptyQueueFlag = false;
		}
		queue.add(object);
		numberOfObjects++;
	}
	
	public synchronized ProductionObject removeFromQueue()
	{
		System.out.println("Object is removed from queue. Current Thread: "+Thread.currentThread().getName());
		
		if(queue.size()<MAX_QUEUE_SIZE)
		{
			this.notify();
		}
		
		if(queue.isEmpty())
		{
			try {
				System.out.println("Queue is empty. Putting this Consumer thread on wait.");
				emptyQueueFlag = true;
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else
		{
		 numberOfObjects--;
		 return queue.poll();
		}
		
		return null;
	}
}
