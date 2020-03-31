package multiThreaded.driver;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.InvalidPathException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import multiThreaded.DataSender.DataSender;
import multiThreaded.util.FileProcessor;
import multiThreaded.util.Results;
import multiThreaded.validator.PrimeDetectorValidator;
import multiThreaded.workerThread.WorkerThread;

/**
 * @author Milind 
 * @author Smriti
 *
 * 
 */
public class PrimeDetector {

	public static void main(String[] args) {

		try {
			new PrimeDetectorValidator(args.length, args);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {

		}
		Socket socket;
		Results results = null;
		FileProcessor filePr = null;
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		try {
			socket = new Socket(args[3], Integer.parseInt(args[4]));
			
			results = new Results(5,socket);
			
			filePr = new FileProcessor("input.txt");
		} catch (NumberFormatException e2) {
			e2.printStackTrace();
		} catch (UnknownHostException e2) {
			System.out.println(e2.getMessage());
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (InvalidPathException | SecurityException e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < 1; i++) {
			Runnable r = new WorkerThread("thread " + i, results, filePr);
			executorService.execute(r);
		}
		for (int i = 0; i < 1; i++) {
			Runnable r = new DataSender(results);
			executorService.execute(r);
		}

		executorService.shutdown();
		while (!executorService.isTerminated()) {
		}
		System.out.println("completed");
		try {
			filePr.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {

		}
	}
}
