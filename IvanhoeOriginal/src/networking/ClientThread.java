package networking;

<<<<<<< HEAD
public class ClientThread {

}
=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread{
	
	private Socket         socket   = null;
	private ClientApp      client   = null;
	private BufferedReader streamIn = null;
	private boolean done = false;
	
	public ClientThread(ClientApp client, Socket socket) {  
		this.client = client;
		this.socket = socket;
		this.open();  
		this.start();
	}
	
	public void open () {
		try {  
			streamIn  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    } catch(IOException ioe) {  
	    	System.out.println("Error getting input stream");
	    	System.out.println(ioe.getMessage());
			client.stop();
	    }
	}
	
	public void close () {
		done = true;
		try {  
			if (streamIn != null) streamIn.close();
			if (socket != null) socket.close();
			this.socket = null;
			this.streamIn = null;
		} catch(IOException ioe) { 
			System.out.println(ioe.getMessage());
	   }	
	}
	
	public void run() {
		System.out.println("Client Thread " + socket.getLocalPort() + " running.");
		while (!done) { 
			try {  
				client.handle(streamIn.readLine());
			} catch(IOException ioe) {  
				System.out.println(ioe.getMessage());
			}	
		}
	}	

}
>>>>>>> de8d1f9e8f8e3d7ed75589ef4c783a51535406de
