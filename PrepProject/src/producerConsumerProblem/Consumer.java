package producerConsumerProblem;

public class Consumer implements Runnable{
	
	private ProductionObject prodObject = null;
	
	public Consumer(ProductionObject obj) {
		this.prodObject = obj;
	}
	
	@Override
	public void run() {
		
		while(true)
		{
		    synchronized (prodObject) {
				prodObject.removeFromQueue();
				System.out.println("Object removed: "+ProductionObject.numberOfObjects);
			}
		}
	}
}
