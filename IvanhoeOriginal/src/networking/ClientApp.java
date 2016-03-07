package networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp {
	
	private Socket socket 			 = null;
	private int    ID     			 = 0;
	private Thread thread            = null;
	private ClientThread   client    = null;
	private BufferedReader console   = null;
	private BufferedReader streamIn  = null;
	private BufferedWriter streamOut = null;
	
	
	public ClientApp(String serverName, int serverPort, String pName) {
		
		System.out.println("Establishing connection. Please wait ...");

		try {  
			this.socket = new Socket(serverName, serverPort);

		} catch(UnknownHostException uhe) {  
			System.err.println(": Unknown Host");
			System.out.println(uhe.getMessage());
		} catch(IOException ioe) {  
			System.out.println(": Unexpected exception");
			System.out.println(ioe.getMessage());  
		}
	}
	
	public String messageReceivedFromServer() {
		
		return "";
	}
	
	public int getID() {
		return ID;
	}
	
	public void handle(String msg) {
		
	}
	
	public void stop() {  
		try { 
			if (thread != null) thread = null;
			if (console != null) console.close();
			if (streamIn != null) streamIn.close();
			if (streamOut != null) streamOut.close();

			if (socket != null) socket.close();

			this.socket = null;
			this.console = null;
			this.streamIn = null;
			this.streamOut = null;    	  
		} catch(IOException ioe) {  
			System.out.println(ioe.getMessage());  
		}
		client.close();  
	}
}
