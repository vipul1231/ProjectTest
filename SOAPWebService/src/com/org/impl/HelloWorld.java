package com.org.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(endpointInterface = "com.org.impl.HelloWorld")
@SOAPBinding(style=Style.DOCUMENT)
public interface HelloWorld {
	
	@WebMethod
	String getHelloWorld(String name);

}
