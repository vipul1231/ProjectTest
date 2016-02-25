package tcpServer;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang3.StringUtils;

public class ArrayListConversionLogic implements ENS{
	
	static String ipaddress = "127.0.0.4;127.0.0.5";
	static String port = "8084,8085;";
	static String tags = "BULK,ARGS;AUDIT;";
	int noOfConenctions = 10;
	
	String[] messages = {"HelloThisisENSmessageContainingTagBULK","HelloThisisENSmessageContainingTagARGS","HelloThisisENSmessageContainingTagAUDIT"};
	
	static Map<String,List<Integer>> lIpAddressMap = new HashMap<>();
	
	static Map<Integer,List<String>> lPortMap = new HashMap<>();
	
	Map<String, Queue<Socket>> lActiveConnections = new HashMap<>();
	
	Set<Integer> portFailure = new HashSet<Integer>();
	Set<String> ipFailure = new HashSet<String>();
	
	String message ="ThisisENSMEssageContainingTag";
	
	ExecutorService submitTCPTask = null;
	
	private void populateSet()
	{
		portFailure.add(8085);
		ipFailure.add("127.0.0.4");
		ipFailure.add("127.0.0.5");
	}
	
	private void iPAndPortRemoveFromFailureList(String ip, int port)
    {
        int portCounter = 0;
        Set<String> list = lIpAddressMap.keySet();
        
        int fPortSize = portFailure.size();
        int fIpSize = ipFailure.size();
        

        if(portCounter>1)
        {
        	System.out.println("Port "+port+" is assigned to 2 different IP address.");
        	//ipFailure.  	
        }

    }
	
	public static void main(String[] args)
	{
		ArrayListConversionLogic obj = new ArrayListConversionLogic();
		obj.startTheConnection();
		obj.mainLogic();
    }
	
