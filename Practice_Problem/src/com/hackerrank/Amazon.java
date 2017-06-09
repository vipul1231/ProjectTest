package com.hackerrank;

import java.util.Scanner;

/**
 * Excited Scooby
Scooby and all of his friends have gathered for a party. There are N friends present. 
Scooby is really happy to see all of his friends in one place and is excited to greet them.
All N friends are seated in a circle, and are numbered from 0 to N-1. Scooby is initially sitting beside the Ath friend. 
After greeting one friend, he goes clockwise to the Bth next friend, sits next to him and greets him.
He repeats this till he returns to the Ath friend.
In his excitement, it is possible that Scooby misses out on greeting some friends.
Your job is to find the number of friends (including A) that Scooby will have greeted before reaching back to A.
Input:
The first line contains T, the number of test cases.
Each of the next T lines contain three space-separated integers, the values of A, B and N for that test case.
Output:
For each test case, output the number of friends that Scooby will have greeted before reaching back to A.
Constraints:
1 ≤ T ≤ 100000
1 ≤ N ≤ 1015
0 ≤ B ≤ 1015
0 ≤ A < N
Sample Input
1
1 1 5
Sample Output
5

 * 
 * 
 * 
 * @author Vipul_Anky
 *
 */
public class Amazon {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner scanner = new Scanner(System.in);
	int numberOfTest = scanner.nextInt();
	
	int numberOfMeet = 1;
	boolean notMet = true;
	for(int i=0;i<numberOfTest;i++){
	    
	    int A = scanner.nextInt();
	    int nextPerson =A;
	    int B = scanner.nextInt();
	    int numberOfFriends = scanner.nextInt();
	    
	    /*int steps = 0;
	    
	    if(A == B){
		steps = 1;
	    }
	    else {
		steps = (B+1)-A;
	    }*/
	    
	    nextPerson = B;
	    //numberOfMeet++;
	    while(notMet){
		
		
		nextPerson = nextPerson+1;
		
		if(nextPerson == A){
		    break;
		}
		
		if(nextPerson <=numberOfFriends){
		    numberOfMeet++;
		    
		}
		
		else if(nextPerson > numberOfFriends){
		    nextPerson = nextPerson - numberOfFriends;
		    if(nextPerson !=A){
			numberOfMeet++;
		    }
		}
		
		if(nextPerson == A){
		    break;
		}
		
	    }
	    
	    System.out.println(numberOfMeet);
	}
	scanner.close();
    }

}
