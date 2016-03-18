package networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;
import java.util.Map.Entry;

import config.Config;
import entity.Player;
import ruleEngine.GameRuleEngine;

public class ServerApp implements Runnable {
	private int 										checkNames	= 0;
	private int                                       	clientCount = 0;
	private int 										holdWinnerOfPreviousTournamentKey = 0;
	private String 										previousTournamentColour = "";
	private Thread                            			thread = null;
	private ServerSocket                      			server = null;
	private HashMap<Integer, ServerThread>    			clients;
	public  String 										playerWhoWonTheCurrentTournament = "";
	private HashMap<Integer, Player>		  			clientsToPlayers;
	private ArrayList<Player>				 			oldPlayers = new ArrayList<Player>(Config.NUMBER_OF_PLAYERS_SPECIFIED);
	private ArrayList<Player> 				  			players      = new ArrayList<Player>(Config.NUMBER_OF_PLAYERS_SPECIFIED);
	private GameRuleEngine    				  			ruleEngine;
	public  int 										playerWhoWonCurrentTournamentKey = 0;
	private ArrayList<Player>				  			withdrawnPlayers =  new ArrayList<Player>(Config.NUMBER_OF_PLAYERS_SPECIFIED);
	private List<String>					  			tokensForTwoPlayers       = new ArrayList<String>(Arrays.asList("purple", "green"));
	private List<String> 					  			tokensForFivePlayers       = new ArrayList<String>(Arrays.asList("red", "purple", "green", "yellow", "blue"));
	private List<String> 					  			tokensForThreePlayers      = new ArrayList<String>(Arrays.asList("red", "purple", "green"));
	private List<String> 					  			tokensForFourPlayers       = new ArrayList<String>(Arrays.asList("red", "purple", "green", "yellow"));
	private ArrayList<String>				  			deckOfColorAndSupporters = new ArrayList<String>(Arrays.asList("color_card_purple_3_1","color_card_purple_3_2", "color_card_purple_3_3","color_card_purple_3_4",
			"color_card_purple_4_1", "color_card_purple_4_2", "color_card_purple_4_3", "color_card_purple_4_4", "color_card_purple_5_1", "color_card_purple_5_2", "color_card_purple_5_3", "color_card_purple_5_4", "color_card_purple_7_1", "color_card_purple_7_2", 
			"color_card_red_3_1", "color_card_red_3_2", "color_card_red_3_3", "color_card_red_3_4", "color_card_red_3_5", "color_card_red_3_6","color_card_red_4_1", "color_card_red_4_2", "color_card_red_4_3", "color_card_red_4_4", "color_card_red_4_5", "color_card_red_4_6", "color_card_red_5_1", "color_card_red_5_2",
			"color_card_blue_2_1","color_card_blue_2_2","color_card_blue_2_3", "color_card_blue_2_4", "color_card_blue_3_1","color_card_blue_3_2", "color_card_blue_3_3", "color_card_blue_3_4", "color_card_blue_4_1","color_card_blue_4_2", "color_card_blue_4_3", "color_card_blue_4_4", "color_card_blue_5_1",  "color_card_blue_5_2", 
			"color_card_yellow_2_1", "color_card_yellow_2_2", "color_card_yellow_2_3", "color_card_yellow_2_4", "color_card_yellow_3_1", "color_card_yellow_3_2", "color_card_yellow_3_3", "color_card_yellow_3_4", "color_card_yellow_3_5", "color_card_yellow_3_6", "color_card_yellow_3_7", "color_card_yellow_3_8", "color_card_yellow_4_1", "color_card_yellow_4_2",
			"color_card_green_1_1","color_card_green_1_2","color_card_green_1_3","color_card_green_1_4","color_card_green_1_5","color_card_green_1_6","color_card_green_1_7","color_card_green_1_8","color_card_green_1_9","color_card_green_1_10", "color_card_green_1_11", "color_card_green_1_12", "color_card_green_1_13", "color_card_green_1_14", 
			"supporter_card_2_1", "supporter_card_2_2", "supporter_card_2_3", "supporter_card_2_4", "supporter_card_2_5", "supporter_card_2_6", "supporter_card_2_7", "supporter_card_2_8",
			"supporter_card_3_1", "supporter_card_3_2", "supporter_card_3_3", "supporter_card_3_4", "supporter_card_3_5", "supporter_card_3_6", "supporter_card_3_7", "supporter_card_3_8",
			"supporter_card_6_1", "supporter_card_6_2","supporter_card_6_3", "supporter_card_6_4"));


