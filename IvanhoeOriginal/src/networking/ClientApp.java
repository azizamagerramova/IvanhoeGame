package networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientApp implements Runnable {

	private int ID = 0;
	private Socket socket            = null;
	private Thread thread            = null;
	private ClientThread   client    = null;
	private BufferedReader console   = null;
	private BufferedReader streamIn  = null;
	private BufferedWriter streamOut = null;
	

	public ClientApp (String serverName, int serverPort, String pName) {  
		
		System.out.println("Establishing connection. Please wait ...");
		
		try {  
			this.socket = new Socket(serverName, serverPort);
			this.ID = socket.getLocalPort();
			System.out.println(ID + ": Connected to server: " + socket.getInetAddress());
			System.out.println(ID + ": Connected to portid: " + socket.getLocalPort());
			
			this.start();
			/* Send player name to the server */
			send("nameOfPlayer " + pName);
			
		} catch(UnknownHostException uhe) {  
			System.err.println(ID + ": Unknown Host");
			System.out.println(uhe.getMessage());
		} catch(IOException ioe) {  
			System.out.println(ID + ": Unexpected exception");
			System.out.println(ioe.getMessage());  
		}
	}

	public int getID () {
		return this.ID;
	}
	
	public String messageReceivedFromServer() throws IOException {
		String sentence = streamIn.readLine();
		
		return sentence;
	}

	public void start() throws IOException {  
		try {
			console	  = new BufferedReader(new InputStreamReader(System.in));
			streamIn  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			streamOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			if (thread == null) {  
				client = new ClientThread(this, socket);
				thread = new Thread(this);                   
				thread.start();
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());  
			throw ioe;
		}
	}

	/** The server processes the messages and passes it to the client to send it */
	public void send(String input) {
		
		try {
			streamOut.write(input + "\n");
			streamOut.flush();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	public void run() { 
		System.out.println("\n" + ID + ": Client Started...\n");
	}

	
	public void handle (String msg) throws IOException {
		System.out.println(msg);
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