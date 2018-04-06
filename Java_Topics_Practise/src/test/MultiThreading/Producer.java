package test.MultiThreading;

public class Producer implements Runnable {
    
    Process process = null;

    public Producer(Process process) {
	this.process = process;
    }
    
    public void produce(){
	process.addObjectToQueue(new Object());
    }

    public void run() {
	// TODO Auto-generated method stub
	synchronized (process) {
	    System.out.println("Inside Producer.");
	    while(true){
		produce();
	    }
	}
    }
}
