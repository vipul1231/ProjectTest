package org.com.testProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class TestClass {
	
	public static void main(String[] args)
	{
	
	List<String> str = new ArrayList<String>();
	str.add("1");
	str.add("2");
	str.add("3");
	str.add("4");
	str.add("5");
	
	List<String> str1 = new ArrayList<String>();
	str1.add("6");
	str1.add("7");
	str1.add("8");
	str1.add("9");
	str1.add("10");
	
	
	
	Queue<String> str3 = new LinkedList<String>();
	List<String> str4 = new ArrayList<String>();
	str4.addAll(str1);
	str4.addAll(str);
	str3.addAll(str);
	str3.addAll(str1);
	
	for(String str5 : str3)
	{
		System.out.println(str5);
	}
	System.out.println("============================");
	
	for(String str6 : str4)
	{
		System.out.println(str6);
	}
	
	}
}
