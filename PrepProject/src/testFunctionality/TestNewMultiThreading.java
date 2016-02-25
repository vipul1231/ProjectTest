package testFunctionality;

public class TestNewMultiThreading extends Thread{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Manish";
		String str1 = "ManishKumar";
		
		System.out.println(str1.compareTo(str));
		
		(new TestNewMultiThreading()).start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Start");
		yield();
		System.out.println("End");
		
	}

}
