package com.hackerrank;

import java.util.Scanner;

public class Solution_5 {

    public static void main(String[] args) {

	Scanner s = new Scanner(System.in);
        String N = s.nextLine();
        boolean invalidIp = false;
        String[] ipString = N.split("\\.");
        
        if(ipString.length<4 || N.lastIndexOf(".") == N.length()-1){
            invalidIp = true;
        }
        
        if(!invalidIp){
            for(int i=0;i<ipString.length;i++){
                int a = Integer.parseInt(ipString[i]);
                if(!testNumber(a)){
            	invalidIp = true;
            	break;
                }
            }    
        }
        
        if(invalidIp){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }
        s.close();

    }
    
    
    private static boolean testNumber(int a){
	if(a>=0 && a<=255){
	    return true;
	}
	return false;
    }

}
