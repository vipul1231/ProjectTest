package com.test;

import java.io.IOException;


class B {

}

public class GFG {
	
	
	@SuppressWarnings("finally")
	int check(){
		try {
			throw new IOException();
		}
		catch(Exception e){
			System.out.println("Catch");
			return 1;
		}
		finally {
			System.out.println("Finally");
			return 2;
		}	
	}
	
    public static void main(String[] args) {
        GFG obj = new GFG();
        int j = obj.check();
        System.out.println(j);
    }
}
