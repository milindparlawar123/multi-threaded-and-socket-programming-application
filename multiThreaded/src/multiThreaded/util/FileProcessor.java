package multiThreaded.util;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;

import java.util.List;

import javax.annotation.processing.FilerException;

/**
 * @author Milind and Smriti 
 *below class is to read data from input file
 */
public final class FileProcessor {
	private BufferedReader reader;
	private String line;

	public FileProcessor(String inputFilePath)
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

		if (!Files.exists(Paths.get(inputFilePath))) {
			throw new FileNotFoundException("invalid input file or input file in incorrect location");
		}

		reader = new BufferedReader(new FileReader(new File(inputFilePath)));
		line = reader.readLine();
		if(line == null) {
			System.out.println("file is empty");
			System.exit(0);
		}
	}

	/**
	 * @return it will return next line from input file
	 * @throws IOException
	 * method is synchronized, at once only one thread can read data
	 */
	public synchronized String poll() throws IOException {
		if (null == line)
			return null;

		String newValue = line.trim();
		line = reader.readLine();
		return newValue;
	}

	/**
	 * @throws IOException
	 * below method is to close the file
	 */
	public void close() throws IOException {
		try {
			reader.close();
			line = null;
		} catch (IOException e) {
			throw new IOException("failed to close file", e);
		} finally {

		}
	}
}
