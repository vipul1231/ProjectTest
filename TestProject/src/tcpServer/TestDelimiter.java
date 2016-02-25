package tcpServer;

public class TestDelimiter {
	
	private static String buildSpecificDelimiter(String aInDelimiter,
            boolean aInStart)
    {
        StringBuilder str = new StringBuilder();
        str.append('<');
        if (!aInStart)
        {
            str.append('/');
        }
        str.append(aInDelimiter);
        str.append('>');
        return str.toString();
    }
	public static void main(String[] args)
	{
		char lCharBuffer[] = new char[100];
		String lnewString = new String(lCharBuffer);
		System.out.println("String: "+lnewString.trim());
		
		
		
		String lNotificationContent = "<SPB>type=ACCOUNTTHRESHOLD,subscriberId=80314211,balance=10,thresholdId=ACCOUNTLIMIT</SPB>HelloENSBULK\n";
		String delimiter ="SPB";
		
		String lNotificationContentString = lNotificationContent.
                toString();
        System.out.println("Result string:" + lNotificationContentString);
        
        for(int i=0;i<100;i++)
        {
        	if(lCharBuffer[i]!='\u0000')
        	{
        		
        	}
        }

        String lSPBMessage = null;
        String lTCPMessage = null;
        boolean lIsSPBMessage = false;
        boolean lIsTCPMessage = false;
        String lStartDelimiter = buildSpecificDelimiter(delimiter, true);
        String lEndDelimiter = buildSpecificDelimiter(delimiter, false);
        if (lNotificationContentString.contains(delimiter) &&
                (lNotificationContentString.contains(lStartDelimiter)
                        &&
                        lNotificationContentString.contains(lEndDelimiter)))
        {
            lSPBMessage = lNotificationContentString.substring
                    (lStartDelimiter.length(), lNotificationContentString.
                            indexOf(lEndDelimiter));
            lTCPMessage = lNotificationContentString.substring
                    (lNotificationContentString.indexOf(lEndDelimiter) +
                            lEndDelimiter.length());

            if (!StringUtil.isNullOrEmpty(lSPBMessage) && !StringUtil.
                    isNullOrEmpty(lTCPMessage))
            {
                System.out.println("Both Notification message have been " +
                                        "received. SPB :" +lSPBMessage+
                                " ENS: "+
                                lTCPMessage);
                lIsSPBMessage = true;
                lIsTCPMessage = true;
            }
            else if (!StringUtil.isNullOrEmpty(lSPBMessage) && StringUtil.
                    isNullOrEmpty(lTCPMessage))
            {
                System.out.println("Only SPB message have been " +
                                "received. Message content :"+ lSPBMessage);
                lIsSPBMessage = true;
                lIsTCPMessage = false;
            }
        }
        else
        {
            System.out.println("The message does not have SPB delimiter" +
                                    " we expect: "+ delimiter +
                            " or it does not " +
                                    "contain start tag ["+ lStartDelimiter+
                            "] and " +
                                    "end tag ["+ lEndDelimiter +"]."+
                            " Forwarding this message to ENS server.");
            lIsTCPMessage = true;
            lIsSPBMessage = false;
            lTCPMessage = lNotificationContentString;
        }
	}
}
