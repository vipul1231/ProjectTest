package test.ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;

public class Process {
    
    
    ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
        
    public void removeFromQueue() {
	Integer number;
	try {
	    number = queue.take();
	    System.out.println("Removing number: "+number);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    
    public void addToQueue(Integer number) {
	System.out.println("Adding to queue :"+number);
	queue.add(number);
    }
    
    
    public static void main(String[] args) {
	
	Process process  = new Process();
	
	Producer p1 = new Producer(process);
	Consumer c1 = new Consumer(process);
	
	Thread t1 = new Thread(p1);
	Thread t2 = new Thread(c1);
	
	t1.start();
	t2.start();
    }
}
