package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bima {
    
    public static void main(String[] args){
	
	Bima obj = new Bima();
	Scanner in = new Scanner(System.in);
	int noOfSystems = in.nextInt();
	List<Integer> allocatedList = new ArrayList<>(noOfSystems);
	int noOfRequest = in.nextInt();
	
	for(int i=0; i<noOfRequest; i++){
	    int request = in.nextInt();
	    obj.assignTaskToSystem(allocatedList, request, noOfSystems); 
	    
	}
	
	in.close();
    }
    
    
    private void assignTaskToSystem(List<Integer> allocated, int request, int totalSystem){
	
	boolean flag = false;
	for(int i=0;i<allocated.size();i++){
	    int pRequest = allocated.get(i);
	    if (pRequest < request){
		allocated.set(i, request);
		System.out.println("YES");
		flag = true;
		break;
	    }
	}
	
	if(!flag){
	    if(allocated.size() < totalSystem){
		allocated.add(request);
		System.out.println("YES");
	    }
	    else {
		System.out.println("NO");
	    }
	}
    }

}
