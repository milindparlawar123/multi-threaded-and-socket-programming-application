package multiThreaded.driver;

public class DataThread implements Runnable{
	Results results;
	public DataThread(Results results) {
		this.results=results;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//while(true)
			results.write();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
