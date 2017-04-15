package com.hackerrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MiniMax {
    
    public static void main(String[] args){
	/*Scanner in = new Scanner(System.in);
	List<Long> list = new ArrayList<>();
	
        long[] array = new long[5];   
        for(int i=0;i<5;i++){
            array[i] = in.nextLong();
        }
        
        for(int i=0;i<5;i++){
            long sum=0;
            for(int j=0;j<5;j++){
        	if(i==j){
        	continue;
        	}
            	else {
		sum +=array[j];
            	}
            }
            list.add(sum);
        }
        Collections.sort(list);
        
        System.out.println(list.get(0)+" "+list.get(list.size()-1));*/
        
        
        //
	Scanner scanner =new Scanner(System.in);
	String input = scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ssa");
        
        try {
            Date date = parseFormat.parse(input);
	    System.out.println(simpleDateFormat.format(date));
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
        scanner.close();
        
        
        
        //in.close();
    }
}
