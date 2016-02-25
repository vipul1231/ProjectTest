package tcpServer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Queue;

public class SendMessage implements Runnable{
	
	TestConnectionWithPersistance lTestConnectionWithPersistance= null;
	
	Queue<Socket> socketQueue = null;
	
	PrintWriter out = null;
	
	String ipaddress = null;
	
	int port = 0;
	
	SendMessage(TestConnectionWithPersistance obj) {
	this.lTestConnectionWithPersistance = obj;
	this.socketQueue = lTestConnectionWithPersistance.getlQueue();
	this.ipaddress = lTestConnectionWithPersistance.getIpAddress();
	this.port = lTestConnectionWithPersistance.getPort();
	}
	
	private void sendMessage() throws Exception
	{
		System.out.println("Sending Message");
		try{
	    	synchronized(this)
	    	{
	    		Socket lSocket = socketQueue.poll();
	    		lSocket = new Socket(ipaddress,port);

			     InputStreamReader fromClient =  new InputStreamReader(lSocket.getInputStream());
			     OutputStreamWriter toClient = new OutputStreamWriter(lSocket.getOutputStream());

			     //type=ACCOUNTTHRESHOLD,subscriberId=832312,balance=80,thresholdId=T1
			     
			     out = new PrintWriter(toClient);
			     out.write("type=ACCOUNTTHRESHOLD,subscriberId=832312,balance=80,thresholdId=T1,TERMENS_CONTENT,TERM");
			     out.flush();
			    
			    char lCharBuffer[] = new char[100];
			      
		        fromClient.read(lCharBuffer);
		        System.out.println("Client received: " + new String(lCharBuffer));
		        socketQueue.add(lSocket);
		        
			}
	    }
	    catch  (IOException e) {
				   throw e;
			   }
	}

	@Override
	public void run() {
		try {
			sendMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
