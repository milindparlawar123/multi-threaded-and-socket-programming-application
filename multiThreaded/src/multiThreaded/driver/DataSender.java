package multiThreaded.driver;

import java.io.IOException;
import java.net.Socket;

public class DataSender implements Runnable{
	
	Results results;
	Socket socket;
	
	public DataSender(Socket clientSocket) {
		socket = clientSocket;
	}
	
	@Override
	public void run() {
		try {
			//while(true)
			writeToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	static void writeToFile() {
		// TODO Auto-generated method stub
		
	}

}
