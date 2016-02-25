package tcpServer;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



class ExecutorProcessor implements Runnable 
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("From Executor Processor");
	}	
}

public class ScheduledExecutor implements Runnable
{
	private ExecutorService serverThread = null;
	
	private Executor threadPool = null;

	private ServerSocket serverSocket = null;
	
	public static int counter = 0;
	
	static int[] list = new int[3];
	
	//Default constructor
	public ScheduledExecutor() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args)
	{
		ScheduledExecutor obj = new ScheduledExecutor();
		obj.sendTheTCPMessage(10390);
	}
	
	public void sendTheTCPMessage(int port)
	{
		//serverThread = Executors.newSingleThreadExecutor();
		//serverThread.execute(this);
		//startAcceptingTCPServerConnection();
		
		list[0]=10390;
		list[1]=10391;
		list[2]=10392;
		final Random rnd = new Random();
		System.out.println("Sending TCP Message!!");
		sendMessageToTCPServer(list[rnd.nextInt(3)]);	 
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			serverSocket = new ServerSocket();
			serverSocket.setReuseAddress(true);
			serverSocket.bind(new InetSocketAddress("135.250.215.418", 8080));
			System.out.println("ServerSocket Created");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void startAcceptingTCPServerConnection()
	{
		try {
			while(true)
			{
				serverSocket.accept();	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sendMessageToTCPServer(int port)
	{
		Socket socketObject = null;
		try {
			socketObject = new Socket("127.0.0.1",port);
			OutputStreamWriter obj =new OutputStreamWriter(socketObject.getOutputStream(), StandardCharsets.UTF_8);
			PrintWriter obj2 = new PrintWriter(obj,true);
			obj2.print("My name is Vipul, counter: "+counter);
			counter++;
			obj2.close();
			socketObject.close();
		}  
		catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//Thread.currentThread().interrupt()
		}
	}
}
