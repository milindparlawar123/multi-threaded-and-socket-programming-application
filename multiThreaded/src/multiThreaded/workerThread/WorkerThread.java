package multiThreaded.workerThread;

import java.io.IOException;

import multiThreaded.primeNumber.PrimeNumber;
import multiThreaded.util.FileProcessor;
import multiThreaded.util.Results;

public class WorkerThread implements Runnable {

	private String name;
	private Results results;
	private FileProcessor fileProcessor;
	private static volatile int count = 0;

	public WorkerThread(String name, Results results, FileProcessor fileProcessor) {
		super();
		this.name = name;
		this.results = results;
		// System.out.println(" on");

		this.fileProcessor = fileProcessor;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		synchronized (this) {

			String numberStr = null;
			try {
				count++;
				// System.out.println("count start"+ count);
				while ((numberStr = this.fileProcessor.poll()) != null) {
					try {

						// System.out.println("milind " +numberStr + " " + this.name);
						boolean isPrime = PrimeNumber.getInstance().isPrime(Integer.parseInt(numberStr));
						if (isPrime) {
							// System.out.println("mil "+numberStr);
							this.results.store(Integer.parseInt(numberStr));
						}
					} catch (NumberFormatException | InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("Line in the input file is not an integer");
						e.printStackTrace();
						System.exit(0);
					} finally {

					}

				}
				count--;
				// System.out.println("count end"+ count);
				Integer temp = null;
				try {
					if (count == 0)
						this.results.store(temp);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

			}
		}

	}

}
