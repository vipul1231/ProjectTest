package testFunctionality;

public class Deadlock {
	
	String str1 = "JAVA";
	String str2 = "UNIX";
	
	Thread th1 = new Thread()
	{
		public void run()
		{
			while(true)
			{
				synchronized(str1)
				{	
					synchronized (str2) {
					System.out.println("From thread 1: "+str1+str2);	
					}
				}
			}
		}
	};
	
	Thread th2 = new Thread()
	{
		public void run()
		{
			while(true)
			{
				synchronized(str1)
				{
					synchronized (str2) {
					System.out.println("From thread 2: "+str1+str2);	
					}
				}
			}
		}
	};
	
	public static void main(String[] args)
	{
		Deadlock d1 = new Deadlock();
		d1.th1.start();
		d1.th2.start();
	}

}
