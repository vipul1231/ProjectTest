package com.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Accolite Software Online Test
 * 
 * Question3Max. Marks 100.00 Sum of Digits You are given an array of N N
 * distinct numbers. Now, we call the Digit Value of a number to be the sum of
 * its digits..
 * 
 * Now, a subset is a set of not-necessarily-contiguous array elements. We call
 * the value of a set to be the the maximum over the Digit Value of all elements
 * it contains.
 * 
 * Now, you need to find the summation of the values of all 2 N − 1 2N−1
 * non-empty subsets of this array. As the answer can be rather large, print it
 * Modulo 10 9 + 7 109+7. Can you do it ?
 * 
 * Input Format :
 * 
 * The first line contains a single integer N N. The next line contains N N
 * space separated integers, where the i t h ith integer denotes A [ i ] A[i].
 * 
 * Output Format :
 * 
 * Print the summation of the value of each non-empty subset of the given array
 * Modulo 10 9 + 7 109+7.
 * 
 * Constraints :
 * 
 * 1 ≤ N ≤ 10 5 1≤N≤105
 * 
 * 0 ≤ A [ i ] ≤ 10 18 0≤A[i]≤1018
 * 
 * Sample Input 3 10 20 30 Sample Output 17 Explanation The subsets of this
 * array and their values are :
 * 
 * (10) : 1
 * 
 * (20) : 2
 * 
 * (30) : 3
 * 
 * (10,20) : 2
 * 
 * (10, 30) : 3
 * 
 * (20,30) : 3
 * 
 * (10,20,30 ) : 3
 * 
 * Thus, the final answer is (1+2+3+2+3+3+3) (1+2+3+2+3+3+3) = 17
 * 
 * 
 * @author Vipul_Anky
 *
 */
public class Solution_8 {

    List<List<Long>> listOflist = new ArrayList<>();

    List<Long> sum = new ArrayList<>();

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	Solution_8 obj = new Solution_8();

	// Scanner s = new Scanner(System.in);

	try {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String line = br.readLine();
	    int numberOfElements = Integer.parseInt(line);

	    // int numberOfElements = s.nextInt();
	    long[] array = new long[numberOfElements];

	    String[] array1 = br.readLine().split(" ");
	    for (int i = 0; i < numberOfElements; i++) {
		array[i] = Integer.parseInt(array1[i]);
		//System.out.println(array1.length);
	    }

	    obj.findingSubsets(array);
	    System.out.println(obj.listOflist);
	    obj.findDigitValue();
	    obj.findFinalSum();
	}

	catch (Exception e) {
	    System.out.println("Exception occured");
	}
	// s.close();
    }

    /**
     * Find the Final sum by showing Modulo 10^9+7
     */
    private void findFinalSum() {
	Long total = 0l;

	for (int i = 0; i < sum.size(); i++) {
	    total = (total + sum.get(i)) % 1000000007;
	}

	System.out.println(total);
    }

    /**
     * Find the subsets from the given set
     * 
     * @param array
     */
    private void findingSubsets(long[] array) {
	int n = array.length;
	for (int i = 0; i < (1 << n); i++) {
	    List<Long> list = new ArrayList<>();
	    for (int j = 0; j < n; j++)
		if ((i & (1 << j)) > 0) {
		    list.add(array[j]);
		}
	    if (!list.isEmpty())
		listOflist.add(list);
	}
    }

    /**
     * Find Digit Value of the number from list.
     * If number is 123 sum of digit will have 1+2+3=6. 
     */
    private void findDigitValue() {

	List<Long> sumOfDigit = new ArrayList<>();
	for (List<Long> list : listOflist) {
	    for (Long integer : list) {
		Long a = integer, r, sum = 0l;
		while (a != 0) {
		    r = a % 10;
		    sum = sum + r;
		    a = a / 10;
		}
		sumOfDigit.add(sum);
	    }
	    sum.add(findMaximumInList(sumOfDigit));
	    sumOfDigit.clear();
	    // System.out.println();
	}

    }

    /**
     * Find the maximum in the list
     * 
     * @param list
     * @return
     */
    public long findMaximumInList(List<Long> list) {
	Long maximum = 0l;

	for (Long integer : list) {
	    if (maximum < integer) {
		maximum = integer;
	    }
	}
	return maximum;
    }
}
