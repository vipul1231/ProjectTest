package com.test;


public class ReverseString {
	

	void printReverse( int index){
		
		for(int i=1;i<= index;i++){
			System.out.println("i: "+i+" Index :"+index);
			
			printReverse(index-1);
		}
	}
	
	public static void main(String[] args){
		ReverseString reverseString = new ReverseString();
		reverseString.printReverse(3);
		
	}
}
