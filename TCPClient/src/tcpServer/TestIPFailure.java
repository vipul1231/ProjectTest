package tcpServer;

import java.util.HashSet;
import java.util.Set;

public class TestIPFailure {
	
	Set<Integer> portFailure = new HashSet<Integer>();
	Set<String> ipFailure = new HashSet<String>();
	
	
	private void populateSet()
	{
		portFailure.add(8084);
		ipFailure.add("127.0.0.4");
		ipFailure.add("127.0.0.5");
	}

	public static void main(String[] args)
	{
		TestIPFailure obj = new TestIPFailure();
		obj.populateSet();
	}
	
	/*private void iPAndPortRemoveFromFailureList(String ip, int port)
    {
        int portCounter = 0;
        Set<String> list = ipMap.keySet();

        for(String ipAddress : list)
        {
            List<Integer> lList = ipMap.get(ipAddress);
            if(lList.contains(port) && ipAddress.equals(ip))
            {
                portCounter++;
            }
        }

        if(portCounter>1)
        {

        }

    }*/
}
