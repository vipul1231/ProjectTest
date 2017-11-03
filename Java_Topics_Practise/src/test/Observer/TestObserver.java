package test.Observer;

public class TestObserver {
    
    public static void main(String[] args) {
	Subject subject = new Subject();
	
	new DemoObserver1(subject);
	new DemoObserver2(subject);
	
	System.out.println("Setting state:");
	
	subject.setState(10);
	
	System.out.println("Setting state:");
	subject.setState(15);
    }

}
