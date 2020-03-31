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

import multiThreaded.constants.Constants;
import multiThreaded.validator.PersistValidator;

/**
 * @author Milind 
 * @author Smriti
 *
 * PersisterService is the server which is constantly listening for data
 * from the client DataSender on the port number specified.
 * 
 */
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

		System.out.println(Constants.SERVER_LISTENING + port);

		String hostname;
		
		PrintWriter pw = null;

		try {
			// create the serverSocket and bind it to port #
			serversocket = new ServerSocket(port);

			hostname = InetAddress.getLocalHost().getCanonicalHostName();

			System.out.println(Constants.HOSTNAME + hostname);
			System.out.println(Constants.PORTNAME + port + "\n");
			while (true) {

				Socket clientSocket = serversocket.accept();
				InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
				BufferedReader bf = new BufferedReader(in);

				pw = new PrintWriter(new FileWriter(args[1]));
				
				String str = null;

				while ((str = bf.readLine()) != null) {

					if(str.equals(Constants.STOP)){
						try {
							pw.close();
							serversocket.close();
						} catch (IOException e) {
							System.out.println(Constants.ERROR_CLOSING_SOCKET + e.getMessage());
						}
						System.exit(0);
					}
					pw.println(str);
					pw.flush();
				}
			}

		} catch (UnknownHostException e) {
			System.out.println(Constants.ERROR_UNKNOWN_HOST + e.getMessage());
		} catch (IOException e) {
			System.out.println(Constants.ERROR_CONNECTING_SERVER + e.getMessage());
		}

		finally {
			try {
				pw.close();
				serversocket.close();
			} catch (IOException e) {
				System.out.println(Constants.ERROR_CLOSING_SOCKET  + e.getMessage());
			}
		}

	}

}
