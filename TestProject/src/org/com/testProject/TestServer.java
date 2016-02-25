package org.com.testProject;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

public class TestServer {

	private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int TCP_SERVER_PORT = 10390;
    private static boolean connected = false;
    static Socket s;
    static Timer timer;

    public static void main(String[] args) {

    timer = new Timer();
    timer.schedule(task, 0, 1500);
    
    System.out.println("Timer task ends!!");
    
    }  

    static TimerTask task = new TimerTask() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            if (connected == false)
            {
            System.out.println(hostAvailabilityCheck());
            }
        }
    };

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


