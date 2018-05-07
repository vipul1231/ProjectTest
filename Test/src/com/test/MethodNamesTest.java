package com.test;

import java.lang.reflect.Method;

public class MethodNamesTest {
	
	
	public static void main(String[] args){
	
		try {
			Class<?> classDup = Class.forName("com.test.InversionCount");
			Method[] methods = classDup.getDeclaredMethods();
			
			for(Method method : methods){
				
				System.out.println(method.getName());
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
	}
}
