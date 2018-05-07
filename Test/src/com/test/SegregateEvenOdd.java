package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This class will separate out even with odd ones according to its sequence.
 * 
 * @author vtiwari
 *
 */
public class SegregateEvenOdd {

	
	static int testcase = 1;
	
	int[] t1 = { 1, 2, 5, 3, 4, 6 };
	int[] t2 = { 1, 2, 4, 6, 8, 6 };
	int[] t3 = { 1, 3, 5, 2, 4, 6 };
	int[] t4 = { 2, 4, 6, 1, 3, 5 };
	int[] t5 = { 1, 2, 3, 5, 7, 12, 18, 20, 21, 23, 30 };
	int[] t6 = { 7, 5, 9, 1, 3, 11 };
	

	public static void main(String[] args) {
		SegregateEvenOdd segregateEvenOdd = new SegregateEvenOdd();
		segregateEvenOdd.separateNumbers(segregateEvenOdd.t1);
		System.out.println(segregateEvenOdd);

		testcase = 2;
		segregateEvenOdd.separateNumbers(segregateEvenOdd.t2);
		System.out.println(segregateEvenOdd);

		testcase = 3;
		segregateEvenOdd.separateNumbers(segregateEvenOdd.t3);
		System.out.println(segregateEvenOdd);

		testcase = 4;
		segregateEvenOdd.separateNumbers(segregateEvenOdd.t4);
		System.out.println(segregateEvenOdd);
		
		testcase = 5;
		segregateEvenOdd.separateNumbers(segregateEvenOdd.t5);
		System.out.println(segregateEvenOdd);
		
		testcase = 6;
		segregateEvenOdd.separateNumbers(segregateEvenOdd.t6);
		System.out.println(segregateEvenOdd);
	}

	public String toString() {

		if(testcase == 1 ){
			for (int i = 0; i < t1.length; i++) {
				System.out.print(t1[i] + " ");
			}
			System.out.println();
		}

		if(testcase == 2){
			for (int i = 0; i < t2.length; i++) {
				System.out.print(t2[i] + " ");
			}
			System.out.println();
		}
		
		if(testcase == 3){
			for (int i = 0; i < t3.length; i++) {
				System.out.print(t3[i] + " ");
			}
			System.out.println();
		}
		
		if(testcase == 4){
			for (int i = 0; i < t4.length; i++) {
				System.out.print(t4[i] + " ");
			}
			System.out.println();
		}
		
		if(testcase == 5){
			for (int i = 0; i < t5.length; i++) {
				System.out.print(t5[i] + " ");
			}	
			System.out.println();
		}
		
		if(testcase == 6){
			for (int i = 0; i < t6.length; i++) {
				System.out.print(t6[i] + " ");
			}
			System.out.println();
		}

		return "";
	}

	/**
	 * This method will separate out numbers.
	 * 
	 * @param array
	 */
	private void separateNumbers(int[] array) {

		int even = -1, odd = -1;

		for (int i = 0; i < array.length; i++) {

			if (array[i] % 2 == 0) {

				if (even == -1) {
					even = i;
				} else
					even++;
			} else if (array[i] % 2 == 1) {

				if (even == -1) {
					odd++;
					continue;
				}

				// Count how many odd number are present ahead.
				int count = i + 1;
				List<Integer> oddNumbers = new ArrayList<>();
				oddNumbers.add(array[i]);
				while (true) {

					if (count < array.length && array[count] % 2 == 1) {
						oddNumbers.add(array[count]);
						count++;
					} else {
						break;
					}
				}

				// Copy the even array to queue.
				Queue<Integer> queue = new PriorityQueue<>();
				count = i - 1;
				while (count != odd) {
					queue.add(array[count]);
					count--;
				}
				int evenSize = queue.size();
				int oddSize = oddNumbers.size();
				// Now Copy the arrays.
				count = 0;
				int total = evenSize + oddSize;
				int lastIndex  = odd+1+total;
				for (int g = odd + 1; g <= lastIndex; g++) {
					if (count < oddSize) {
						array[g] = oddNumbers.get(count);
						count++;
						odd = g;
					} else
						
						if(!queue.isEmpty()){
							array[g] = queue.poll();
							even = g;
						}
						
				}
				// Set value of i.
				i = i + oddNumbers.size() -1;
			}
		}
	}
}
