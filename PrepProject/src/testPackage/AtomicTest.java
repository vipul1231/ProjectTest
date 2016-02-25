package testPackage;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
	
	static AtomicInteger integer;
	
	int i[] = {0};
	
	public static void main(String[] args)
	{
		int i[] = {1};
		i = change(i);
		System.out.println(i[0]);
		
		String  s ="Dolly";
		String t = s.concat("Hello");
		System.out.println(t); 
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer("Amit");
		String ss1 ="Amit";
		System.out.println(sb1.equals(sb2));
		System.out.println(sb1.equals(ss1));
		System.out.println("Podder".substring(3));
	}

	
	public static int[] change(int[] a)
	{
		int k[] = {2};
		a = k;
		return k;
	}
}
