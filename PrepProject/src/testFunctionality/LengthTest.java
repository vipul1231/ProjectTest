package testFunctionality;

import java.util.HashMap;
import java.util.Map;

public class LengthTest {
	
	private static final String SMSTAG="SMS,SMS";
	
	private static final String DELIMITER="SPB";
	
	static Map<String,String> lMap = new HashMap<>();
	
	static String str = "<SPB>type=OTHER,subscriberId=323123,balance=23,thresholdId=T1,<SMS>Hello User, Welcome to the vodafone.</SMS>,thresholdName=threshold</SPB>ENS_Content";
	
	static String strSMSTagFirst = "<SMS>Hello User, Welcome to the vodafone.</SMS><SPB>type=OTHER,subscriberId=323123,balance=23,thresholdId=T1,thresholdName=threshold</SPB>ENS_Content";
	
	static String strSMSTagMiddle = "<SPB>type=OTHER,subscriberId=323123,balance=23,thresholdId=T1,thresholdName=threshold</SPB><SMS>Hello User, Welcome to the vodafone.</SMS>ENS_Content";
	
	static String strSMSTagEnd = "<SPB>type=OTHER,subscriberId=323123,balance=23,thresholdId=T1,thresholdName=threshold</SPB>ENS_Content<SMS>Hello User, Welcome to the vodafone.</SMS>";
	
	public static void main(String[] args)
	{
		String lStarttagSPB = buildSpecificDelimiter(DELIMITER, true);
		
		String lEndtagSPB = buildSpecificDelimiter(DELIMITER, false);
		
		String[] smsArray = buildSMSSpecificDelimiter(SMSTAG);
		
		int lengthOfSMSTag = smsArray[0].length();
		
		System.out.println("Delim 1: "+smsArray[0]+" Delim 2: "+smsArray[1]);
		
		StringBuilder lstringBuilder = new StringBuilder();
		
	    System.out.println("Checking whether SMS Tag is present or not");
		
		if(str.contains(smsArray[0]))
		{
			System.out.println("Between comma.");
			int index = str.indexOf(smsArray[0]);
			int index1 = str.indexOf(lStarttagSPB);
			
			if(index1<index)
			{
				String str3 = str.substring((str.indexOf(smsArray[1]))+(smsArray[1].length()),str.indexOf(lEndtagSPB));
				String str2 = str.substring(str.indexOf(smsArray[0])+lengthOfSMSTag, str.indexOf(smsArray[1]));
				String str1 = str.substring(lStarttagSPB.length(),str.indexOf(smsArray[0])-1);
				lstringBuilder.append(str1);
				lstringBuilder.append(str3);
				lstringBuilder.append(",SMSTXT=");
				lstringBuilder.append(str2);
				System.out.println("Complete message: "+lstringBuilder.toString());
				
				String ensMessage = str.substring(str.indexOf(lEndtagSPB)+lEndtagSPB.length(),str.length());
				System.out.println("ENS Message: "+ensMessage);
			}
		}
		
		
		if(strSMSTagFirst.contains(smsArray[0]))
		{
			System.out.println("\n\nSMS Tag First");
			int index = strSMSTagFirst.indexOf(smsArray[0]);
			int index1 = strSMSTagFirst.indexOf(lStarttagSPB);
			if(index1>index)
			{
				String str4SMS = strSMSTagFirst.substring(smsArray[0].length(),strSMSTagFirst.indexOf(smsArray[1]));
				System.out.println("SMS Text: "+str4SMS);
				String spbMessage = strSMSTagFirst.substring(strSMSTagFirst.indexOf(lStarttagSPB)+lStarttagSPB.length(),strSMSTagFirst.indexOf(lEndtagSPB));
				System.out.println("SPB Message: "+spbMessage);
				String ensMessage = strSMSTagFirst.substring(strSMSTagFirst.indexOf(lEndtagSPB)+lEndtagSPB.length(),strSMSTagFirst.length());
				System.out.println("ENS Message: "+ensMessage);
			}
		}
		
		if(strSMSTagMiddle.contains(smsArray[0]))
		{
			System.out.println("\n\nSMS Tag Middle");
			int index = strSMSTagMiddle.indexOf(smsArray[0]);
			int index1 = strSMSTagMiddle.indexOf(lEndtagSPB);
			
			if(index1<index)
			{
				String str4SMS = strSMSTagMiddle.substring(strSMSTagMiddle.indexOf(smsArray[0])+smsArray[0].length(),strSMSTagMiddle.indexOf(smsArray[1]));
				System.out.println(str4SMS);
				String spbMessage = strSMSTagMiddle.substring(strSMSTagMiddle.indexOf(lStarttagSPB)+lStarttagSPB.length(),strSMSTagMiddle.indexOf(lEndtagSPB));
				System.out.println("SPB Message: "+spbMessage);
				String ensMessage = strSMSTagMiddle.substring(strSMSTagMiddle.indexOf(smsArray[1])+smsArray[1].length(),strSMSTagMiddle.length());
				System.out.println("ENS Message: "+ensMessage);
			}
		}
		
		if(strSMSTagEnd.contains(smsArray[0]))
		{
			System.out.println("\n\nSMS Tag End");
			int index = strSMSTagEnd.indexOf(smsArray[0]);
			int index1 = strSMSTagEnd.indexOf(lEndtagSPB);
			
			if(index1<index)
			{
				String str4SMS = strSMSTagEnd.substring(strSMSTagEnd.indexOf(smsArray[0])+smsArray[0].length(),strSMSTagEnd.indexOf(smsArray[1]));
				System.out.println(str4SMS);
				String spbMessage = strSMSTagEnd.substring(strSMSTagEnd.indexOf(lStarttagSPB)+lStarttagSPB.length(),strSMSTagEnd.indexOf(lEndtagSPB));
				System.out.println("SPB Message: "+spbMessage);
				String ensMessage = strSMSTagEnd.substring(strSMSTagEnd.indexOf(lEndtagSPB)+lEndtagSPB.length(),strSMSTagEnd.indexOf(smsArray[0]));
				System.out.println("ENS Message: "+ensMessage);
			}
		}
	}
	
	private static String[] buildSMSSpecificDelimiter(String Delimiter)
	{
		String[] newArray = new String[2];
		String[] array = Delimiter.split(",");
		newArray[0] = buildSpecificDelimiter(array[0], true);
		newArray[1] = buildSpecificDelimiter(array[1], false);
		return newArray;
	}
	
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
}
