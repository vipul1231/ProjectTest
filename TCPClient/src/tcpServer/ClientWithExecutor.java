package tcpServer;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tcpServer.ConnectToTCP.ClosedConnection;

public class ClientWithExecutor implements ENS, ClosedConnection {
	
	static int noOfConnections = 1;
	
	static ExecutorService et = null;
	
	static int requestSent =0;
	
	Set<ConnectToTCP> connectionSet = new HashSet<ConnectToTCP>();
	
	public static void main(String[] args)
	{
		et = Executors.newFixedThreadPool(noOfConnections);
		ENS obj = new ClientWithExecutor();
		/*while(true)
		{*/
			obj.sendMessage("type=ACCOUNTTHRESHOLD,subscriberId=832312,balance=80,thresholdId=T1,TERMENS_CONTENT,TERM");	
		/*}*/
	}

	@Override
	public String sendMessage(String lMessage) {
		// TODO Auto-generated method stub
		int size = connectionSet.size();
		
		if(size<noOfConnections)
		{
			ConnectToTCP obj = new ConnectToTCP(this);
			et.submit(obj);
			connectionSet.add(obj);
			requestSent++;
			System.out.println("No of Request Sent: " + requestSent);
			System.out.println("Connection Size: "+size);
		}
		else
		{
			System.out.println("Connection Size: "+size);
			//System.exit(0);
		}
		
		return null;
	}

	@Override
	public void closed(ConnectToTCP aInConnectToTCP) {
		
		connectionSet.remove(aInConnectToTCP);
		System.out.println("Connection removed: "+aInConnectToTCP);
		System.out.println("Set Size: "+connectionSet.size());
	}
}
