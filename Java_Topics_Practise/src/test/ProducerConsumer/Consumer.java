package test.ProducerConsumer;

public class Consumer implements Runnable{
    
    Process process  = null;
    
    public Consumer(Process process) {
	// TODO Auto-generated constructor stub
	this.process = process;
    }

    public void run() {
	
	/*while(true) {*/
	
	for(int i=0;i<10;i++) {
	    process.removeFromQueue();
	}
	    
	/*}*/
	
    }
}
