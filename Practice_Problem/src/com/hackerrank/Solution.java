package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	List<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] types = new int[n];
        for(int types_i=0; types_i < n; types_i++){
            types[types_i] = in.nextInt();
        }
        
        list.add(0, 0);
        // your code goes here
        for(int i=1;i<6;i++){
            list.add(i, 0);
        }
        
        for(int i=0;i<n;i++)
            {
            int birdType = types[i];
            int value = list.get(birdType);
            list.set(birdType, ++value);
            }
        
        //System.out.println(list);
       
        int max = 0;
        for(int i=0;i<list.size();i++){
           
           if(list.get(i) > max){
               max = list.get(i);
           }
        }
        
        //System.out.println(max);
        
        for(int i=0;i<list.size();i++){
            if(list.get(i)==max){
        	System.out.println(i);
        	break;
            }
        }
        
        in.close();
    }
}