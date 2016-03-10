package networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.HashMap;

public class ServerApp {
	
	public boolean connected    = false;
	private ServerSocket server = null;
	
	public ServerApp(int port) {
		
		try {

			/** Establish the servers main port that it will listen on */
			server    = new ServerSocket(port);
			connected = true;
			
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
	public synchronized void handle(String input, int ID) {
		
	}
	
	public void resetPort() {
		
	}
	
	public void remove(int ID) {
		
	}
	
	public void sendToOneClient(String msg, int ID) {
		
	}
}