package com.hackerrank;

import java.util.Scanner;

/**
 * Accolite Software Online Test
 * 
 * Question2 Max. Marks 100.00 Vowel Phelia
 * 
 * Alice and Bob are playing a game in which Bob gives a string S of length N
 * consisting of lowercase English alphabets to Alice and ask her to calculate
 * the number of sub-strings of this string which contains exactly 3 vowels.
 * 
 * There will be T test cases in the input and output the answer for each test
 * case in a new line.
 * 
 * Sample Input:
 * 
 * The first line contains a single integer T. Each test case will consist of
 * two lines, first line containing length of string and second line will
 * contain the string.
 * 
 * Sample Output: :
 * 
 * Print the answer for each test case in a new line.
 * 
 * Constraints:
 * 
 * 1≤T≤20
 * 
 * 1≤N≤105
 * 
 * Sample Input 
 1 
 5 
 aebco
 * 
 * Sample Output 1
 * 
 * Explanation Only one substring is possible which is given by aebco.
 * 
 * @author Vipul_Anky
 *
 */
public class Solution_9 {

    public static void main(String[] args) {
	Solution_9 obj = new Solution_9();
	Scanner scanner = new Scanner(System.in);
	int noOfTestCases = Integer.parseInt(scanner.nextLine());
	
	for(int k=0;k<noOfTestCases;k++){
	    int lengthOfString = Integer.parseInt(scanner.nextLine());
		String inputString = scanner.nextLine();

		for (int i = 0; i <=lengthOfString; i++) {
		    for(int j=i+3;j<=lengthOfString;j++){
			String subsString = inputString.substring(i, j);
			
			System.out.println("String: "+subsString+" contains vowel"+obj.stringContainsVowel(subsString));
			
		    }
		}   
	}
	// System.out.println(inputArray.length);
	scanner.close();
    }

    private boolean stringContainsVowel(String sample) {
	char[] array = sample.toCharArray();
	int count = 0;
	for (int i = 0; i < array.length; i++) {
	    switch (array[i]) {
	    case 'a':
	    case 'e':
	    case 'i':
	    case 'o':
	    case 'u':
		count++;
		break;
	    default:
	    }
	    if(count>3){
		return false;
	    }
	}

	if (count == 3) {
	    return true;
	} else {
	    return false;
	}
    }
}
