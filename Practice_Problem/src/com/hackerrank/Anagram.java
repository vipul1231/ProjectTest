package com.hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a sequence of words, print all anagrams together
 * @author Vipul_Anky
 *
 */
public class Anagram {
    
    static Map<Character,Integer> map = new HashMap<>();
    
    static{
	map.put('a', 1);
	map.put('b', 2);
	map.put('c', 3);
	map.put('d', 4);
	map.put('e', 5);
	map.put('f', 6);
	map.put('g', 7);
	map.put('h', 8);
	map.put('i', 9);
	map.put('j', 10);
	map.put('k', 11);
	map.put('l', 12);
	map.put('m', 13);
	map.put('n', 14);
	map.put('o', 15);
	map.put('p', 16);
	map.put('q', 17);
	map.put('r', 18);
	map.put('s', 19);
	map.put('t', 20);
	map.put('u', 21);
	map.put('v', 22);
	map.put('w', 23);
	map.put('x', 24);
	map.put('y', 25);
	map.put('z', 26);
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Anagram object = new Anagram();
	String[] input = {"geeksquiz", "geeksforgeeks", "abcd", 
                "forgeeksgeeks", "zuiqkeegs"};
	int[] output = new int[input.length];
	int count = 0;
	//Complexity n
	for(String value : input){
	    output[count] = object.hashcode(value);
	    count++;
	}
	
	//TODO: Complexity n2....reduce
	for(int i=0;i<output.length;i++){
	    for(int j=i+1;j<output.length;j++){
		if(output[i] > output[j]){
		    object.swap(output,input,i,j);  
		}
	    }
	}
	
	for(String display : input){
	    System.out.println(display);
	}
    }
    
    /**
     * Swap the input and output
     * 
     * @param output
     * @param input 	
     * @param i
     * @param j
     */
    private void swap(int[] output, String[] input, int i, int j){
	
	int temp = output[i];
	output[i] = output[j];
	output[j] = temp;
	
	String temp1 = input[i];
	input[i] = input[j];
	input[j] = temp1;
    }
    
    /**
     * 
     * @param a
     * @return
     */
    public int hashcode(String a){
	char[] array = a.toCharArray();
	int hash = 0;
	for(char character : array){
	    hash+= map.get(character);
	}
	
	return hash;
    }

}
