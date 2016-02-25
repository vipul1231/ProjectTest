package tcpServer;

import java.util.HashSet;
import java.util.Set;

public class Threading implements Runnable{

	Set<String> str = new HashSet<String>();
	Set<Integer> str1 = new HashSet<Integer>();
	@Override
	public void run() {
		// TODO Auto-generated method stub
	System.out.println("From Run Statement");	
	}
	
	public static void main(String[] args)
	{
		Threading obj = new Threading();
		
		obj.test();
	}
	
	private void test()
	{
		Thread th1 = new Thread(this);
		th1.start();
		str.add("hello");
		str1.add(1);
		String[] array = new String[100];	
		str.toArray(array);
		Object[] obj = str.toArray();
		Object[] obj1 = str1.toArray();
		
		String[] b = str.toArray(new String[obj.length]);
		Integer[] b1 = str1.toArray(new Integer[obj1.length]);
		for(int i=0;i<b.length;i++)
		{
			System.out.println(b[i]);
		}
		for(int i=0;i<b1.length;i++)
		{
			System.out.println(b1[i]);
		}
	}
}