	private void mainLogic()
	{
		String port1 = null;
        String[] arrayOfIpAddress = ipaddress.split(";");
        int noOfIpAddress = arrayOfIpAddress.length;

        //Get Ports
        String[] listPorts = port.split(";");
        int noOfPortsArray = listPorts.length;
        
        //Get tags
        String[] listTags = tags.split(";");
        int noOfTags = listTags.length;

        // Now segregate ports based on ip address logic
        for(int i=0;i<noOfIpAddress;i++)
        {
        	List<Integer> lList = new ArrayList<>();
            String ipAddress1 = arrayOfIpAddress[i];
            if(noOfPortsArray == 1)
            {
            	port1 = listPorts[0];	
            }
            else
            {
            	port1 = listPorts[i];
            }
            

            //split the port of it is there
            String[] ipAddressToPortMapping = port1.split(",");
            
            for(String j : ipAddressToPortMapping)
            {
                lList.add(Integer.parseInt(j));
            }

            lIpAddressMap.put(ipAddress1, lList);
            
            System.out.println(lIpAddressMap.size());

       }
       
       //Now build logic to assign tags to port
        for(String ports1 : listPorts)
        {
            String[] ports = ports1.split(",");
            int noOfPorts = ports.length;
            
            for(int i=0;i<noOfPorts;i++)
            {   
         		Integer port2 = Integer.parseInt(ports[i]);
         		try{
         			String tags2 = listTags[i];
         			String[] portsToTagsMappings = tags2.split(",");	   
                 	lPortMap.put(port2, Arrays.asList(portsToTagsMappings)); 
         		}
         		catch(ArrayIndexOutOfBoundsException e)
         		{
         			lPortMap.put(port2, null);
         		} 	  
            } 	
        }
       
       int port = fetchPortFromMap(message);
       
       String ipAddress = fetchIpAddressFromMap(port);
       
       System.out.println("IP Address: "+ipAddress+" Port: "+port);
       
       System.out.println("No of Ports: "+lPortMap.size());
       
       populateSet();
       
       iPAndPortRemoveFromFailureList("127.0.0.5",8085);
       
       Random randomGenerator = new Random();
       try {
		constructActiveConnectionWothServerWithIpAndPort();
		
		while(true)
		{
			int a  = randomGenerator.nextInt(2);
			Thread.sleep(1000);
			sendMessage(messages[a]);	
		}
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
	
	
	
	private void startTheConnection()
	{
		submitTCPTask = Executors.newCachedThreadPool();
	}
	
	private void constructActiveConnectionWothServerWithIpAndPort() throws UnknownHostException, IOException
	{	
		Set<String> setIP= lIpAddressMap.keySet();
		Set<Integer> setPort = lPortMap.keySet();

		for(String ip : setIP)
		{
			for(Integer port : setPort)
			{
				    String key = buildIpPortString(ip,port);
					Queue<Socket> lSocketList = new LinkedList<>();
					for(int i=0;i<noOfConenctions;i++)
					{
						Socket lsocket = new Socket(ip, port);
						lsocket.setSoTimeout(2000);
						lSocketList.add(lsocket);
					}
					lActiveConnections.put(key, lSocketList);
			}
		}
		
		System.out.println("Completed building Connection map: "+lActiveConnections);
	}
	
	private String buildIpPortString(String aInIp,int port)
    {
        StringBuilder str = new StringBuilder();
        str.append(aInIp);
        str.append("|");
        str.append(Integer.toString(port));
        return str.toString();
    }
	
	
	private static int fetchPortFromMap(String aInMessage)
	{
		 Iterator entries = lPortMap.entrySet().iterator();
	        while(entries.hasNext())
	        {
	            Map.Entry thisEntry = (Map.Entry) entries.next();

	            Integer port = (Integer) thisEntry.getKey();
	            @SuppressWarnings("unchecked")
				List<String> tags = (List<String>) thisEntry.getValue();
	            
	            if(tags==null)
	            {
	            	return port;
	            }

	            for(String tag : tags)
	            {
	                if(aInMessage.contains(tag))
	                {
	                    return port;
	                }
	            }
	        }
	       return 0;
	}
	
	private static String fetchIpAddressFromMap(int port)
    {
        Iterator entries = lIpAddressMap.entrySet().iterator();
        while(entries.hasNext())
        {
            Map.Entry thisEntry = (Map.Entry) entries.next();

            String ip = (String) thisEntry.getKey();
            @SuppressWarnings("unchecked")
			List<Integer> ports = (List<Integer>) thisEntry.getValue();

            for(Integer portFromList : ports)
            {
                if(port == portFromList)
                {
                    return ip;
                }
            }
        }
        return null;
    }
	
	private Socket getSocketBasedOnKey(String key)
    {
        Socket lSocket = null;
        Queue<Socket> lQueue = lActiveConnections.get(key);
        lSocket = lQueue.poll();
        return lSocket;
    }

    private void addSocketBasedOnKey(String aInkey, Socket aInSocket)
    {
        Queue<Socket> lQueue = lActiveConnections.get(aInkey);
        lQueue.add(aInSocket);
    }

	@Override
	public String sendMessage(String lMessage) {
		
		String responseFromEns = null;
        System.out.println("New connection request received for " +
                "sending message over TCP. Message content: "+lMessage);

        int port = fetchPortFromMap(lMessage);
        String ipAddress = fetchIpAddressFromMap(port);

        if (port == 0 || ipAddress == null)
        {
            System.out.println("Error finding in port or IP Address. " +
                    "Port value :"+ port+ " IP Address :"+ ipAddress);
            return null;
        }
        
        System.out.println("Connection tp IP: "+ipAddress + " Port: "+port+"\n");

        String key = buildIpPortString(ipAddress, port);

        Socket lSocket = getSocketBasedOnKey(key);

            Callable<String> lConnectTCPServer = new ConnectTCPServer(lSocket,lMessage, "");
            Future<String> response =
                    submitTCPTask.submit(lConnectTCPServer);
            try
            {
                responseFromEns = response.get();
                if (StringUtils.isEmpty(responseFromEns))
                {
                    /*TPAResources.debug(logger, "Empty Response returned from server. " +
                            "Have to close socket");*/
                	System.out.println("Empty Response returned from server. " + "Have to close socket");
                    ConnectTCPServer obj = (ConnectTCPServer) lConnectTCPServer;
                    Socket lSocket1 = obj.getSocket();
                    try
                    {
                        lSocket1.close();
                        //Create a new socket and put it in a queue
                        Socket lNewSocket = new Socket(ipAddress,port);
                        lNewSocket.setSoTimeout(2000);
                        addSocketBasedOnKey(key,lNewSocket);
                    }
                    catch (IOException e)
                    {
                        /*TPAResources.debug(logger, "Unable to close Socket, " +
                                "Error Message:", e.getMessage());*/
                        System.out.println("Unable to close Socket, " + "Error Message:"+ e.getMessage());
                    }
                }
                else
                {
                addSocketBasedOnKey(key,lSocket);
                }

            }
            catch (InterruptedException | ExecutionException e)
            {
                /*TPAResources.debug(logger, "Exception occurred with message: " +
                        "", e.getMessage());*/
            	
            	System.out.println("Exception occurred with message: "+ e.getMessage());
            }
        return responseFromEns;
	}

}
