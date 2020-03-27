package multiThreaded.driver;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {

	public static void main(String args[]) {
		ExecutorService executorService= Executors.newFixedThreadPool(3);
		Results results= new Results(5);
		FileProcessorObj filePr= new  FileProcessorObj(); 
		try {
			System.out.println("ccc "+filePr.getProce().poll());//testing
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 for(int i=0 ; i<3;i++) {
			Runnable r= new Read("thread "+i,results, filePr.getProce());
			executorService.execute(r);
			
		 }
		 for(int i=0 ; i<1;i++) {
				Runnable r= new DataThread(results);
				executorService.execute(r);
				
			 }
		 try {
			filePr.getProce().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("dddddff");
		 executorService.shutdown();
		 while(!executorService.isTerminated()) {
		 }
		 System.out.println("completed");
	}
}
