package com.org.impl;

import javax.jws.WebService;

@WebService
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String getHelloWorld(String name) {
		// TODO Auto-generated method stub
		return "Hello World JAX-WS "+name;
	}

}
