package multiThreaded.persist;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

import multiThreaded.DataSender.DataSender;
import multiThreaded.validator.PersistValidaor;

public class PersisterService {

	public static ServerSocket serversocket;

	public static void main(String[] args) {

		try {
			new PersistValidaor(args.length, args);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {

		}

		int port = Integer.parseInt(args[0]);
		System.out.println("port = " + port);

		String outputFileName = args[1];
		System.out.println(outputFileName);

		// final int REQUIRED_NUMBER_OF_ARGS = 2;

		/*
		 * if((args.length != REQUIRED_NUMBER_OF_ARGS) || args[0].equals("$port") ||
		 * args[1].equals("$outputFileName")) { System.err.
		 * printf("Error: Incorrect number of arguments. Program accepts %d arguments.",
		 * REQUIRED_NUMBER_OF_ARGS); System.exit(0); }
		 */

		System.out.println("Server started.\nListening for connections on port : " + port + "\n");

		String hostname;

		try {
			// create the serverSocket and bind it to port #
			serversocket = new ServerSocket(port);

			hostname = InetAddress.getLocalHost().getCanonicalHostName();

			System.out.println("Hostname is: " + hostname);
			System.out.println("Port number is - " + port);
			while (true) {
				Socket clientSocket = serversocket.accept();

				DataSender acceptingServerReq = new DataSender(clientSocket);

				Thread th = new Thread(acceptingServerReq);
				th.start();
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error connecting to the server! Please try again!\n" + e.getMessage());
		}

		finally {
			try {
				serversocket.close();
			} catch (IOException e) {
				System.out.println("Error closing server socket!\n" + e.getMessage());
			}
		}

	}

	public static void echoNumbers(Vector<Integer> list) {
		System.out.println("gonna write numbers to file.");

		int sizeOfVector = list.size();

		try {
			PrintWriter pw = new PrintWriter(new FileWriter("output.txt", true));
			for (int i = 0; i < sizeOfVector; i++) {
				// System.out.println(list.elementAt(i));
				pw.println(list.elementAt(i));
				// System.out.println("after pw");
			}
			pw.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		/*
		 * finally { pw.close(); }
		 */
	}

}
