package com.hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class StringAnagram {

    public static void main(String[] args){
	StringAnagram stringAnagram = new StringAnagram();
	Scanner scanner = new Scanner(System.in);
	String input = scanner.nextLine();
	
	int N = Integer.parseInt(input);
	
	for(int i=0;i<N;i++){
	
	    String line = scanner.nextLine();
	    String[] data = line.split(" ");
	    int value = Integer.parseInt(data[1]);
	    List<String> output = stringAnagram.compute(data[0], value);    
	    
	    System.out.println(output.get(value-1));
	}
	scanner.close();
    }
    
    /**
     * Compute
     * 
     * @param input
     */
    private List<String> compute(String input, int value){
	
	List<String> list = new ArrayList<>();
	list.add(Character.toString(input.charAt(0)));
	
	for(int i=1;i<input.length();i++){
	    permute(list, input.charAt(i));
	}
	
	Set<String> set = new TreeSet<>(returnComparator());
	set.addAll(list);
	list.clear();
	list.addAll(set);
	System.out.println(set);
	return list;
    }
    
    private void permute(List<String> list, char a){
	List<String> l1 = new ArrayList<>();
	for(String string : list){
	    for(int i=0;i<=string.length();i++){
		String ps  = new StringBuilder(string).insert(i, a).toString();
		l1.add(ps);
	    }
	}
	
	list.clear();
	list.addAll(l1);
    } 
    
    /**
     * Comparator
     *  
     * @return
     */
    private Comparator<String> returnComparator(){
	
	Comparator<String> comp = new Comparator<String>() {

	    @Override
	    public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	    }
	};
	
	return comp;
    }
}
