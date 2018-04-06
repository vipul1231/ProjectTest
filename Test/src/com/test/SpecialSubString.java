package com.test;


import java.util.Scanner;


/**
 * 
 * Special Substrings
You have a string 
S
S, but you like only special strings. So, you have to calculate the total number of special substrings in 
S
S.

A string 
T
T, of length 
L
L, is called special string, if either of the following property holds:

All characters of the string 
T
T are same. for example, 
a
a
a
aaa
The string has an odd length (i.e, 
L
L is odd) and all characters of 
T
T are same except the middle character, for example, 
a
a
b
a
a
aabaa.
Count the total number of special substrings in 
S
S.

Input constraints:

String S contains only lower-case English alphabets.
1
≤
|
S
|
≤
10
6
1≤|S|≤106, where |S| is the length of string S.
Sample Input
aba
Sample Output
4
Explanation
S="aba"
Then there are 4 special substrings: {"a", "b", "a", "aba"}
 * 
 * @author vtiwari
 *
 */
public class SpecialSubString {

	
	public static void main(String[] args){
		SpecialSubString obj = new SpecialSubString();
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		
		int sString = 0;
		for(int i=0;i<line.length();i++){
			
			for(int j=i+1;j<=line.length();j++){
				String sub = line.substring(i, j);
				//System.out.println(sub);
				if(obj.rule(sub)){
					sString++;
				}
			}
		}
		System.out.println(sString);
		scanner.close();
	}
	
	
	private boolean rule (String input){
		StringBuilder stringBuilder = new StringBuilder(input);
		if(stringBuilder.reverse().toString().equals(input)){
			return true;
		}
		return false;
	}

}