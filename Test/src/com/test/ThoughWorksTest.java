package com.test;

import java.util.Scanner;

public class ThoughWorksTest {
	
	
	public static void main(String[] args){
		
		Scanner sxScanner = new Scanner(System.in);
		
		String[] inputs = sxScanner.nextLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int q = Integer.parseInt(inputs[1]);
	
		String a = sxScanner.nextLine();
		String b = sxScanner.nextLine();
		
		//Double number  = obj.convertStringToNumber(a);
	
		for(int i=0;i<q;i++){
			int index = Integer.parseInt(sxScanner.nextLine()) -1;
			
			String result = null;
			if(index == 0){
				result = "1"+b.substring(index+1,n);	
			}
			else if(index == n){
				result = b.substring(0,index -1)+"1";
			}
			else {
				result = b.substring(0, index)+"1"+b.substring(index+1,n);
			}
			
			if(result.compareTo(a) >= 0){
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			
			b=result;
		}
		
		sxScanner.close();
	}
}
