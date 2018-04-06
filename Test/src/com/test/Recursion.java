package com.test;

public class Recursion {
	
	
	public int triangularNumberR(int num) {
		
		System.out.println("Method :"+num);
		
		if(num == 1) {
			System.out.println("1 is returned");
			return 1;
		}
		
		else {
			int result = num +triangularNumberR(num -1);
			System.out.println("Result = "+result+" : "+num+" + triangularNumberR("+num+"-1)");
			return result;
		}
	}
	
	
	
	public static void main(String[] args) {
		
		Recursion recursion = new Recursion();
		System.out.println("Output: "+recursion.triangularNumberR(6));
		
	}

}
