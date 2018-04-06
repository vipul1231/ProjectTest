package com.hackerrank.Implementation;

import java.util.Scanner;

public class Breaking_Record {
    
    static int[] getRecord(int[] s){
        // Complete this function
	int count = s[0];
        int maxCount =0, minCount=0, maxScore=count,minScore=count;
        for(int i=1;i<s.length;i++){
            if(s[i] > s[i-1]) {
        	//TODO: change
        	if(s[i]>maxScore){
        	maxScore = s[i];
            	maxCount++;    
        	}
            }
            else if(s[i] < s[i-1]){
        	//TODO: change
        	if(s[i] < minScore){
        	    minScore = s[i];
        	    minCount++;
        	}
            }
        }
        
        int[] array = {maxCount,minCount};
        
        return array;
        
    }
    
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
        in.close();
    }
}