	/* NOTE: This was added for test to test when you play a maiden card */
	/*private ArrayList<String>				 deckOFSupporters =  new ArrayList<String>(Arrays.asList("color_card_purple_3_1","color_card_purple_3_2", "color_card_purple_3_3","color_card_purple_3_4",
			"supporter_card_6_1", "supporter_card_6_2","supporter_card_6_3", "supporter_card_6_4", "color_card_blue_2_4", "color_card_blue_3_1","color_card_blue_3_2", "color_card_blue_3_3", "color_card_blue_3_4", "color_card_blue_4_1","color_card_blue_4_2", "color_card_blue_4_3", "color_card_blue_4_4", "color_card_blue_5_1",  "color_card_blue_5_2", 
			"color_card_yellow_2_1", "color_card_yellow_2_2", "color_card_yellow_2_3", "color_card_yellow_2_4", "color_card_yellow_3_1", "color_card_yellow_3_2", "color_card_yellow_3_3", "color_card_yellow_3_4", "color_card_yellow_3_5", "color_card_yellow_3_6", "color_card_yellow_3_7", "color_card_yellow_3_8", "color_card_yellow_4_1", "color_card_yellow_4_2",
			"supporter_card_6_1", "supporter_card_6_2","supporter_card_6_3", "supporter_card_6_4" ,"supporter_card_6_1", "supporter_card_6_2","supporter_card_6_3", "supporter_card_6_4","color_card_green_1_10", "color_card_green_1_11", "color_card_green_1_12", "color_card_green_1_13", "color_card_green_1_14", 
			"supporter_card_2_1", "supporter_card_2_2", "supporter_card_2_3", "supporter_card_2_4", "supporter_card_2_5", "supporter_card_2_6", "supporter_card_2_7", "supporter_card_2_8",
			"supporter_card_3_1", "supporter_card_3_2", "supporter_card_3_3", "supporter_card_3_4", "supporter_card_3_5", "supporter_card_3_6", "supporter_card_3_7", "supporter_card_3_8",
			"supporter_card_6_1", "supporter_card_6_2","supporter_card_6_3", "supporter_card_6_4"));*/

	private ArrayList<String>				  			winningTokens = new ArrayList<String>(Arrays.asList("red", "purple", "green", "yellow", "blue",
			"red","purple", "green", "yellow", "blue",
			"red", "purple", "green", "yellow", "blue", 
			"red", "purple", "green", "yellow", "blue",  
			"red", "purple", "green", "yellow", "blue"));
	private ArrayList<String>				  			discardPile = new ArrayList<String>();
	private ArrayList<String>                 			eightCardDealedToEachPlayer;
	private int 							  			countPlayersWhoDidntgGetPurple = 0;
	private int 							  			numberOfTokensGivenSoFar = 0;
	private String							  			playerToStartTournament = "";
	private int 							  			check = 0;
	public 	int								  			tournamentCount = 1;
	private int  							  			numberOfTokensReceivedSoFar = 0;
	private int  							  			keyForPlayerWhoGotAPurple = 0;
	private String							  			nameOfPlayerWhoGotAPurple = "";
	private String 							  			playerToStartTheGameFirst = "";
	private int    							  			keyForPlayerWhoStartsFirst = 0;
	private String						      			playerNameWhoWantsToWithdraw = "";
	private int								  			playerWhoWantsToWithdrawID = 0;
	public  int								  			turnToPlay = 0;
	public 	int 										check2 = 0;
	
	public  boolean										connected = false;
	public  String										maxNumberOfPlayersReached = "";

