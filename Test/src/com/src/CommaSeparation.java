package com.src;

public class CommaSeparation {
	
	public static void main(String[] args)
	{
		String str = "Brian, Beaterman";
		
		str = str.replaceAll(",", "");
		System.out.println(str);
	}

}
