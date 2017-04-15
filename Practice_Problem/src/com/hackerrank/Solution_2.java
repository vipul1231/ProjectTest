package com.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution_2 {
    
    static Map<Integer,String> map = new HashMap<>();
    
    public static void main(String[] args){
	map.put(1, "h");
	map.put(2, "a");
	map.put(3, "c");
	map.put(4, "k");
	map.put(5, "e");
	map.put(6, "r");
	map.put(7, "r");
	map.put(8, "a");
	map.put(9, "n");
	map.put(10, "k");
	
	List<String> list = new ArrayList<>();
	Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            // your code goes here
            list.add(s);
        }
        
        for(int i=0;i<q;i++){
            String s = list.get(i);
            String[] string = s.split("");
            int count = 1;
            for(String s1 : string){
        	String value = map.get(count);
        	
        	if(s1.equals(value)){
        	    count++;
        	}
            }
            
            if(count ==11){
        	System.out.println("Yes");
            }
            else {
		System.out.println("No");
	    }
        }
        
        in.close();
    }
}