	/* Constructor for our server */
	public ServerApp(int port) {
		try {

			/* init rule Engine */
			ruleEngine = new GameRuleEngine();
			System.out.println("Size of color and supporter cards is :" + deckOfColorAndSupporters.size());
			System.out.println("Binding to port " + port + ", please wait  ...");
			System.out.println("Binding to port " + port);
			/**
			 * I use a HashMap to keep track of the client connections and their
			 * related thread
			 */
			clients = new HashMap<Integer, ServerThread>();
			clientsToPlayers = new HashMap<Integer, Player>();

			/** Establish the servers main port that it will listen on */
			server    = new ServerSocket(port);
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
	
	/** Reset reuse port 
	 * @throws SocketException */
	public void resetPort() throws SocketException {
		server.setReuseAddress(true);
	}

	/** Now we start the servers main thread */
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
			System.out.println(String.format("Server started: %s %d", server,thread.getId()));
		}
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
		if (clientCount < Config.NUMBER_OF_PLAYERS_SPECIFIED && Config.NUMBER_OF_PLAYERS_SPECIFIED >= 2) {
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
			maxNumberOfPlayersReached = "Client refused: maximum number of player reached";
		}
	}


	public synchronized void handle(int ID, String input) {

		Player gotPurple;


		if (input.startsWith("nameOfPlayer")) {
			String[] splitIt = input.split(" ");
			String newPlayerName 		    = splitIt[1];

			Player currentPlayer = new Player(newPlayerName);
			players.add(currentPlayer);
			clientsToPlayers.put(ID, currentPlayer);

			StringBuilder allPlayersNames = new StringBuilder();
			for(int i = 0; i < players.size(); i++) {
				allPlayersNames.append(players.get(i).getPlayerName());
				allPlayersNames.append(" ");
			}

			sendMessageToAllClients("Names of players " + clientCount + " " + allPlayersNames);
		}

		if((players.size() == Config.NUMBER_OF_PLAYERS_SPECIFIED) && (check==0)) {
			for(int i = 0; i < players.size(); i++) {
				sendMessageToAllClients("Pick a token");
			}
			check =1;
		}

		if(input.equals("Token is requested")) {
			String tokenForEachPlayer = "";
			if (players.size() == Config.TWO_PLAYERS) 
				tokenForEachPlayer = ruleEngine.distributeTokens(tokensForTwoPlayers);
			if(players.size() == Config.THREE_PLAYERS)
				tokenForEachPlayer = ruleEngine.distributeTokens(tokensForThreePlayers);
			else if(players.size() == Config.FOUR_PLAYERS) 
				tokenForEachPlayer = ruleEngine.distributeTokens(tokensForFourPlayers);
			else if(players.size() == Config.FIVE_PLAYERS)
				tokenForEachPlayer = ruleEngine.distributeTokens(tokensForFivePlayers);

			for (Integer key : clientsToPlayers.keySet()) {
				if (key == ID) {
					if (tokenForEachPlayer.equals("purple")) {
						gotPurple = clientsToPlayers.get(key);
						ruleEngine.playerWhoGotPurple = gotPurple.getPlayerName();

						gotPurple                 = clientsToPlayers.get(key);
						keyForPlayerWhoGotAPurple = key;
						nameOfPlayerWhoGotAPurple = gotPurple.getPlayerName();

					}

					clientsToPlayers.get(key).tokenColour = tokenForEachPlayer;

					/* This is where we send the token color to the player that requested for tokens */
					sendToOneClient("token " + tokenForEachPlayer, ID);
					System.out.println("Key is " + key + " " + clientsToPlayers.get(key));
					for (Player p : players) {
						if (p.getPlayerName().equals(clientsToPlayers.get(key).getPlayerName())) {
							clientsToPlayers.get(key).tokenColour = tokenForEachPlayer;
						}
					}
				}

			}	
		}

		if(input.equals("token was generated")) {
			numberOfTokensReceivedSoFar++;

			if(numberOfTokensReceivedSoFar == Config.NUMBER_OF_PLAYERS_SPECIFIED) {

				/* now we can send players who got a purple over to the client */
				sendToOneClient("now you can distribute cards", keyForPlayerWhoGotAPurple);
			}
		}

		if (input.equals("Distribute cards")) {

			for (Player p : players) {
				StringBuilder cardsToSend = new StringBuilder();
				p.handCards =  ruleEngine.distributeCardsToPlayers(p.getPlayerName(), deckOfColorAndSupporters);
				System.out.println("Cards in a new distributed hand are " );
				for (String s: p.handCards) {
					System.out.println(s);
				}
				System.out.println("Hand of cards of " + p.getPlayerName() + " is " + p.handCards.get(0) + p.handCards.get(1));
				for(Entry<Integer, Player> entry: clientsToPlayers.entrySet()) {
					if(Objects.equals(p, entry.getValue())) {
						for(int i = 0; i < p.handCards.size(); i++) {
							cardsToSend.append(p.handCards.get(i));
							cardsToSend.append(" ");
						}
						sendToOneClient("Hand of card " + p.getPlayerName() + " " + cardsToSend.toString(), entry.getKey());

					}
				}
			}
		}

		if(input.equals("done distributing cards")) {
			if (tournamentCount == 1)
				sendToOneClient("Now everyone got a card set your self invisible", keyForPlayerWhoGotAPurple);
			else  {
				System.out.println(holdWinnerOfPreviousTournamentKey);
				sendToOneClient("Now everyone got a card set your self invisible", holdWinnerOfPreviousTournamentKey);
			}
		}

		if(input.equals("enable withdraw button for everyone")) {
			sendMessageToAllClients("I got you. Button will now be enabled");
		}

		if(input.equals("who starts the game now?")) {
			/* get the player seated to the left of the player who got a purple token by calling the rule */
			playerToStartTheGameFirst = ruleEngine.startTournamentFirst(players);
			keyForPlayerWhoStartsFirst = 0;
			if ((tournamentCount == 0) || (tournamentCount == 1)) {
				for (Map.Entry<Integer, Player> entry : clientsToPlayers.entrySet()) {
					if(entry.getValue().getPlayerName().equals(playerToStartTheGameFirst)) {
						keyForPlayerWhoStartsFirst = entry.getKey();
						entry.getValue().myTurnToPlay = true;

						for (int i = 0; i < players.size(); i++) {
							if (entry.getValue().getPlayerName().equals(players.get(i).getPlayerName()))
								turnToPlay = i;
						}
					}
				}
				sendToOneClient("choose the tournament colour", keyForPlayerWhoStartsFirst);
			}
			else {
				int key = 0;
				for (Map.Entry<Integer, Player> entry : clientsToPlayers.entrySet()) {
					if(entry.getValue().getPlayerName().equals(playerWhoWonTheCurrentTournament)) {
						key = entry.getKey();
						entry.getValue().myTurnToPlay = true;

						for (int i = 0; i < players.size(); i++) {
							if (entry.getValue().getPlayerName().equals(players.get(i).getPlayerName()))
								turnToPlay = i;
						}
					}
				}

				if (key != 0) {
					sendToOneClient("Choose the tournament colour", key);
					sendToOneClient("as a winner now you can distribute cards", key);
				}

			}
		}
		if((clientCount == Config.NUMBER_OF_PLAYERS_SPECIFIED) && (checkNames == 0)) {
			for (int i = 0; i < Config.NUMBER_OF_PLAYERS_SPECIFIED; i++) {
				oldPlayers.add(players.get(i));
			}

			String names = "";

			for (int i = 0; i < players.size(); i++) {
				names += players.get(i).getPlayerName() + " ";
			}

			System.out.println(names);
			sendMessageToAllClients("player Names " + names );
			checkNames = 1;
		}

		if(input.equals("now pick your colour")) {
			sendToOneClient("okay I will serve you a list of colours", ID);
		}

		if(input.startsWith("colour tournament")) {
			String[] splitIt = input.split(" ");
			String tournamentColour = splitIt[2].toLowerCase();

			if (ruleEngine.colourIsValid(clientsToPlayers.get(ID), tournamentColour)) {

				/* Call rule engine to set tournament color */
				ruleEngine.setTournamentColour(tournamentColour);
				sendMessageToAllClients("tournament colour is " + tournamentColour);

				/* Set this tournament so the server knows too */
				previousTournamentColour = ruleEngine.getTournamentColour();

				sendMessageToAllClients("tournamentNumber1 " + String.valueOf(tournamentCount));

				sendToOneClient("Draw a card", ID);
			}

			else 
				sendToOneClient("Wrong Colour", ID);
		}

		if (input.equals("Give me a card")) {
			System.out.println("Give me a card");
			sendToOneClient(clientsToPlayers.get(ID).getPlayerName() + " Your new card is " + (ruleEngine.drawCard(clientsToPlayers.get(ID), deckOfColorAndSupporters)), ID);
			clientsToPlayers.get(ID).IgotANewCard = true;

			/*send message to all clients to update their screens */
			for (Integer key: clientsToPlayers.keySet()) {
				if (key != ID) {
					sendToOneClient("Someone got a new card " + clientsToPlayers.get(ID).getPlayerName(), key);
				}

			}
		}

		if (input.equals("I am done")) {
			if (ruleEngine.checkHighestValue(clientsToPlayers.get(ID), players)) {
				System.out.println("I have the highest value");
				clientsToPlayers.get(ID).IgotANewCard = false;
				clientsToPlayers.get(ID).myTurnToPlay = false;

				/* pass turn to the next player and notify him */
				int holdPlayerSize = players.size();
				holdPlayerSize--;
				if (turnToPlay != holdPlayerSize) {
					turnToPlay++;
				}
				else 
					turnToPlay = 0;

				System.out.println("Player " + players.get(turnToPlay).getPlayerName() + " takes his turn to play");
				players.get(turnToPlay).myTurnToPlay = true;

				for (Map.Entry<Integer, Player> entry : clientsToPlayers.entrySet()) {
					if(entry.getValue().getPlayerName().equals(players.get(turnToPlay).getPlayerName())) {
						System.out.println("I found this guy " + players.get(turnToPlay));
						int key = entry.getKey();
						sendToOneClient("Your turn to play", key);
						sendToOneClient("Draw a card", key);
					}
				}
			}
			else 
				sendToOneClient("You have to withdraw or play a card of higher value", ID);
		}

		if (input.startsWith("Card was played")) {
			String[] splitIt = input.split(" ");
			int index = Integer.parseInt(splitIt[3]);
			index--;
			if (clientsToPlayers.get(ID).IgotANewCard) {
				System.out.println("Card played " + clientsToPlayers.get(ID).handCards.get(index));
				System.out.println("Player I'm trying to access is " + clientsToPlayers.get(ID).getPlayerName());
				if (ruleEngine.playColorOrSupporterCard(clientsToPlayers.get(ID), clientsToPlayers.get(ID).handCards.get(index))) {
					System.out.println("Your card was played ");
					sendToOneClient("Enable done", ID);
					int holdIndex = index + 1;
					sendToOneClient("Disable " + holdIndex + " " + clientsToPlayers.get(ID).getPlayerName(), ID);
					int sizeOfDisplay = clientsToPlayers.get(ID).playerDisplay.size();
					if (sizeOfDisplay > 1) {
						sendMessageToAllClients("Update display " + clientsToPlayers.get(ID).playerDisplay.get(0) + " " +
								clientsToPlayers.get(ID).playerDisplay.get(sizeOfDisplay-1) + " " + clientsToPlayers.get(ID).getPlayerName());
					}
					else {			
						sendMessageToAllClients("Update display " + clientsToPlayers.get(ID).playerDisplay.get(0) + 
								" " + clientsToPlayers.get(ID).getPlayerName());
					}
					sendMessageToAllClients("Update score " + clientsToPlayers.get(ID).getPlayerName() + " "+ clientsToPlayers.get(ID).getTotalCardvalue());
				}

				else {
					sendToOneClient("You are trying to play wrong card" , ID);
				}
			}

			else 
				sendToOneClient("You have to pick a card first", ID);

		}

		if(input.startsWith("The winner of the purple tournament has chosen a color ")) {

			String[] splitIt = input.split(" ");
			String tokenColourChosen = splitIt[10];
			
			/* call rule engine and pass in that this into it */
			ruleEngine.winTournament(players, ruleEngine.getTournamentColour(), tokenColourChosen);

			sendToOneClient("Server is done adding token to my list of tokens " + tokenColourChosen + " " + players.get(0).getPlayerName(), playerWhoWonCurrentTournamentKey);
			sendMessageToAllClients("make token visible to other players " + tokenColourChosen + " " + players.get(0).getPlayerName());

		}

		if (input.startsWith("I chose to remove ")) {
			String splitIt[] = input.split(" ");
			ruleEngine.removeToken(clientsToPlayers.get(ID), splitIt[4]);
			System.out.println("Player's array of tokens " + clientsToPlayers.get(ID).playerTokens.size());
			sendMessageToAllClients("Remove a token " + splitIt[4] + " player " + clientsToPlayers.get(ID).getPlayerName());


		}

		if(input.equals("I want to withdraw")) {
			boolean canWithdraw = false;
			/*check if he has a maiden on his display */
			if (!ruleEngine.hasToGiveUpToken(clientsToPlayers.get(ID), players)) {
				if(ruleEngine.Withdraw(clientsToPlayers.get(ID).getPlayerName(), players, discardPile, winningTokens, withdrawnPlayers)) {
					String LeftPlayerName = clientsToPlayers.get(ID).getPlayerName();

					sendToOneClient("I left. Disable all my buttons", ID);
					sendMessageToAllClients("Left " + LeftPlayerName);
					System.out.println("Size OF Players Array after deletion: " + players.size());
					System.out.println("Size OF Players Array after deletion: " + clientsToPlayers.size());
					canWithdraw = true;
					int holdSize = players.size();

					if (turnToPlay == holdSize) {
						turnToPlay=0;
					}
					players.get(turnToPlay).myTurnToPlay = true;
					for (Map.Entry<Integer, Player> entry : clientsToPlayers.entrySet()) {
						if(entry.getValue().getPlayerName().equals(players.get(turnToPlay).getPlayerName())) {
							System.out.println("I found this guy " + players.get(turnToPlay));
							int key = entry.getKey();
							sendToOneClient("Your turn to play", key);
							sendToOneClient("Draw a card", key);
						}
					}
				}
			}

			else {
				/* If player has a maiden in his display, give up a token */
				canWithdraw = true;
				StringBuilder allTokensOfAPlayer = new StringBuilder();

				for(int i = 0; i < clientsToPlayers.get(ID).playerTokens.size(); i++) {
					allTokensOfAPlayer.append(clientsToPlayers.get(ID).playerTokens.get(i));
					allTokensOfAPlayer.append("_");
				}
				String messageToSent = "Give up a token " + allTokensOfAPlayer;
				sendToOneClient(messageToSent, ID);
			}

			if (!canWithdraw) {
				sendToOneClient("You cannot withdraw", ID);
			}

			if(players.size() == 1) {

				String tournamentColour = ruleEngine.getTournamentColour();	

				/* check who the winner of the tournament is */
				if(!tournamentColour.equalsIgnoreCase("purple")) {
					String winner = ruleEngine.winTournament(players, tournamentColour, "");
					System.out.println(winner);

					if(winner.equals("You already have this token")) {
						playerWhoWonTheCurrentTournament = players.get(0).getPlayerName();

						for (Map.Entry<Integer, Player> entry : clientsToPlayers.entrySet()) {
							if(entry.getValue().getPlayerName().equals(playerWhoWonTheCurrentTournament)) {
								playerWhoWonCurrentTournamentKey = entry.getKey();
								holdWinnerOfPreviousTournamentKey = playerWhoWonCurrentTournamentKey;

								System.out.println(playerWhoWonTheCurrentTournament + " " + entry.getValue().getPlayerName());
								sendToOneClient("you already have this token", playerWhoWonCurrentTournamentKey);
								sendToOneClient("you are the winner of this tournament " + playerWhoWonTheCurrentTournament, playerWhoWonCurrentTournamentKey);
							}
						}
					}

					else {	
						playerWhoWonTheCurrentTournament  = players.get(0).getPlayerName();

						for (Map.Entry<Integer, Player> entry : clientsToPlayers.entrySet()) {
							if(entry.getValue().getPlayerName().equals(playerWhoWonTheCurrentTournament)) {
								playerWhoWonCurrentTournamentKey = entry.getKey();
								holdWinnerOfPreviousTournamentKey = playerWhoWonCurrentTournamentKey;

								System.out.println(playerWhoWonCurrentTournamentKey + " " + entry.getValue().getPlayerName());
								sendToOneClient("you are the winner of this tournament " + playerWhoWonTheCurrentTournament, playerWhoWonCurrentTournamentKey);
								sendToOneClient("Server is done adding token to my list of tokens " + ruleEngine.getTournamentColour() + " " + playerWhoWonTheCurrentTournament, playerWhoWonCurrentTournamentKey);
								sendMessageToAllClients("make token visible to other players " + ruleEngine.getTournamentColour() + " " + playerWhoWonTheCurrentTournament);
							}
						}
					}
				}

				else {
					playerWhoWonTheCurrentTournament  = players.get(0).getPlayerName();

					for (Map.Entry<Integer, Player> entry : clientsToPlayers.entrySet()) {
						if(entry.getValue().getPlayerName().equals(playerWhoWonTheCurrentTournament)) {
							playerWhoWonCurrentTournamentKey = entry.getKey();

							sendToOneClient("you are the winner of this tournament " + playerWhoWonTheCurrentTournament, playerWhoWonCurrentTournamentKey);
							sendToOneClient("This is a purple tournament choose your colour", playerWhoWonCurrentTournamentKey);
						}
					}
				}
			}
		}

		if(input.equals("Tournament done!")) {

			String playerName = "";

			for(Player p : withdrawnPlayers) {
				playerName += p.getPlayerName() + " "; 
			}
			tournamentCount += 1;	
			if(previousTournamentColour.equals("purple")) {
				sendToOneClient("Choose colour of tournament", playerWhoWonCurrentTournamentKey);
				sendToOneClient("as a winner now you can distribute cards", playerWhoWonCurrentTournamentKey);
			}

			else {
				sendToOneClient("choose the tournament colour", playerWhoWonCurrentTournamentKey);
				sendToOneClient("as a winner now you can distribute cards", playerWhoWonCurrentTournamentKey);
			}
			sendMessageToAllClients("Enable hand of cards");
			sendMessageToAllClients("players who withdrew we have to enable " + playerName);

			/* put back all players in the game */
			for (int i = 0; i < Config.NUMBER_OF_PLAYERS_SPECIFIED; i++) {
				players = new ArrayList<Player>();
				players.addAll(oldPlayers);
			}
			for (Player p: players) {
				System.out.println("Player's name is "+ p.getPlayerName());
			}
			withdrawnPlayers.removeAll(withdrawnPlayers);
			ruleEngine.putBackCardsInDsicardPileIntoDeck(deckOfColorAndSupporters, discardPile);
			previousTournamentColour = "";
			System.out.println("Size of players is: " + players.size());
			for (int i =0;i<players.size();i++) {
				System.out.println("I am in the for loop: " + playerWhoWonTheCurrentTournament);
				if (players.get(i).getPlayerName().equals(playerWhoWonTheCurrentTournament)) {
					turnToPlay = i;
					System.out.println("Its your turn to play " + turnToPlay + " " + players.get(i).getPlayerName());
				}
			}

			/* reset display value as well */
			for(int i = 0; i < players.size(); i++) {
				players.get(i).resetTotalCardValue();
				players.get(i).resetDisplay();
			}
			
			System.out.println("Tokens of the winner: ");
			for (Player p: players) {
				if (p.getPlayerName().equals(playerWhoWonTheCurrentTournament)) {
					for (String s : p.playerTokens) {
						System.out.println(s);
					}
				}
			}
			playerWhoWonTheCurrentTournament = "";
			playerWhoWonCurrentTournamentKey = 0;	
		}


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