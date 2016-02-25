package com.org.consume;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.org.impl.HelloWorld;

public class HelloWorldClient {
	
	public static void main(String[] args)
	{
		try {
			URL url = new URL("http://localhost:7779/ws/hello?wsdl");	
			QName qname = new QName("http://impl.org.com/", "HelloWorldImplService");
			Service service = Service.create(url,qname);
			System.out.println(service.getWSDLDocumentLocation());
			HelloWorld helloworld = service.getPort(HelloWorld.class);
			System.out.println(helloworld.getHelloWorld("Vipul"));
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
