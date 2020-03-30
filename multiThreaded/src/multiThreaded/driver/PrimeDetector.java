package multiThreaded.driver;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import multiThreaded.DataSender.DataSender;
import multiThreaded.util.FileProcessor;
import multiThreaded.util.Results;
import multiThreaded.workerThread.WorkerThread;

public class PrimeDetector {

	public static void main(String[] args) {
		
		try {
			//new PrimeDetectorValidator(args.length, args);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {

		}
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		Results results = new Results(5);
		FileProcessor filePr=null;;
		try {
			filePr = new FileProcessor("input.txt");
		} catch (InvalidPathException | SecurityException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for (int i = 0; i < 3; i++) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
