package pcReentrantLock;

import java.util.LinkedList;
import java.util.Queue;

public class Queuehandler {
	
	private static final int MAX_QUEUE_SIZE = 100;
	
	Queue<Queuehandler> queue = new LinkedList<>();
	
	
	public void insertIntoQueue(Queuehandler obj)
	{
		if(queue.size()!=MAX_QUEUE_SIZE)
		{
			queue.add(obj);	
		}
	}
	
	
	public void removeFromQueue()
	{
		if(queue.size()!=0)
		{
			queue.poll();	
		}
	}

}
