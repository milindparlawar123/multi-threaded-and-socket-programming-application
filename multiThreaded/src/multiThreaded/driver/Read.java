package multiThreaded.driver;

import java.io.IOException;
import java.nio.file.InvalidPathException;

import multiThreaded.util.FileProcessor;

public class Read implements Runnable {

	private String name;
	private Results results;
	private FileProcessor fileProcessor;
	public Read(String name, Results results, FileProcessor fileProcessor) {
		super();
		this.name = name;
		this.results=results;
		// System.out.println(" on");

this.fileProcessor=fileProcessor;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		synchronized (this){
			
		 String numberStr= null;
		try {
			while ((numberStr = this.fileProcessor.poll()) != null){
				try {
					
					
					//System.out.println("milind " +numberStr + " " + this.name);
				boolean isPrime =	PrimeNumber.getInstance().isPrime(Integer.parseInt(numberStr));
				if(isPrime) {
					//System.out.println("mil "+numberStr);
					this.results.store(Integer.parseInt(numberStr));
				}
				} catch (NumberFormatException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			Integer temp=null;
			try {
				this.results.store(temp);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}

}
