package multiThreaded.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

import multiThreaded.constants.Constants;

/**
 * @author Milind
 * @author Smriti
 *below class is to store prime numbers in data structure and
 *this class will be shared by producer and consumer
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

	/**
	 * @param number all prime numbers will be stored in list
	 * below method will work as producer
	 * @throws InterruptedException
	 */
	public synchronized void store(Integer number) throws InterruptedException {

		if (number == null) {
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

	/**
	 * once list size is equal to size provided by input arg
	 * then write method will start sending to persister class
	 * and it will wait for consumer which is above store method
	 * to notify  
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public synchronized void write() throws InterruptedException, IOException {
		PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());

		while (isCompleted == false) {
			while (list.size() != size && !isCompleted)
				wait();

			int sizeOfVector = list.size();

			for (int i = 0; i < sizeOfVector; i++) {
				if (list.elementAt(i) == null) {
					pw.println(Constants.STOP);
				} else {
					pw.println(list.elementAt(i));
				}
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
				if (list.elementAt(i) == null) {
					pw.println(Constants.STOP);
				} else {
					pw.println(list.elementAt(i));
				}
			}
			pw.flush();

			this.list.removeAllElements();
		}
	}
}