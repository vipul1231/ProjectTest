package test.MultiThreading;

public class StaticThreading implements Runnable{
    
    private static void test(){
	
	synchronized (StaticThreading.class) {
	    try {
		System.out.println("Lock Acquired.");
		Thread.sleep(5000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }
    
    private void test1(){
	synchronized (this) {
	    System.out.println("Lock on non static class");
	    try {
		Thread.sleep(5000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }
    
    public static void main(String[] args){
	StaticThreading obj = new StaticThreading();
	StaticThreading obj1 = new StaticThreading();
	//Same instance
	Thread th1 = new Thread(obj);
	Thread th2 = new Thread(obj);
	th1.start();
	th2.start();
	
	Thread th3 = new Thread(obj);
	Thread th4 = new Thread(obj1);
	th3.start();
	th4.start();
    }

    public void run() {
	// TODO Auto-generated method stub
	//test();
	this.test1();
    }

}
