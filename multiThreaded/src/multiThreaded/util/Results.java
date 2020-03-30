package multiThreaded.util;

import java.util.Vector;

import multiThreaded.DataSender.DataSender;

public class Results {
	private Vector<Integer> list;
	private int size;
	private boolean isCompleted = false;

	public Results(int size) {
		this.list = new Vector<Integer>(size);
		this.size = size;
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
		// System.out.println("number " + number);
		this.list.add(number);
		Thread.sleep(1);
	}

	public synchronized void write() throws InterruptedException {
		while (isCompleted == false) {
			while (list.size() != size && !isCompleted)
				wait();

			// this.list.add(number);// write
			// System.out.println(this.list + " print");
			DataSender.writeToFile(this.list);
			Thread.sleep(1);
			this.list.removeAllElements();
			notifyAll();
			Thread.sleep(1);

		}
		if (isCompleted) {
			DataSender.writeToFile(this.list);
			// System.out.println(this.list + " print");

			this.list.removeAllElements();
		}
	}
}