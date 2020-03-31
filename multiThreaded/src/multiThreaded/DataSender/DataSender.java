package multiThreaded.DataSender;

import java.net.Socket;
import multiThreaded.util.Results;

public class DataSender implements Runnable {

	private Results results;
	public Socket socket;
	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public DataSender(Socket clientSocket) {
		socket = clientSocket;
	}

	public DataSender(Results results) {
		this.results = results;
	}

	@Override
	public void run() {
		try {
			this.results.write();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}	
	}
}
