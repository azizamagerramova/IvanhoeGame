package networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;
import java.util.Map.Entry;

import config.Config;

public class ServerApp implements Runnable {
	
	int                                       clientCount = 0;
	private Thread                            thread = null;
	private ServerSocket                      server = null;
	private HashMap<Integer, ServerThread>    clients;
	
	
	public boolean 							  connected = false;
	
	public ServerApp(int port) {
		try {
			
			System.out.println("Binding to port " + port + ", please wait  ...");
			System.out.println("Binding to port " + port);
			/**
			 * I use a HashMap to keep track of the client connections and their
			 * related thread
			 */
			clients = new HashMap<Integer, ServerThread>();

			/** Establish the servers main port that it will listen on */
			server = new ServerSocket(port);
			connected = true;
			/**
			 * Allows a ServerSocket to bind to the same address without raising
			 * an "already bind exception"
			 */
			server.setReuseAddress(true);
			start();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	/** Now we start the servers main thread */
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
			System.out.println(String.format("Server started: %s %d", server,thread.getId()));
		}
	}
	
	public void resetPort() throws SocketException {
		server.setReuseAddress(true);
	}

	/** The main server thread starts and is listening for clients to connect */
	public void run() {
		while (thread != null) {
			try {
				addThread(server.accept());
			} catch (IOException e) {				
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
	}

	/** 
	 * Client connection is accepted and now we need to handle it and register it 
	 * and with the server | HashTable 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 **/
	private void addThread(Socket socket) throws IOException, ClassNotFoundException {
		System.out.println("Client accepted" + socket);
		ServerThread serverThread = null;
		if (clientCount < Config.NUMBER_OF_PLAYERS_SPECIFIED) {
			try {
				/** Create a separate server thread for each client */
				serverThread = new ServerThread(this, socket);
				/** Open and start the thread */
				serverThread.open();
				serverThread.start();
				clients.put(serverThread.getID(), serverThread);
				this.clientCount++;
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} else {
			socket.close();
			System.out.println("Client Tried to connect" + socket );
			System.out.println("Client refused: maximum number of player reached");
		}
	}
	
	
	public synchronized void handle(int ID, String input) {
		
		System.out.println(input);
	}
	
	/* Send message to all players */
	public void sendMessageToAllClients(String input) {
		for (ServerThread to : clients.values()) {
			to.send(String.format("%s\n", input));
		}
	}
	
	/* Send message to only one player */
	public void sendToOneClient(String input, int ID) {
		ServerThread from = clients.get(ID);
		from.send(String.format("%s\n", input));
	}

	/** Try and shutdown the client cleanly */
	public synchronized void remove(int ID) {
		if (clients.containsKey(ID)) {
			ServerThread toTerminate = clients.get(ID);
			clients.remove(ID);
			clientCount--;

			toTerminate.close();
			toTerminate = null;
		}
	}

	/** Shutdown the server cleanly */
	public void shutdown() {
		Set<Integer> keys = clients.keySet();

		if (thread != null) {
			thread = null;
		}

		try {
			for (Integer key : keys) {
				clients.get(key).close();
				clients.put(key, null);
			}
			clients.clear();
			server.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Server Shutdown cleanly" + server );
	}
	
}