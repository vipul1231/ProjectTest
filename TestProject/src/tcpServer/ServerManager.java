package tcpServer;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * This class manages the notification servers.
 */
@SuppressWarnings({"PublicMethodNotExposedInInterface"})
public class ServerManager
{
    /**
     * Singleton
     */
    private static final ServerManager instance = new ServerManager();

    /**
     * list of active servers
     */
    private List<Server> servers = new ArrayList<Server>();

    /**
     * Private constructor for singleton pattern
     */
    private ServerManager()
    {
    }

    public static ServerManager getInstance()
    {
        return instance;
    }

    /**
     * Start a server
     *
     * @param aInAddress        the IP address the server socket binds to
     * @param aInPort           the port number the server socket binds to
     * @param aInMaxConnections max number of active notification connections
     *                          for this server
     * @param aInAdaptor        notification adaptor
     */
    public void start(InetAddress aInAddress, int aInPort,
            int aInMaxConnections, String aInDelimiter)
    {
    	synchronized (this) {
    		Server lServer =
                    new Server(aInAddress, aInPort, aInMaxConnections, aInDelimiter);
            servers.add(lServer);
            lServer.start();	
		}
    }

    /**
     * Stop all active servers
     */
    public void stopAllServers()
    {
        for (Server lServer : servers)
        {
        	System.out.println(lServer.lNewSocket.getLocalPort());
        	lServer.stop();
        }
        servers.clear();
    }
}
