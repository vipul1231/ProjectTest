package tcpServer;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Queue;

public class TestConnectionWithPersistance implements Runnable {
	
	Socket socket = null;
	
	static Queue<Socket> lQueue = new LinkedList<Socket>();
	
	public Queue<Socket> getlQueue() {
		return lQueue;
	}

	public void setlQueue(Queue<Socket> lQueue) {
		lQueue = TestConnectionWithPersistance.lQueue;
	}

	String IpAddress =  null;
	
	public String getIpAddress() {
		return IpAddress;
	}

	public void setIpAddress(String ipAddress) {
		IpAddress = ipAddress;
	}

	int port = 0;
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	int noOfConnectionNeeded = 1000;
	
	static boolean threadsInitated = false;
	
	
	TestConnectionWithPersistance(String ipAddress, int port)
	{
		this.IpAddress = ipAddress;
		this.port = port;
	}
	
	/*public static void main(String[] args)
	{
		TestConnectionWithPersistance obj  = new TestConnectionWithPersistance("127.0.0.1", 8085);
		obj.testConnectionPersistance();
	}*/
	
	/*private void checkNoOfSocketConnectionMade()
	{
		String line = null;
		
		for(int i=0;i<noOfConnectionNeeded;i++)
		{
			Socket number = lQueue.peek();
			try {
				BufferedReader bfr = new BufferedReader(new InputStreamReader(number.getInputStream()));
				System.out.println("dsdasd");
				if(line == bfr.readLine())
				{
					System.out.println("Socket is connected, Number: "+i);
					bfr.close();
				}
				else
				{
					System.out.println("Socket is disconnected, Number: "+i);
				}
			} catch (Exception e) {
				System.out.println("Exception :" + e);
			}
		}
	}*/
	
	public void testConnectionPersistance()
	{
		try {
			for(int i=0;i<noOfConnectionNeeded;i++)
			{
				System.out.println("Connection Request: "+i);
				socket = new Socket(IpAddress,port);
				lQueue.add(socket);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		if(threadsInitated == false)
		{
			testConnectionPersistance();	
		}
	}
}
