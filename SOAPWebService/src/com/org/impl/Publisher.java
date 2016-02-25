package com.org.impl;

public class Publisher {
	
	public static void main(String[] args)
	{
		System.out.println("Service Started");
		javax.xml.ws.Endpoint.publish("http://localhost:7779/ws/hello", new HelloWorldImpl());
	}

}
