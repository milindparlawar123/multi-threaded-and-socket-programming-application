package multiThreaded.driver;

import java.util.Vector;

public class Results {
	private Vector list;
	private int size;

	public Results(int size) {
		this.list = new Vector(size);
		this.size=size;
	}
	
	public synchronized void store(int number) throws InterruptedException {
        while (list.size() == size) 
        	wait();
        
		this.list.add(number);
		
		if (list.size() == size) 
        	notifyAll();
		
		//Thread.sleep(100);
		
	}
	
	public synchronized void write() throws InterruptedException {
		 while (list.size() != size) 
	        	wait();
		
		//this.list.add(number);// write 
		 System.out.println(this.list);
		
		this.list.removeAllElements();
		notifyAll();
		//Thread.sleep(100);
	}

}
