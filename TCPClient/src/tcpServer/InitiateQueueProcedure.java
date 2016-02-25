package tcpServer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class InitiateQueueProcedure {
	
	static ExecutorService et = null;
	
	public static void main(String[] args)
	{
		InitiateQueueProcedure obj = new InitiateQueueProcedure();
		obj.startThreads();
	}
	
	private void startThreads()
	{		
		TestConnectionWithPersistance testConnectionPersistance = new TestConnectionWithPersistance("127.0.0.1",8085);
		SendMessage sendMessage = new SendMessage(testConnectionPersistance);
		Thread t1 = new Thread(testConnectionPersistance);
		Thread t2 = new Thread(sendMessage);
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		t2.start();		
		try {
			
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
