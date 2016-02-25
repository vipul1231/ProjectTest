package tcpServer;

import java.util.Arrays;

public class TestInterviewQuestion {
	
	private int var= -1;
	
	public static void main(String[] args) { 
		System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
		
		System.out.println(1.0/0.0);
		System.out.println(Double.POSITIVE_INFINITY==0);
		
		char[] chars = new char[] {'\u0097'}; String str = new String(chars); byte[] bytes = str.getBytes(); System.out.println(Arrays.toString(bytes));

		
	
	}

}
