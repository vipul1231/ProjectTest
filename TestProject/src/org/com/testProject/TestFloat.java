package org.com.testProject;

public class TestFloat {

	public static void main(String[] args)
	{
		float f = 3.1f;
		double l;
		long lon;
		
		System.out.println("Float Value :" + f);
		l = (double) f;
		f = (float) l;
		lon = (long) l;
		System.out.println("Double value :" + l);
		System.out.println("Type cast long to float Value :" + f);
		System.out.println("Typecast double to float Value :" + lon);
	}
	
}
