package com.hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution_6 {
    
    private static Pattern pattern;
    private static Matcher matcher;
    
    private static final String IPADDRESS_PATTERN =
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    
    Solution_6() 
    {
	  pattern = Pattern.compile(IPADDRESS_PATTERN);
    }
    
    public static void main(String[] args){
	new Solution_6();
	Scanner s = new Scanner(System.in);
        String N = s.nextLine();
	if(validate(N)){
	    System.out.println("YES");
	}
	else{
	    System.out.println("NO");
	}
	s.close();
	
    }
    
    public static boolean validate(final String ip)
    {
	 matcher = pattern.matcher(ip);
	 return matcher.matches();
    }

}
