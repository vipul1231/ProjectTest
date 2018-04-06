package com.test;

import java.text.DecimalFormat;

public class FlipKartTest {

	
	public static void main(String[] args)
	{
		 double d = 0.567;
	     DecimalFormat f = new DecimalFormat("##.00");
	     System.out.println(f.format(d));
	     
	     String number = f.format(d);
	     System.out.println(Double.parseDouble(number));
	}

}
