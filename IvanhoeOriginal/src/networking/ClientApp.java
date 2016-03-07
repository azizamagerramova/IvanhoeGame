package networking;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp {
	
	private Socket socket = null;
	private int    ID     = 0;
	
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
}
