package tcpServer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

public class ClientServerSocket implements Runnable {
	
	int noOfConnections = 10;
	
	Set<Thread> set = new HashSet<Thread>();
	
	public static void main(String[] args)
	{
		ClientServerSocket obj = new ClientServerSocket();
		obj.createConnection(obj);	
	}
	
	public void createConnection(ClientServerSocket obj)
	{
		System.out.println(set.size());
		while(true)
		{
			if(set.size() < noOfConnections)
			{
				
				Thread t = new Thread(obj);
				t.start();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(t.isAlive())
				{
					System.out.println("Thread:"+t+" is Alive!!");
					set.add(t);	
				}
			}
			else
			{
				System.out.println("No of connection limit reached");
				for(int i=0;i<10;i++)
				{
					Thread t = set.iterator().next();
					System.out.println(t.isAlive());
				}
				System.exit(0);
			}	
		}	
	}
	
	
	public void sendRequest() throws IOException
	{
		synchronized (this) {
			try{
				 Socket socket = new Socket("127.0.0.1",8085);

			     InputStreamReader fromClient =  new InputStreamReader(socket.getInputStream());
			     OutputStreamWriter toClient = new OutputStreamWriter(socket.getOutputStream());

			     //type=ACCOUNTTHRESHOLD,subscriberId=832312,balance=80,thresholdId=T1
			     
			     PrintWriter out = new PrintWriter(toClient);
			     out.write("type=ACCOUNTTHRESHOLD,subscriberId=832312,balance=80,thresholdId=T1,TERMENS_CONTENT,TERM");
			     out.flush();
			    
			    char lCharBuffer[] = new char[100];
			      
		        fromClient.read(lCharBuffer);
		        System.out.println("Client received: " + new String(lCharBuffer));
		        
		        out.close();
			     socket.close();
			   } catch (UnknownHostException e) {
			     System.out.println("Unknown host: kq6py");
			     System.exit(1);
			   } catch  (IOException e) {
				   throw e;
			   }
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			synchronized (this) {
				sendRequest();
			}	
		}
		catch(IOException e)
		{
			
		}
		finally
		{
			
		}
					  }
	
	}
