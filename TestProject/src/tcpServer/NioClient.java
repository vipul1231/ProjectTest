package tcpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {

	public static void mian(String[] args)
	{
		
		try {
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress("127.0.0.5", 8084));
			
			String newData = "New String to write to file..." + System.currentTimeMillis();

			ByteBuffer buf = ByteBuffer.allocate(48);
			buf.clear();
			buf.put(newData.getBytes());

			buf.flip();

			while(buf.hasRemaining()) {
				socketChannel.write(buf);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
