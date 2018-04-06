package com.hackerrank.Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class Twitter {
    
    public static void main(String[] args){
	Twitter twitter = new Twitter();
	Map<String,Integer> map = new HashMap<>();
	Scanner scanner = new Scanner(System.in);
	
	int test = Integer.parseInt(scanner.nextLine());

	for(int i=0;i<test;i++){
	    String input  = scanner.nextLine();
	    String[] array = input.split(" ");
	    for(int j=0;j<array.length;j++){
		if(array[j].contains("#")){
		    Integer hashTagCount = map.get(array[j]);
		    if(hashTagCount==null){
			map.put(array[j], 1);
		    }
		    else{
			map.put(array[j], ++hashTagCount);
		    }
		}
	    }
	}
	
	List<String> list = twitter.sortUsingComparator(map);
	
	for(String result : list){
	    System.out.println(result);
	}

	
	scanner.close();
    }
    
    private List<String> sortUsingComparator(Map<String, Integer> map){
	
	List<Entry<String, Integer>> sortedList = new LinkedList<Entry<String, Integer>>(map.entrySet());


	Collections.sort(sortedList, new Comparator<Entry<String,Integer>>() {

	    @Override
	    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		// TODO Auto-generated method stub
		
		if(o2.getValue() == o1.getValue()){
		    return o1.getKey().compareTo(o2.getKey());
		}
		
		return o2.getValue().compareTo(o1.getValue());
	    }
	});
	
	List<String> sortedMap = new ArrayList<>();
	
	for(Entry<String,Integer> entry : sortedList){
	    sortedMap.add(entry.getKey());
	}
	
	return sortedMap;
    }

}
