package tcpServer;
/**
 ****************************************************************************
 *
 * $RCSfile: Server.java,v $
 *
 * $Revision: 1.3 $
 *
 * $Id: Server.java,v 1.3 2014/08/11 17:59:21 meichen Exp $
 *
 * Copyright (c) 2012 Alcatel-Lucent. All rights reserved.
 * Please read the associated COPYRIGHTS file for more details.
 *
 ****************************************************************************
 */

import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * The class represents a server socket which can be used to accept notification
 * connections initiated from SurePay.
 */
@SuppressWarnings({"PublicMethodNotExposedInInterface"})
public class Server implements Runnable, Connection.ClosedListener
{
    /**
     * Logger
     */
    //private static final Logger logger = //TPAResources.getLogger();

    /**
     * the IP address the server socket binds to
     */
    private InetAddress bindAddress;

    /**
     * the port number the server socket binds to
     */
    private int port;

    /**
     * max number of active notification connections for this server
     */
    private int maxConnections;

    /**
     * notification delimiter
     */
    private String delimiter;

    /**
     * Notification adaptor
     */
   // private NotificationAdaptor adaptor;

    /**
     * opened server port
     */
    private ServerSocket serverSocket = null;

    /**
     * the main server thread
     */
    private ExecutorService serverThread = null;

    /**
     * the notification connection thread pool
     */
    private ExecutorService connectionThreadPool = null;

    /**
     * active connections
     */
    private Set<Connection> activeConnections = new HashSet<Connection>();

    /**
     * Timeout duration
     */
    private final static int TMEOUT = 10;
    
    private static final String SERVERTHREAD="server Thread";
    
    private static final String CONNECTIONTHREAD="connection thread";

    /**
     * Constructor
     *
     * @param aInBindAddress    the IP address the server socket binds to
     * @param aInPort           the port number the server socket binds to
     * @param aInMaxConnections max number of active notification connections
     *                          for this server
     * @param aInDelimiter      notification delimiter
     * @param aInMaxConnections max number of active notification connections
     *                          for this server
     */
    public Server(InetAddress aInBindAddress, int aInPort,
            int aInMaxConnections, String aInDelimiter
            )
    {
        bindAddress = aInBindAddress;
        port = aInPort;
        maxConnections = aInMaxConnections;
        delimiter = aInDelimiter;
        //adaptor = aInAdaptor;
    }

    /**
     * Start the server
     */
    public synchronized void start()
    {
        if (isRunning())
        {
        	System.out.println("Server already started.");
            return;
        }

        connectionThreadPool = Executors.newFixedThreadPool(maxConnections);

        // create a new thread for the server socket
        serverThread = Executors.newFixedThreadPool(1);
        serverThread.submit(this);
    }

    /**
     * The following method shuts down an ExecutorService in two phases, first
     * by calling shutdown to reject incoming tasks, and then calling
     * shutdownNow, if necessary, to cancel any lingering tasks:
     */

