package test.tryExample;


class Extender extends Thread{
    public Extender() {
	
    }
    
    public Extender(Runnable runnable) {
	super(runnable);
    }
    
    public void run() {
	System.out.println(Thread.currentThread().getName() +" Extender");
    }
}

class Implementor implements Runnable{

    public void run() {
	// TODO Auto-generated method stub
	System.out.println();
	System.out.print(Thread.currentThread().getName()+" Implementor");
	
    }
}

public class Try extends Implementor{
    
    public void m1() throws Exception{
	
	try {
	    m2();
	}
	
	finally {
	    m3();
	}
	
	
    }
    
    public void m2() throws RuntimeException {
	throw new RuntimeException();
    }
    
    public void m3() throws Exception {
	throw new Exception();
    }
    
    public static void main(String[] args) {
	new Extender(new Implementor()).start();
	new Extender().start();
	new Thread(new Implementor()).start();
    }

}
