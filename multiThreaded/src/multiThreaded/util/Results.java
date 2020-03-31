package multiThreaded.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

/**
 * @author Milind 
 * @author Smriti
 *
 * 
 */
public class Results {
	private Vector<Integer> list;
	
	public Vector<Integer> getList() {
		return list;
	}

	public void setList(Vector<Integer> list) {
		this.list = list;
	}

	private int size;
	private boolean isCompleted = false;
	
	Socket clientSocket;

	public Results(int size, Socket s) {
		this.list = new Vector<Integer>(size);
		this.size = size;
		
		clientSocket = s;
	}
	
	public synchronized void store(Integer number) throws InterruptedException {

		if (number == null) {
			System.out.println(" doneeee ");
			isCompleted = true;
			notifyAll();

		}

		while (list.size() == size) {
			notifyAll();
			wait();
		}
		this.list.add(number);
		Thread.sleep(1);
	}

	public synchronized void write() throws InterruptedException, IOException {
		PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
		
		
		while (isCompleted == false) {
			while (list.size() != size && !isCompleted)
				wait();
			
			//write to file as well
			int sizeOfVector = list.size();
			
			for (int i = 0; i < sizeOfVector; i++) {
				pw.println(list.elementAt(i));
			}
			pw.flush();
			
			Thread.sleep(1);
			this.list.removeAllElements();
			notifyAll();
			Thread.sleep(1);

		}
		if (isCompleted) {
			
			int sizeOfVector = list.size();
			for (int i = 0; i < sizeOfVector; i++) {
				pw.println(list.elementAt(i));
			}
			pw.flush();
			
			this.list.removeAllElements();
		}
	}
}