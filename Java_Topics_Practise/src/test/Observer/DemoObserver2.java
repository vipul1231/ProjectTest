package test.Observer;

public class DemoObserver2 extends Observer{

    public DemoObserver2(Subject subject) {
	// TODO Auto-generated constructor stub
	this.subject = subject;
	this.subject.attach(this);
    }

    @Override
    public void update() {
	// TODO Auto-generated method stub
	System.out.println("This is Demo Observer 2 with state: "+subject.getState());
    }
}
