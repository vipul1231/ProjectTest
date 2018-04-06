package test.MultiThreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Process {
    
    BlockingQueue<Object> blockingQueue = null;
    
    int queueSize = 100;
    
    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    private void initializeBlockingQueue(Process process) {
	blockingQueue = new ArrayBlockingQueue<Object>(queueSize);
	setQueueSize(100);
	
	Producer producer = new Producer(process);
	Consumer consumer = new Consumer(process);
	
	Thread pThread = new Thread(producer);
	Thread cThread = new Thread(consumer);
	pThread.start();
	cThread.start();
    }
    
    protected void removeObjectFromQueue() {

	try {
	    if (!blockingQueue.isEmpty()) {
		System.out.println("removing from queue.");
		blockingQueue.poll();
	    } else {
		System.out.println("Queue is empty. Putting consumer on wait.");
		notify();
		this.wait();
		System.out.println("Consumer out from wait.");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    protected void addObjectToQueue(Object object) {
	try {
	    if (blockingQueue.size() != queueSize) {
		System.out.println("Adding object in queue.");
		blockingQueue.put(object);
	    } else {
		System.out.println("Queue reached maximum size :"+blockingQueue.size());
		notify();
		this.wait();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    public static void main(String[] args){
	Process process = new Process();
	process.initializeBlockingQueue(process);
    }
    
}
