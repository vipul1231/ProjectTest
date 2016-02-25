package tcpServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class test {
	
	static int[] list = new int[3];
	
	
	
		
		private static final String SERVER_ADDRESS = "127.0.0.1";
	    private static final int TCP_SERVER_PORT = 8080;
	    private static boolean connected = false;
	    static Socket s;

	    public static void main(String[] args) {
	    test t = new test();
	    Timer timer = new Timer();
	       
	    final TimerTask task = new TimerTask() {

	        @Override
	        public void run() {
	            // TODO Auto-generated method stub
	            if (connected == false)
	            {
	            System.out.println(hostAvailabilityCheck());
	            }
	        }
	    };
	    timer.schedule(task, 01, 5001);
	    
	}

	    public static boolean hostAvailabilityCheck()
	    { 

	        boolean available = true; 
	        try {               
	            if (connected == false)
	            { (s = new Socket(SERVER_ADDRESS, TCP_SERVER_PORT)).close();    
	            }               
	            } 
	        catch (UnknownHostException e) 
	            { // unknown host 
	            available = false;
	            s = null;
	            } 
	        catch (IOException e) { // io exception, service probably not running 
	            available = false;
	            s = null;
	            } 
	        catch (NullPointerException e) {
	            available = false;
	            s=null;
	        }

	        return available;   
	    }
	
}
