package multiThreaded.driver;

import java.io.IOException;
import java.nio.file.InvalidPathException;

public class FileProcessorObj {
	private FileProcessor fileProcessor;
	public FileProcessorObj() {
		 try {
				this.fileProcessor = new FileProcessor("input.txt");
			} catch (InvalidPathException | SecurityException | IOException e) {
				e.printStackTrace();
			}
	}
	
	public FileProcessor getProce() {
		return this.fileProcessor;
	}
}
