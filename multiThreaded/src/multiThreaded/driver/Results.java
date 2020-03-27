package multiThreaded.driver;

import java.util.Vector;

public class Results {
	private Vector list;
	private int size;

	public Results(int size) {
		this.list = new Vector(size);
		this.size = size;
	}

	public synchronized void store(int number) throws InterruptedException {
		notifyAll();
		while (list.size() == size)
			wait();

		this.list.add(number);


	}

	public synchronized void write() throws InterruptedException {
		while (list.size() != size)
			wait();

		// this.list.add(number);// write
		System.out.println(this.list);

		this.list.removeAllElements();
		notifyAll();
		
	}

}