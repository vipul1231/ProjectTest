package tcpServer;

/**
 ****************************************************************************
 *
 * $RCSfile: Connection.java,v $
 *
 * $Revision: 1.1.22.1 $
 *
 * $Id: Connection.java,v 1.1.22.1 2015/01/14 14:01:21 vipult Exp $
 *
 * Copyright (c) 2012 Alcatel-Lucent. All rights reserved.
 * Please read the associated COPYRIGHTS file for more details.
 *
 ****************************************************************************
 */




import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.logging.Logger;

/**
 * The class represents a TCP/IP connection which deliver notifications from
 * SurePay to smart plan builder.
 */
public class Connection implements Runnable, Closeable
{
    /**
     * Logger
     */
    private static final Logger logger = java.util.logging.LogManager.getLogManager().getLogger("Connection");

    /**
     * positive response message content
     */
    private static final byte ACK[] = "ACK".getBytes();

    /**
     * the max size of notifications
     */
    private static final int NOTIFICATION_MAX_SIZE = 300;

    /**
     * socket of the connection
     */
    private Socket clientSocket;

    /**
     * notification delimiter
     */
    private String delimiter;

    /**
     * notification adaptor
     */
    //private NotificationAdaptor adaptor;

    /**
     * flag indicates whether the connection was closed by the server
     */
    private boolean closedByServer = false;

    /**
     * listener to notify when the connection is closed
     */
    private ClosedListener closedListener;

    /**
     * Constructor
     *
     * @param aInClientSocket   socket of the connection
     * @param aInDelimiter      notification delimiter
     * @param aInAdaptor        notification adaptor
     * @param aInClosedListener listener to notify when the connection is
     *                          closed
     */
    public Connection(Socket aInClientSocket, String aInDelimiter,
           // NotificationAdaptor aInAdaptor,
            ClosedListener aInClosedListener)
    {
        clientSocket = aInClientSocket;
        closedListener = aInClosedListener;
        delimiter = aInDelimiter;
      //  adaptor = aInAdaptor;
    }

    /**
     * Send the ACK response
     *
     * @param aInOutStream output stream of the connection
     * @throws IOException if there's an IO error
     */
    private static void sendAckResponse(OutputStream aInOutStream)
            throws IOException
    {
        aInOutStream.write(ACK);
        aInOutStream.flush();
        //TPAResources.trace(logger, "Sent an ACK response.");
    }

    @Override
    public void run()
    {
    	
    	System.out.println("inside connection run mthd............................");
        //TPAResources.debug(logger, "Waiting for requests in connection: ",
                //clientSocket);

        try
        {
            synchronized (this)
            {
                readAndProcessRequest();
            }
        }
        catch (IOException e)
        {
            synchronized (this)
            {
                if (!closedByServer)
                {
                    //TPAResources.warnException(logger, e,
                //"Client connection closed unexpectedly.");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception Thrown: "+ e.getMessage());
        }
        finally
        {
            //synchronized (this)
            {
                internalClose();
                clientSocket = null;
            }
            if (closedListener != null)
            {
                closedListener.closed(this);
            }
        }
    }

    @Override
    public void close()
    {
        synchronized (this)
        {
            closedByServer = true;
            if (clientSocket != null)
            {
                internalClose();
            }
        }
    }

    /**
     * Close the socket of this connection
     */
    private void internalClose()
    {
        try
        {
        	while(!clientSocket.isClosed()){
        		clientSocket.close();
        		System.out.println("<<<<<<<<<<<,");
        	}
            
        }
        catch (IOException ignore)
        {
        }
    }

  
        /*
    * Listener to notify when the connection is closed.
    */
    public static interface ClosedListener
    {
        /**
         * Notify about the connection is closed
         *
         * @param aInClosedConnection the closed connection
         */
        void closed(Connection aInClosedConnection);
    }
    
    public synchronized void readAndProcessRequest() throws IOException
    {
    	System.out.println("readAndProcessRequest starts");

        InputStream lInputStream =
                new BufferedInputStream(clientSocket.getInputStream());

        OutputStream lOutputStream =
                new BufferedOutputStream(clientSocket.getOutputStream());


        System.out.println("InputStream: "+lInputStream);
        System.out.println("OutputStream: "+lOutputStream);

        char lCharBuffer[] = new char[NOTIFICATION_MAX_SIZE];

        while (true)
        {
            InputStreamReader lInputStreamReader =
                    new InputStreamReader(lInputStream, StandardCharsets.UTF_8);

            int lChartArrayRead = lInputStreamReader.read(lCharBuffer);

            if (lChartArrayRead == -1)
            {
                System.out.println("Nothing in LChartArray: "+lChartArrayRead);
                break;
            }

            System.out.println("TCP Char Array Read: "+lChartArrayRead);
            System.out.println("TCP Chars buffer as it is: "+new String(lCharBuffer));

         }    
    }
}
