package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThoughtWorks {

    public static void main(String[] args) {

	ThoughtWorks thoughtWorks = new ThoughtWorks();
	Scanner scanner = new Scanner(System.in);

	int n = Integer.parseInt(scanner.nextLine());
	
	for (int i = 0; i < n; i++) {
	    List<Integer> list = new ArrayList<>();
	    int nPeople = Integer.parseInt(scanner.nextLine());
	    String[] array = scanner.nextLine().split(" ");
	    thoughtWorks.copyList(list, array);

	    List<Integer> result = list.stream().distinct().collect(Collectors.toList());
	    int d = 0;
	    boolean flag = false;
	    for (int number : result) {

		if (number > nPeople) {
		    System.out.println("Invalid Data");
		    flag = true;
		    break;
		}

		int times = Collections.frequency(list, number);

		if (number == 1 && number < times) {
		    d = d + times;
		} else if (number == times) {
		    ++d;
		}
		else if(number !=times) {
		    if(number == nPeople) {
			++d;
		    }
		    else if((times%2 == 0 || times%3==0) && (times%number)==0){
		    	int nm = (times / number);
		    	d = d + nm;
		    }
		    else {
			System.out.println("Invalid Data" +number+" "+nPeople+" "+times);
			    flag=true;
			    break;
		    }}

	    }
	    
	    if(d > nPeople)
	    System.out.println("dsds Invalid Data");
	    else if(!flag)
	    System.out.println(d);
	    

	}
	scanner.close();
    }

    private void copyList(List<Integer> list, String[] array) {
	for (int i = 0; i < array.length; i++) {
	    list.add(Integer.parseInt(array[i]));
	}
    }
}

