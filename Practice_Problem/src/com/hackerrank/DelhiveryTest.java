package com.hackerrank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DelhiveryTest {
    
    public static void main(String[] args){
	DelhiveryTest obj = new DelhiveryTest();
	Scanner scanner = new Scanner(System.in);
	scanner.useDelimiter(",|\\s+");
	Integer noTest = scanner.nextInt();
	
	for(int i=0;i<noTest;i++){
	
	    int a = scanner.nextInt();
	    int b= scanner.nextInt();
	    long[] array = new long[a];
	    
	    for(int j=0;j<a;j++){
		String input  = scanner.next();
		array[j] = Integer.parseInt(input);
	    }
	    
	    obj.find(array, b);
	}
	
	scanner.close();
    }
    
    
    private void find(long[] array, int swaps){
	Set<Long> set = new TreeSet<>();
	List<Long> list = createList(array);
	set.addAll(list);
	Iterator<Long> iter = set.iterator();
	
	if(swaps == 0){
	    System.out.println(iter.next());
	}
	else {
	    Long result = 0l;
	    for(int i=0;i<swaps;i++){
		result = result + iter.next();
	    }
	    System.out.println(result);
	}
    }
    
    private List<Long> createList(long[] array){
	
	List<Long> list = new ArrayList<>();
	
	for(int i=0;i<array.length;i++){
	    list.add(array[i]);
	}
	
	return list;
    }
    
}
