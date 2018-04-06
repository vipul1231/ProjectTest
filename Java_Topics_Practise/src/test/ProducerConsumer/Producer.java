package test.ProducerConsumer;

import java.util.Random;

public class Producer implements Runnable{
    
    Process process = null;
    
    public Producer(Process process) {
	// TODO Auto-generated constructor stub
	this.process = process;
    }

    public void run() {
	// TODO Auto-generated method stub
	Random random = new Random();
	/*while(true) {*/
	
	for(int i=0;i<10;i++) {
	    process.addToQueue(random.nextInt(100));
	}
	        
	/*}*/
    }
}
