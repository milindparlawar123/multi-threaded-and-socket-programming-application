package multiThreaded.workerThread;

import java.io.IOException;

import multiThreaded.constants.Constants;
import multiThreaded.primeNumber.PrimeNumber;
import multiThreaded.util.FileProcessor;
import multiThreaded.util.Results;
/**
 * @author Milind 
 * @author Smriti
 *below class will work as producer to add prime numbers to 
 *data structure which is present in result class  
 */
public class WorkerThread implements Runnable {

	private Results results;
	private FileProcessor fileProcessor;
	private static volatile int count = 0;

	public WorkerThread(Results results, FileProcessor fileProcessor) {
		super();
		this.results = results;

		this.fileProcessor = fileProcessor;
	}

	@Override
	public void run() {

		synchronized (this) {

			String numberStr = null;
			try {
				count++;
				while ((numberStr = this.fileProcessor.poll()) != null) {
					try {
						boolean isPrime = PrimeNumber.getInstance().isPrime(Integer.parseInt(numberStr));
						if (isPrime) {
							this.results.store(Integer.parseInt(numberStr));
						}
					} catch (NumberFormatException | InterruptedException e) {
						System.out.println(Constants.ERROR_INVALID_NUMBER);
						e.printStackTrace();
						System.exit(0);
					} finally {

					}
				}
				count--;
				Integer temp = null;
				try {
					if (count == 0)
						this.results.store(temp);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {

				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {

			}
		}
	}
}
