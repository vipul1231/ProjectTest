package tcpServer;

import java.util.concurrent.Callable;

public class CallabeExample implements Callable<Double>{

	@Override
	public Double call() throws Exception {
		// TODO Auto-generated method stub
		
		//Thread.sleep(15000);
		String str = "This is from Callable Task Run " + System.currentTimeMillis();
		return 10.9;
	}
	

}
