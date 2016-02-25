package tcpServer;

import java.net.*;
import java.io.*;

public class ServerSideSocket implements Runnable{ 
	
	static int requestHandled = 0;
	
	String ipAddress;
	
	int port;
	
    private ServerSocket serverSocket;
    
    public ServerSideSocket(String ipaddress, int Port)
    {
    	ipAddress = ipaddress;
    	port = Port;
    }
    
    public void run() {
	    	try
	    	{
	    		serverSocket = new ServerSocket();
				serverSocket.bind(new InetSocketAddress(ipAddress, port));
				InputStream lInputStream = null;
				InputStreamReader fromClient = null;
			    PrintWriter toClient = null;
				Socket server = null;
				
				while(true)
						{
						 System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "..." + serverSocket.getInetAddress()); 
						 
						 synchronized(this)
						 {
						 server = serverSocket.accept();
						 
						 System.out.println("Just connected to " + server.getRemoteSocketAddress()); 
								
						 while(true)
						 {
							 lInputStream = new BufferedInputStream(server.getInputStream());
							 fromClient =  new InputStreamReader(lInputStream);

						     OutputStream lOutputStream = new BufferedOutputStream(server.getOutputStream());
						     toClient =	new PrintWriter(lOutputStream);
						     requestHandled++;
						     System.out.println("No of RequestHandled: " + requestHandled);
							 
						       
						     char lCharBuffer[] = new char[100];
						     fromClient.read(lCharBuffer);
						     
						     String content = new String(lCharBuffer);
						     
						     //String[] array = content.split(",TERM");
						     
						     System.out.println("Server received: " + content);
						     //System.out.println("Split length: "+ array.length);
						     //System.out.println("Split content: "+ array[0]);
						     //System.out.println("Split content: "+ array[1]);
								
						     try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						    toClient.println("Thank you for connecting to " + server.getLocalSocketAddress() + "Goodbye!");
							toClient.flush();	 
						 }
						 
						 }
				}
			}
	    	
	    	catch(UnknownHostException ex) {
			ex.printStackTrace();
	    	}
			catch(IOException e){
			e.printStackTrace();
			}
		}
	
  public static void main(String[] args) {
	  		
	  String[] ipAddress ={"127.0.0.4"};
	  int[] port = {8084};
	  
	  for(String ip : ipAddress)
	  {
		  for(int pt : port)
		  {
			  ServerSideSocket srv = new ServerSideSocket(ip,pt);
			  Thread th1 = new Thread(srv);
			  th1.start();
		  }
	  }		
  }
}