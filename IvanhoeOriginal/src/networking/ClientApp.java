package networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import config.Config;
import controller.Controller;

public class ClientApp implements Runnable {

	private int ID = 0;
	private Socket socket            = null;
	private Thread thread            = null;
	private ClientThread   client    = null;
	private BufferedReader console   = null;
	private BufferedReader streamIn  = null;
	private BufferedWriter streamOut = null;
	Controller controller;

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

			controller = new Controller(Config.GAME_NAME, this);

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

		String[] splitIt = msg.split(" ");

		if (msg.startsWith("Names of players")) {
			int    numberOfPlayersCurrently = Integer.parseInt(splitIt[3]);
			controller.updatePlayers(msg, numberOfPlayersCurrently);
			controller.setVisible(true);
		}

		if(msg.equals("Pick a token")) {
			controller.DisplayPickAToken();
		}

		if (msg.startsWith("token")) {

			String tokenColor = splitIt[1];
			controller.popUpTokenGenerated(tokenColor);

			/* send a message to the server that a token was finally generated after pop up */
			send("token was generated");
		}

		if(msg.equals("now you can distribute cards")) {
			controller.enableButtonForDistributeCard();
		}

		if(msg.equals("You have to pick a card first")) {
			controller.popUp(msg);
		}

		if (msg.startsWith("Hand of card")) {
			controller.splitCardsAndSetIt(msg);
			System.out.println(msg);
		}

		if(msg.startsWith("tournamentNumber1")) {

			String tournamentNumber = splitIt[1];
			controller.setTournamentNumber(tournamentNumber);
		}

		if(msg.equals("Now everyone got a card set your self invisible")) {
			controller.disableButtonForDistributeCard();
			send("who starts the game now?");
		}

		if(msg.equals("I got you. Button will now be enabled")) {
			controller.enableWithDrawButtonForAllPlayers();
			send("requesting start game");
		}

		if(msg.startsWith("player Names")) {
			if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 3) {

				String pName1 = splitIt[2];
				String pName2 = splitIt[3];
				String pName3 = splitIt[4];

				controller.setvisibilityForPlayerName(pName1, pName2, pName3);
			}
			if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 2) {

				String pName1 = splitIt[2];
				String pName2 = splitIt[3];

				controller.setvisibilityFor2PlayerName(pName1, pName2);
			}
			if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 4) {

				String pName1 = splitIt[2];
				String pName2 = splitIt[3];
				String pName3 = splitIt[4];
				String pName4 = splitIt[5];

				controller.setvisibilityFor4PlayerName(pName1, pName2, pName3, pName4);
			}

			if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 5) {

				String pName1 = splitIt[2];
				String pName2 = splitIt[3];
				String pName3 = splitIt[4];
				String pName4 = splitIt[5];
				String pName5 = splitIt[6];

				controller.setvisibilityFor5PlayerName(pName1, pName2, pName3, pName4, pName5);
			}
		}

		if(msg.equals("choose the tournament colour")) {
			controller.enableTournamentColourButton();
		}

		if(msg.equals("okay I will serve you a list of colours")) {
			controller.popUpMenuToChooseTournamentColor();
		}

		if(msg.startsWith("tournament colour is")) {
			String tournamentColour = splitIt[3];

			controller.popUpForTournamentColour(tournamentColour);
			send("enable withdraw button for everyone");
		}

		if(msg.startsWith("Left")) {
			controller.withdraw(splitIt[1]);
		}
		if (msg.startsWith("I left. Disable all my buttons")) {
			controller.disableAllButtons();
		}

		if(msg.startsWith("This player withdrew from the")) {

			String nameOfPlayerWhoWithdrew = splitIt[5];
			controller.disableStuffs(nameOfPlayerWhoWithdrew);
		}

		if(msg.equals("You cannot withdraw")) {
			controller.popUpNotYourTurn();
		}

		if (msg.equals("Wrong Colour")) {
			controller.popUpWrongColour();
		}

		if (msg.equals("Draw a card")) {
			controller.enablePickCard();
		}

		if (msg.contains("Your new card is" )) {
			controller.addNewCard(splitIt[5], splitIt[0]);
			controller.popUpNewCard(splitIt[5]);

		}

		if(msg.equals("as a winner now you can distribute cards")) {
			controller.enableButtonForDistributeCard();
		}

		if (msg.startsWith("Someone got a new card ")) {
			controller.AddCardToOtherDisplays(splitIt[5]);
		}

		if(msg.equals("This is a purple tournament choose your colour")) {
			String chosenColour = controller.chosenTokenColour();
			send("The winner of the purple tournament has chosen a color " + chosenColour);
		}

		if(msg.startsWith("Server is done adding token to my list of tokens")) {

			String playerTokenColour = splitIt[10];
			String playerWhoWon        = splitIt[11];

			System.out.println(playerTokenColour);
			System.out.println(playerWhoWon);

			controller.setTokenVisibleForPlayerWhoWon(playerWhoWon, playerTokenColour.toLowerCase());		
			send("Tournament done!");
		}

		if(msg.startsWith("make token visible to other players")) {
			String playerTokenColour = splitIt[6];
			String playerWhoWon        = splitIt[7];

			controller.setTokenVisibleForPlayerWhoWon(playerWhoWon, playerTokenColour.toLowerCase());	
		}

		if(msg.startsWith("players who withdrew we have to enable")) {

			controller.setVisibilityForWithDrawnPlayersToTrue(msg);

		}
		if(msg.equals("Choose colour of tournament")) {
			controller.popUpMenuToChooseTournamentColorAfterTournament();
		}


		if(msg.startsWith("players who withdrew we have to enable")) {
			controller.setVisibilityForWithDrawnPlayersToTrue(msg);

		}
		if (msg.equals("Enable hand of cards")) {
			controller.EnableHandForEveryone();
		}

		if (msg.startsWith("Give up a token")) {
			controller.popUpMenuToRemoveToken(splitIt[4], "You have to give up one of your tokens. Choose a token to give up" );

		}

		if (msg.startsWith("Remove a token")) {
			String TokenColorToRemove = splitIt[3];
			String playerName = splitIt[5];
			controller.removeTokenAllDisplays(playerName, TokenColorToRemove);
		}



		if(msg.startsWith("you are the winner of this tournament")) {
			String playerNameWhoWon = splitIt[7];

			controller.popUpToNotifyWinnerOfTheTournament(playerNameWhoWon);
		}


		if(msg.equals("you already have this token")) {
			controller.popUpToNotifyAlreadyHaveToken();
			send("Tournament done!");
		}

		if (msg.startsWith("Update display " )) {
			if (splitIt.length == 4) {
				System.out.println("Just one card. Update");
				controller.updateDisplay(splitIt[2], splitIt[3]);
			}
			if (splitIt.length == 5) {
				System.out.println("more than one card update and this cards are " + " " + splitIt[2] + " " + splitIt[3]);
				controller.updateDisplay(splitIt[2], splitIt[3], splitIt[4]);
			}
		}

		if (msg.startsWith("Update score")){
			controller.updateScore(splitIt[2], splitIt[3]);
		}
		if (msg.startsWith("Disable")) {
			controller.disableCardPlayed(splitIt[1], splitIt[2]);
		}

		if (msg.equals("Enable done")) {
			controller.enableDone();
		}

		if (msg.equals("Your turn to play")) {
			System.out.println("It's your turn to play");
			controller.popUp(msg);
		}

		if (msg.startsWith("You have to withdraw")) {
			controller.popUp(msg);
		}

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