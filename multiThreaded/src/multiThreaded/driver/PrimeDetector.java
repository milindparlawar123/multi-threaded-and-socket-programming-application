package multiThreaded.driver;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.InvalidPathException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import multiThreaded.DataSender.DataSender;
import multiThreaded.constants.Constants;
import multiThreaded.util.FileProcessor;
import multiThreaded.util.Results;
import multiThreaded.validator.PrimeDetectorValidator;
import multiThreaded.workerThread.WorkerThread;

/**
 * @author Milind 
 * @author Smriti
 *
 * PrimeDetector is to poll number from input file, check number whether it is prime
 * if yes, then send number to PersisterService 
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
		Socket socket=null;;
		Results results = null;
		FileProcessor filePr = null;
		ExecutorService executorService = Executors.newFixedThreadPool(Integer.parseInt(args[1])+1);
		try {
			try {
				socket = new Socket(args[3], Integer.parseInt(args[4]));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(Constants.ERROR_CLIENT);
				e.printStackTrace();
				System.exit(0);
			}
			
			results = new Results(Integer.parseInt(args[2]),socket);
			
			filePr = new FileProcessor(args[0]);
		} catch (NumberFormatException e2) {
			e2.printStackTrace();
		} catch (UnknownHostException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (InvalidPathException | SecurityException e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < Integer.parseInt(args[1]); i++) {
			Runnable r = new WorkerThread(results, filePr);
			executorService.execute(r);
		}
		for (int i = 0; i < 1; i++) {
			Runnable r = new DataSender(results);
			executorService.execute(r);
		}

		executorService.shutdown();
		while (!executorService.isTerminated()) {
		}
		//System.out.println("completed");
		try {
			filePr.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {

		}
	}
}
