package com.hackerrank;

import java.util.Scanner;

public class Solution_3 {
    
    public static void main(String[] args){
	Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = s.nextInt();
        }
        
        
        for(int i=0;i<N;i++){
            int number = array[i];
            
            for(int j=1;j<=number;j++){
                if(j%5==0 && j%3==0){
                System.out.println("FizzBuzz");
                }
            
                else if(j%3==0){
                System.out.println("Fizz");
                }
            
                else if(j%5==0){
                System.out.println("Buzz");
                }
            
                else{
                System.out.println(j);
                }
            }
           s.close(); 
    }

}
}
