package com.hackerrank;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Plus_Minus {
    
    public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	
	Double postive = 0d, negative =0d, zero = 0d;
	
	Double total = Double.parseDouble(scanner.nextLine());
	if(total!=0){
	    int count =0;
	    String[] input = scanner.nextLine().split(" ");
	    while(true){
		    if(input[count].contains("-")){
			negative++;
		    }
		    else if(Integer.parseInt(input[count])==0){
			zero++;
		    }
		    else{
			postive++;
		    }
		    
		    if((total-1) == count){
			break;
		    }
		    count++;
		}
		
		DecimalFormat decimalFormat = new DecimalFormat("#.######");
		decimalFormat.setRoundingMode(RoundingMode.CEILING);
		System.out.println(decimalFormat.format(postive/total));
		System.out.println(decimalFormat.format(negative/total));
		System.out.println(decimalFormat.format(zero/total));
    
	}
		
	scanner.close();
    }

}
