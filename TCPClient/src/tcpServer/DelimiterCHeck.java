package tcpServer;

public class DelimiterCHeck {
	
	String str = "<SPB>HelloThisIsSPBMessage</SPB>HelloThisIsENSMessage";

	public static void main(String[] args)
	{
		DelimiterCHeck obj  = new DelimiterCHeck();
		obj.checkTheContent();
	}
	
	private void checkTheContent()
	{
		String str1 = "<SPB>";
		String str2 = "</SPB>";
		System.out.println(str.indexOf("<SPB>"));
		System.out.println(str.indexOf("</SPB>"));
		
		System.out.println(str.substring(str.indexOf("<SPB>")+str1.length(), str.indexOf("</SPB>")));
		System.out.println(str.substring(str.indexOf("</SPB>")+str2.length()));
	}
}