    private void shutdownAndAwaitTermination(ExecutorService aInPool, String threadType)
    {
        if(aInPool != null)
        {
        	System.out.println("ShutDown Task :"+aInPool.toString());
            // Disable new tasks from being submitted.
            System.out.println("Shutting down a tcpip connection :"+aInPool);
            aInPool.shutdown();
        }

        try
        {
            // Wait a while for existing tasks to terminate
        	System.out.println("Pool Status: "+aInPool.isTerminated()+" Thread Type: "+ threadType);
            if (!aInPool.awaitTermination(10, TimeUnit.SECONDS))
            {
            	System.out.println("Shutting down the tcpip connection"+
                        " again after waiting for a while.");

                // Cancel currently executing tasks.
                aInPool.shutdownNow();

                // Wait a while for tasks to respond to being cancelled
                if (!aInPool.awaitTermination(10, TimeUnit.SECONDS))
                {
                	System.out.println("Server did not terminate");
                }
            }
        }
        catch (InterruptedException ie)
        {
        	System.out.println("Shutting down the tcpip connection after it was interrupted.");

            // (Re-)Cancel if current thread also interrupted
            aInPool.shutdownNow();

            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++=");
        aInPool = null;
    }

    /**
     * Stop the server.
     */
    public synchronized void stop()
    {
        
    	System.out.println("Closing connection thread pool");
        shutdownAndAwaitTermination(connectionThreadPool,CONNECTIONTHREAD);

        if (connectionThreadPool != null)
        {
            for (Connection lConnection : activeConnections)
            {
                close(lConnection, "connection.");
            }
            activeConnections.clear();
        }
        
        System.out.println("Closing server socket");
        close(serverSocket);
        
        System.out.println("Server Thread Stop Request Received");
        shutdownAndAwaitTermination(serverThread,SERVERTHREAD);
        
    }
    
     static boolean isShuttingdown=false;

    /**
     * Checks if the server is running or not
     *
     * @return true if the server is running, false otherwise
     */
    public synchronized boolean isRunning()
    {
    	return serverThread != null && !serverThread.isShutdown();
    }

    /**
     * Stop the server asynchronously
     */
    private void asyncStop()
    {
        Thread lKiller = new Thread(new Runnable()
        {
            public void run()
            {
                stop();
            }
        });
        lKiller.start();
    }
    Socket lNewSocket;

    /*
     * Continuously waits for and accepts new connection request.
     *
     * @throws IOException if there's an IO error
     */
    @SuppressWarnings({"InfiniteLoopStatement", "FeatureEnvy"})
    private void acceptNewConnections() throws IOException
    {
        while (true)
        {
        	
        	System.out.println("acceptNewConnections");
            lNewSocket = serverSocket.accept();
         	System.out.println("acceptNewConnections >>>>>>>>>>>>>>>>...."+isShuttingdown);
             if(isShuttingdown)
            	 break;
             
            System.out.println( "A new connection is established: "+
                    lNewSocket);
            
            Connection lConnection =
                    new Connection(lNewSocket, delimiter, this);
            System.out.println("Created Connection");
            synchronized (this)
            {
                if (connectionThreadPool == null)
                {
                    close(lNewSocket);
                    break; // stop() has been called by other threads, so quit
                }

                if (activeConnections.size() < maxConnections)
                {
                    connectionThreadPool.submit(lConnection);
                    activeConnections.add(lConnection);
                    System.out.println(">>>>>>>>>>>>");
                }
                else
                {
                    close(lNewSocket);
                    System.out.format(
                            "The number of active connections has already ",
                            "reached its max limit ", maxConnections,
                            ".  The new connection request is rejected.");
                }
            }
        }
    }

    @Override
    public void run()
    {
        try
        {
            
            serverSocket = new ServerSocket();
            serverSocket.setReuseAddress(true);
            serverSocket.bind(new InetSocketAddress(
                        bindAddress.getHostAddress(), port), 0);
           
            System.out.println("Accepting connection requests at "+
                    bindAddress+ ":"+ port+
                    ".  Max number of active connections is "+ maxConnections);
            acceptNewConnections();
        }
        catch (Exception e)
        {
        	  System.out.println("Exception: "+ e.getCause());
        }
        finally
        {
            //close(serverSocket);
            /*synchronized (this)
            {*/
                serverSocket = null;
            /*}*/
        }
        
        System.out.println("TCP server shutdownsuccessfully");
    }

    @Override
    public void closed(Connection aInConnection)
    {
        synchronized (this)
        {
            activeConnections.remove(aInConnection);
        }
    }

    /**
     * Utility method to close the given closeable
     *
     * @param aInCloseable    resource to be closed
     * @param aInResourceDesc hint about the resource
     */
    private static void close(Closeable aInCloseable, String aInResourceDesc)
    {
        if (aInCloseable == null)
        {
            return;
        }

        try
        {
            aInCloseable.close();
        }
        catch (IOException e)
        {
        	e.printStackTrace();
            //TPAResources.debugException(logger, e, "Failed to close the ",
                 //   aInResourceDesc);
        }
    }

    /**
     * Close the given server socket
     *
     * @param aInServerSocket server socket to be closed
     */
    private static void close(ServerSocket aInServerSocket)
    {
    	if (aInServerSocket == null)
        {
            return;
        }

        try
        {
        	//isShuttingdown=true;
        	
//        	Socket sock = new Socket(aInServerSocket.getInetAddress(), aInServerSocket.getLocalPort());
//        	System.out.println(aInServerSocket.getInetAddress()+"      "+ aInServerSocket.getLocalPort());
//        	
//        	
//        while(!sock.isClosed())
//        {
//        	System.out.println("sock.isClosed()");
//        	sock.close();
//        }	
            aInServerSocket.close();
        }
        catch (IOException e)
        {
        	e.printStackTrace();
            //TPAResources.debugException(logger, e,
                  //  "Failed to close the server socket");
        }
    }

    /**
     * Close the given client socket
     *
     * @param aInClientSocket client socket to be closed
     */
    private static void close(Socket aInClientSocket)
    {
        if (aInClientSocket == null)
        {
            return;
        }

        try
        {
        	while(!aInClientSocket.isClosed()){
        	System.out.println("aInClientSocket.isClosed()");
        		aInClientSocket.close();
        	}
        }
        catch (IOException e)
        {
        	e.printStackTrace();
            //TPAResources.debugException(logger, e,
                    //"Failed to close the client socket");
        }
    }
}
