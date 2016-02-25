package producerConsumerProblem;

public class Producer implements Runnable{
	
	ProductionObject prodObject = null;
		
	public Producer(ProductionObject obj) {
	this.prodObject = obj;
	}
	
	@Override
	public void run() {
		
		while(true)
		{
			synchronized (prodObject) {
				prodObject.addQueue(produceObject());	
			}
			
		}
	}
	
	private ProductionObject produceObject()
	{
		return new ProductionObject();
	}
	
	public static void main(String[] args)
	{
    ProductionObject object = new ProductionObject();
	Consumer cons = new Consumer(object);
	Producer prod = new Producer(object);
	Thread th1 = new Thread(prod,"Producer Thread");
	Thread th2 = new Thread(cons,"Consumer Thread");
	System.out.println("Starting Threads: ");
	th1.start();
	th2.start();
	}
}
