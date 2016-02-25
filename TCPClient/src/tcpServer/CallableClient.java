package tcpServer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableClient {
	
	public static void main(String[] args)
	{
		
		Callable<Double> callable = new CallabeExample();
		
		ExecutorService exec = Executors.newFixedThreadPool(1);
		Future<Double> future = exec.submit(callable);
		
		try {
			System.out.println("result");
			Double result = future.get(4000,TimeUnit.SECONDS);
			System.out.println(result);
		} catch (InterruptedException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
