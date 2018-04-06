package com.hackerrank;

import java.util.Scanner;

import com.timeComplexities.FibonacciComparision;
import com.timeComplexities.FindGcdNumber;

/**
 * 
 * @author Vipul_Anky
 *
 */
public class Samsung {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
		Samsung samsung = new Samsung();
		samsung.findOutput();
    }
    
    /**
     * Find the output
     */
    private void findOutput(){
	Scanner scanner = new Scanner(System.in);
	int N = scanner.nextInt();
	int Q = scanner.nextInt();
	
	int[] array = new int[N+1];
	array[0] = 0;
	for(int i=1;i<array.length;i++){
	    array[i]=scanner.nextInt();
	}
	
	for(int j = 0 ;j<Q;j++){
	    int L = scanner.nextInt();
	    int R = scanner.nextInt();
	    int gcd = FindGcdNumber.findTheGcd(array[L], array[R]);
	    
	    System.out.println(FibonacciComparision.FibonacciIterative(gcd));
	}
	
	scanner.close();
    }
}
