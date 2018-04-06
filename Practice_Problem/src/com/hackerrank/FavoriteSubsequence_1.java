package com.hackerrank;

import java.util.Scanner;

public class FavoriteSubsequence_1 {
    private static final int MOD = (int) (1e9 + 7);
        
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int a =0;
	long ab =0;
	long abc =0;
	char[] charArray = in.nextLine().toCharArray();
	
	for(int i=0;i<charArray.length;i++){
	    switch(charArray[i]){
	    case 'a':
		a = (2*a + 1)%MOD;
		break;
	    case 'b':
		ab = (a + 2*ab)%MOD;
		break;
	    case 'c':
		abc = (ab + 2*abc)%MOD;
		break;
	    }
	}
	
	System.out.println(a);
	in.close();
	
    }

}
