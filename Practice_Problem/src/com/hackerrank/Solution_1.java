package com.hackerrank;

import java.util.Scanner;

/**
 * Find Absolute zero
 * 
 * @author Vipul_Anky
 *
 */
public class Solution_1 {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	 Scanner in = new Scanner(System.in);
	 int n = in.nextInt();
	 int[] a = new int[n];
	 for(int a_i=0; a_i < n; a_i++){
	 a[a_i] = in.nextInt();
	 }
	 
	 /*if(n > 2)
	 {
	     for(int i=0;i<a.length-1;i++){
		     
		     for(int j=i+1;j<a.length;j++){
			 
			 int value = a[i]-a[j];
			 int absolute  = Math.abs(value);
			 if(absolute > 0)
			 list.add(Math.abs(absolute));
		     }
		 }
		 
		 Set<Integer> set = new TreeSet<>();
		 set.addAll(list);
		 System.out.println(set.iterator().next());    
	 }*/
	
	 
	 
	 in.close();
    }

}
