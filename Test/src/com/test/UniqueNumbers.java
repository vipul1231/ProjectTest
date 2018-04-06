package com.test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

/**
 * Question 3
 * 
 * @author vtiwari
 *
 */
public class UniqueNumbers {
	
	
    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        
    	Set<Integer> unique = new HashSet<>();
    	Set<Integer> duplicate = new HashSet<>();
    	for(Integer number : numbers){
    		
    		if(unique.contains(number)){
    			unique.remove(number);
    			duplicate.add(number);
    		}
    		else if(duplicate.contains(number)){
    			continue;
    		}
    		else {
    			unique.add(number);
    		}
    	}
    	
    	return unique;
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(3, 3, 1, 3);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
}
