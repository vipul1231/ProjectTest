package com.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bima2 {

    public static void main(String[] args) {

	int min = 0, max = 0;
	int maxTime = 0;

	Scanner in = new Scanner(System.in);
	
	Map<Integer, Integer> map = new HashMap<>();

	int noOfRequest = in.nextInt();

	for (int i = 0; i < noOfRequest; i++) {

	    int requestType = in.nextInt();

	    if (requestType == 1) {
		int requestTime = in.nextInt();
		int requestPriority = in.nextInt();

		map.put(requestTime, requestPriority);

		if (min == 0 && max == 0) {
		    min = requestPriority;
		    max = requestPriority;
		} else {
		    if (requestPriority < min) {
			min = requestPriority;
		    } else if (requestPriority > max) {
			max = requestPriority;
		    }
		}

		if (requestTime > maxTime) {
		    maxTime = requestTime;
		}

		map.put(requestTime, requestPriority);

		continue;
	    }

	    else if (requestType == 2) {
		map.remove(in.nextInt());
		continue;
	    }

	    else if (requestType == 3) {
		System.out.println(min + " " + max);
		continue;
	    }

	    else if (requestType == 4) {
		System.out.println(map.get(maxTime));
	    }

	}
	in.close();

    }

}
