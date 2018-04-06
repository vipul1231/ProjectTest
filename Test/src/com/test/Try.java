package com.test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class Worker{
	
	@Override
	public int hashCode(){
		return 7;
	}
	
	@Override
	public boolean equals(Object e){
		
		return false;
	}
	
	public float m(float x, float y) throws IOException {
        return 0;
    }
	
	
}

public class Try extends Worker{
	
	public float m(float x, float y){
        return 0;
    }
	
	public static void main(String n[]){
		
		
		Integer a = null;
		int b = a;
		System.out.println(b);
		try {
		    int c = 1/0;
		} catch (Exception e) {
		    System.out.println("E");
		} finally {
		    System.out.println("F");
		}
		
		Set<Worker> set = new HashSet<>();
		
		for(int i=0;i<100;i++){
			set.add(new Worker());
		}
		
		System.out.println(set.size());
		
	}
}
