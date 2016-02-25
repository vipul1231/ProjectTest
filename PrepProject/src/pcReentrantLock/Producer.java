package pcReentrantLock;

public class Producer {
	
	public Producer() {
	}
	
	public Queuehandler produceObject() 
	{
		return new Queuehandler();
	}
}
