package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Saharsh (aka The Next Big Thing) has a lots of ups and downs in his coding life. He rates his performance of each contest as color code. He has 5 different color codes - "Purple"-P , "Blue"-B, "Yellow"-Y, "Orange"-O and "Red"-R. P is the code for worst performance and R for the best.

Saharsh keeps track of all his performances using performance string, where i'th character of it denotes the performance code for i'th contest.

Vaibhav, his friend, is a big stalker and is interested in knowing the number of times Saharsh became "Red" coder immediately after being "Orange" coder.

Input

First line contains a single integer t denoting the number of test cases.

Each of the next t lines contains a string s denoting his performance string.

Output

For each testcase, print a single line containing required output.

Constraints

1 <= t <= 20
1 <= length(s) <= 10^5

SAMPLE INPUT 
4
BYORPO
ORBPYYOR
ROROROR
ROOOP
SAMPLE OUTPUT 
1
2
3
0
Explanation
Test case 1 :
In 'BYORPO' , OR pair occurs exactly once.
Test case 2 :
In 'ORBPYYOR' , OR pair occurs twice.
Test case 4 :
In 'ROOOP' , no OR pair occurs.
 * 
 * @author Vipul_Anky
 *
 */
public class Solution_11 {
    
    
    public static void main(String[] args){
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
	try {
	    line = br.readLine();
	    int N = Integer.parseInt(line);
	    
	    for(int i=0;i<N;i++){
		int count = 0;
		String input = br.readLine();
		
		char[] array = input.toCharArray();
		
		for(int j=0;j<array.length;j++){
		    if(array[j] == 'O' && ((j+1)<=array.length-1 && array[j+1] == 'R')){
			count++;
		    }
		}
		System.out.println(count);
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
        
        
    }

}
