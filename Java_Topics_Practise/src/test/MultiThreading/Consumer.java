package test.MultiThreading;

public class Consumer implements Runnable{
    
    Process process = null;
    
    public Consumer(Process process) {
	// TODO Auto-generated constructor stub
	this.process = process;
    }

    public void run() {
	// TODO Auto-generated method stub
	synchronized (process)
	{
	    System.out.println("Inside Consumer.");
	    while(true){
		process.removeObjectFromQueue();
	    }
	}
    }

}
