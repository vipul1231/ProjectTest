package com.hackerrank.Implementation;

import java.util.Scanner;

/**
 * 
 * Sheldon and array
Sheldon is a genius and today he has got an array under his interest.
He wants to find ,for all elements of the array, the nearest element on the left such that GCD of both the elements is maximum. (See sample test case for explanation.)
Note: For first element, output will always be -1.
INPUT
First line contains an integer N - size of the array.
Second line contains N space separated integers describing the array
OUTPUT
Output the index of the nearest element required in the problem.
CONSTRAINTS 
1
≤
N
≤
10
5
1≤N≤105 
1
≤
A
[
i
]
≤
10
4
1≤A[i]≤104 
SCORING 
For 40% of the scores- 
1
≤
N
≤
10
3
1≤N≤103 
For 60% of the scores- 
1
≤
N
≤
10
5
1≤N≤105
Sample Input
5
2 4 6 7 9
Sample Output
-1 1 2 3 3 
Explanation
First element is the left extreme thus we output -1 for it.
4 has GCD 2 with 2 on index 1
6 has GCD 2 with 4 on index 2
7 has GCD 1 with 6 on index 3,although 7 has gcd 1 with all integers on left but 6 is closest so we output 3
9 has GCD 3 with 6 on index 3

Time Limit: 1.0 sec(s) for each input file
 * 
 * 
 * @author Vipul_Anky
 *
 */
public class GcdOfNumber {
    
    public static void main(String[] args){
	GcdOfNumber gcdOfNumber = new GcdOfNumber();
	Scanner scanner = new Scanner(System.in);
	
	int count = scanner.nextInt();
	int[] output = new int[count];
	int[] array = new int[count];
	output[0] = -1;
	array[0] = scanner.nextInt();
	System.out.print(output[0]+" ");
	for(int i=1;i<count;i++){
	    array[i] = scanner.nextInt();
	    int maxGCD = 0;
	    for(int j=i-1;j>-1;j--){
		int result = gcdOfNumber.findGCDOfNumbers(array[i], array[j]);
		if(result > maxGCD){
		    maxGCD = result;
		    output[i] = j;
		}
	    }
	    System.out.print((++output[i])+" ");
	}
	scanner.close();
    }
    
    /**
     * Find the GCD of two number
     * 
     * @param a
     * @param b
     * @return
     */
    private int findGCDOfNumbers(int a, int b){
	
	while(b > 0){
	    int temp = b;
	    b = a % b;
	    a = temp;
	}
	return a;
    }
    
    
}
