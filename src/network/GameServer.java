package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class GameServer {
	private ServerSocket serverSocket;
	private static final int PORT_FREE_ANY = 0;	// based on ServerSocket constructor
	private static final int NUM_PLAYERS = 4; 	// TODO: var num players

	private static int clientId = 0;

	private HashMap<Integer, WorkerThread> clients;

	public GameServer() {
		clients = new HashMap<Integer, WorkerThread>();

		try {
			serverSocket = new ServerSocket(PORT_FREE_ANY);
		} catch (IOException ioe) {
			System.err.println("Could not create server!");
			ioe.printStackTrace();
			System.exit(1);
		}

		int count = 0;
		while (count < NUM_PLAYERS) {
			try {
				Socket clientSocket = serverSocket.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

				// send client id


				WorkerThread worker = new WorkerThread(clientId, in, out);
				clients.put(clientId, worker);

				clientId++;
				worker.start();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		}
	}

	// only handle 1 message at a time
	private synchronized void handleClientMsg(int clientId, String msg, BufferedWriter clientOut) throws Exception {
		Transaction transaction = Transaction.deserialize(msg);
	}

	private class WorkerThread extends Thread {
		private int clientId;
		private BufferedReader in;
		private BufferedWriter out;

		private WorkerThread(int clientId, BufferedReader in, BufferedWriter out) {
			this.clientId = clientId;
			this.in = in;
			this.out = out;
		}

		@Override
		public void run() {
			try {
				while (true) {
					String msg = in.readLine();
					handleClientMsg(clientId, msg, out);
				}
			} catch (Exception e) {
				System.err.println("Error when processing msg from client " + clientId);
				e.printStackTrace();
			}

		}
	}
}

