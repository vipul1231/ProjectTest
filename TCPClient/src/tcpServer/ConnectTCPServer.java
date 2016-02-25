package tcpServer;

/**
 ****************************************************************************
 *
 * $RCSfile: ConnectTCPServer.java,v $
 *
 * $Revision: 1.1.2.1 $
 *
 * $Id: ConnectTCPServer.java,v 1.1.2.1 2015/05/13 15:23:37 vipult Exp $
 *
 * Copyright (c) 2015 Alcatel-Lucent. All Rights Reserved.
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
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;

/**
 * This is a generic class to send message over TCP socket.
 */
public class ConnectTCPServer implements Closeable, Callable<String>
{
    /**
     * Logger
     */
    //private static final Logger logger = TPAResources.getLogger();
    /**
     * Plugin which is calling this reusable code
     */
    String callFromPlugin;
    /**
     * Message to be sent.
     */
    String message;
    /**
     * Closed Connection.
     */
    ClosedConnection closedConnection = null;
    /**
     * Socket for connection.
     */
    Socket socket = null;

    String ipAddress = null;

    int port =  0;
    /**
     * Constructor
     *
     * @param aInSocket
     * @param aInMessage
     * @param aInPluginType
     *
     */
    ConnectTCPServer(Socket aInSocket,
            String aInMessage,
            String aInPluginType)
    {
        socket = aInSocket;
        callFromPlugin = aInPluginType;
        message = aInMessage;
        ipAddress = socket.getLocalAddress().getHostAddress();
        port = socket.getPort();
    }

   /* public void sendRequest() throws IOException
    {
        TPAResources.debug(logger, callFromPlugin, ": ",
                "Trying to connect server at Ip: ", socket.getLocalAddress(),
                " Port: ",socket.getPort());
        InputStream lresponseFromEns = null;
        OutputStream lsendMessageToEns = null;

        try
        {   //create input and output stream from socket
            lresponseFromEns = new BufferedInputStream(socket.getInputStream());
            lsendMessageToEns = new BufferedOutputStream(socket.getOutputStream());
            //Constantly send and receive data from ENS server
            OutputStreamWriter sendData = new OutputStreamWriter
                        (lsendMessageToEns,StandardCharsets.UTF_8);
            sendData.write(message);
            sendData.flush();
            TPAResources.debug(logger, callFromPlugin, ": ", "Message '",
                        message, "' sent successfully.");

            InputStreamReader ensResponse = new InputStreamReader
                        (lresponseFromEns);
            char[] lResponseFromClient = new char[100];
            try
            {
                ensResponse.read(lResponseFromClient);
            }
            catch (Exception e)
            {
                TPAResources.warn(logger,"Exception occurred: ",e.getMessage());
            }
            String responseFromServer = new String(lResponseFromClient);
            TPAResources.debug(logger, callFromPlugin, ": ",
                        "Received response from " +
                                "server: ", responseFromServer);

        }
        catch (Exception e)
        {
            TPAResources.debug(logger, callFromPlugin, ": ",
                    " Exception occurred while " +
                            "sending message. " + "Detailed Error message :",
                    e.toString());
            throw e;
        }
    }*/

    /*@Override
    public void run()
    {
        try
        {
            synchronized (this)
            {
                sendRequest();
            }
        }
        catch (IOException e)
        {

        }
        finally
        {
            synchronized (this)
            {
                try
                {
                    socket.close();
                    socket = null;
                    closedConnection.closed(this);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }*/

    @Override
    public void close()
    {
        synchronized (this)
        {
            if (socket != null)
            {
                try
                {
                    socket.close();
                }
                catch (IOException e)
                {
                }
            }
        }
    }

    @Override
    public String call() throws Exception
    {
        /*TPAResources.debug(logger, callFromPlugin, ": ",
                "Trying to connect server at Ip: ", socket.getLocalAddress(),
                " Port: ",socket.getPort());*/
    	
    	System.out.println("Trying to connect server at Ip: "+ socket.getLocalAddress()+" Port: "+socket.getPort());
    	
        InputStream lresponseFromEns = null;
        OutputStream lsendMessageToEns = null;
        String responseFromServer = null;

        try
        {   //create input and output stream from socket
            lresponseFromEns = new BufferedInputStream(socket.getInputStream());
            lsendMessageToEns = new BufferedOutputStream(socket.getOutputStream());

            //send and receive data from ENS server
            OutputStreamWriter sendData = new OutputStreamWriter
                    (lsendMessageToEns,StandardCharsets.UTF_8);
            sendData.write(message);
            sendData.flush();
            /*TPAResources.debug(logger, callFromPlugin, ": ", "Message '",
                    message, "' sent successfully.");*/
            System.out.println("Message sent successfully.");
            InputStreamReader ensResponse = new InputStreamReader
                    (lresponseFromEns);
            char[] lResponseFromClient = new char[100];
            try
            {
                ensResponse.read(lResponseFromClient);
            }
            catch (Exception e)
            {
                /*TPAResources.warn(logger,"Exception occurred while getting " +
                        "response: ",e.getMessage());*/
            	System.out.println("Exception occurred while getting " +"response: "+e.getMessage());
            }
            responseFromServer = new String(lResponseFromClient);
            /*TPAResources.debug(logger, callFromPlugin, ": ",
                    "Received response from " +
                            "server: ", responseFromServer);*/
            System.out.println("Received response from " + "server: "+ responseFromServer);
        }
        catch (Exception e)
        {
            /*TPAResources.debug(logger, callFromPlugin, ": ",
                    "Exception occurred while " +
                            "sending message. " + "Detailed Error message :",
                    e.toString());*/
        	System.out.println("Exception occurred while " + "sending message. " + "Detailed Error message :" +e.toString());
            throw e;
        }

        return responseFromServer;
    }

    /**
     * Inner interface to provide functionality for closing connection object.
     */
    public static interface ClosedConnection
    {
        void closed(ConnectTCPServer aInConnectTCPServer);
    }

    public void setMessage(String aInMessage)
    {
        message = aInMessage;
    }

    public Socket getSocket()
    {
        return socket;
    }

    public int getPort()
    {
        return port;
    }

    public String getIpAddress()
    {
        return ipAddress;
    }
}
