package test.ProducerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutors implements Runnable{
    
    public void run() {
	// TODO Auto-generated method stub
	System.out.println("From Run method");
    }


    static ExecutorService executorService = Executors.newCachedThreadPool();
    
    
    
    
    public static void main(String[] args) {
	
	
	TestExecutors tst1 = new TestExecutors();
	
	executorService.submit(tst1);
	
	executorService.shutdown();
	
    }
}
