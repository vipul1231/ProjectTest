package org.com.testProject;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Regula_Expression {
	
	public static void main(String[] args)
	{
		try {
			System.out.println("1");
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress("127.0.0.5", 8085));
			System.out.println("2");
			
			String newData = "type=ACCOUNTTHRESHOLD,subscriberId=832312,balance=80,thresholdId=T1,TERMENS_CONTENT,TERM";
				
			System.out.println("Creating BUffer");
			ByteBuffer buf = ByteBuffer.allocate(100);
			System.out.println("Buffer allocatoon doen");
			buf.clear();
			System.out.println("Data send:" + newData.getBytes());
			buf.put(newData.getBytes());

			buf.flip();

			while(buf.hasRemaining()) {
				socketChannel.write(buf);
			}
			
	            // see if any message has been received
	            ByteBuffer bufferA = ByteBuffer.allocate(52);
	            int count = 0;
	            String message = "";
	            while ((count = socketChannel.read(bufferA)) > 0) {
	                // flip the buffer to start reading
	                bufferA.flip();
	                message += Charset.defaultCharset().decode(bufferA);
	 
	            }
	 
	            if (message.length() > 0) {
	                System.out.println(message);
	            }
			
			
			/*for(int i=0;i<buf1.limit();i++)
			{
				System.out.println(buf.);
			}*/
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
