package multiThreaded.persist;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import multiThreaded.validator.PersistValidator;

public class PersisterService {

	public static ServerSocket serversocket;

	public static void main(String[] args) {

		try {
			new PersistValidator(args.length, args);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		int port = Integer.parseInt(args[0]);

		System.out.println("Server started.\nListening for connections on port : " + port);

		String hostname;
		
		PrintWriter pw = null;

		try {
			// create the serverSocket and bind it to port #
			serversocket = new ServerSocket(port);

			hostname = InetAddress.getLocalHost().getCanonicalHostName();

			System.out.println("Hostname is: " + hostname);
			System.out.println("Port number is: " + port + "\n");
			while (true) {

				Socket clientSocket = serversocket.accept();
				InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
				BufferedReader bf = new BufferedReader(in);

				pw = new PrintWriter(new FileWriter("output.txt"));
				
				String str = null;

				while ((str = bf.readLine()) != null) {
					System.out.println("str= " + str);
					pw.println(str);
					pw.flush();
				}
				
				// DataSender acceptingServerReq = new DataSender(clientSocket);

				// Thread th = new Thread(acceptingServerReq);
				// th.start();
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error connecting to the server! Please try again!\n" + e.getMessage());
		}

		finally {
			try {
				pw.close();
				serversocket.close();
			} catch (IOException e) {
				System.out.println("Error closing server socket!\n" + e.getMessage());
			}
		}

	}

}
