package testFunctionality;

class Mythread extends Thread
{
	public void testMethod()
	{
	System.out.println("Parent class.");	
	}
	
	public void run()
	{
		System.out.println("This is my thread");
	}
}

public class NumberTest extends Mythread{
	
	@Override
	public void testMethod()
	{
		System.out.println("Base class.");
	}
	
	public static void main(String[] args)
	{
		
		 	String obj="4.5";
		 	
		 	if(obj.matches("-?\\d+(\\.\\d+)?"))
		 	{
		 		System.out.println("Number");
		 	}
		 	
		 	else
		 	{
		 		System.out.println("Not a Number");
		 	}
		 	
		 	Integer obj3 = Integer.getInteger(obj);
		 	
		 	System.out.println("Number: "+obj3);
		 	
		 	String text = "ddd123.0114cc";
		    String numOnly = text.replaceAll("\\p{Alpha}","");
		    try {
		        double numVal = Double.parseDouble(null);
		        System.out.println(text +" contains numbers");
		    } catch (NumberFormatException e){
		        System.out.println(text+" not contains numbers");
		    } 
		
		
		Mythread obj1 = new NumberTest();
		obj1.testMethod();
		
		Thread th1 = new Thread(obj);
		th1.run();
		th1.start();
	}
}
