package tcpServer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectToTCP implements Runnable{
	
	ClosedConnection cc;
	
	Socket socket = null;
	
	PrintWriter out = null;
	
	static PrintStream ps = null;
	
	static
	{
		File file = new File("C:\\Users\\vipult\\Documents\\output.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps = new PrintStream(fos);	
	}
	
	public static void main(String[] args)
	{
		ConnectToTCP obj = new ConnectToTCP();
		try {
			obj.sendRequest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	ConnectToTCP()
	{
		
	}
	
	public ConnectToTCP(ClosedConnection aInCC) {
		// TODO Auto-generated constructor stub
		this.cc = aInCC;
	}
	
	public void sendRequest() throws IOException
	{		
	    try{
	    	synchronized(this)
	    	{
	    		 socket = new Socket("127.0.0.4",8084);

			     InputStream fromClient =  new BufferedInputStream(socket.getInputStream());
			     OutputStream toServer = new BufferedOutputStream(socket.getOutputStream());
			     OutputStreamWriter sendData = new OutputStreamWriter(toServer);
			     
			     while(true){
			    	 System.out.println("Is Socket Connected: "+socket.isConnected());
			     sendData.write("type=ACCOUNTTHRESHOLD,subscriberId=832312,balance=80,thresholdId=T1,TERMENS_CONTENT,TERM");
			     sendData.flush();
			     byte[] lCharBuffer = new byte[100];
			     socket.setSoTimeout(3000);
			     try{
			    	 fromClient.read(lCharBuffer);
			     }
			     catch(Exception e)
			     {
			    	 System.out.println("Exception :"+e);
			     }
		         System.out.println("Client received: " + new String(lCharBuffer));	         
			     }
		        
			}
	    }
	    catch  (IOException e) {
				   throw e;
			   }
		}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			 sendRequest();	
		}
		catch(Exception e)
		{
		//System.setErr(ps);
		e.printStackTrace();
		
		}
		finally
		{
			synchronized (this) {
				cc.closed(this);
				/*out.close();
			    try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/	
			}
		}
	}
	
	/**
	 * 
	 * @author vipult
	 *
	 */
	public static interface ClosedConnection
	{
		void closed(ConnectToTCP aInConnectToTCP);
	}
}
