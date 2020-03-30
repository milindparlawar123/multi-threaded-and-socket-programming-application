package multiThreaded.DataSender;

import java.net.Socket;
import java.util.Vector;

import multiThreaded.persist.PersisterService;
import multiThreaded.util.Results;

public class DataSender implements Runnable {

	private Results results;
	private Socket socket;

	public DataSender() {
	}

	public DataSender(Socket clientSocket) {
		this.socket = clientSocket;
	}

	public DataSender(Results results) {
		this.results = results;
	}

	@Override
	public void run() {
		try {
			// while(true)
			this.results.write();
			// writeToFile();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		
	}

	public static void writeToFile(Vector<Integer> list) {
		System.out.println("in data sender " + list);

		// Sending the data to the server aka PersisterService
		PersisterService.echoNumbers(list);

	}

}
