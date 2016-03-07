package ruleEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import config.Config;
import entity.Player;

public class GameRuleEngine {
	
	public String playerWhoGotPurple        = "";
	public String tournamentColour          = "";
	
	/* Game rule Engine constructor */
	public GameRuleEngine() {
		
	}
	
	/* Check if the player got back a purple token */
	public boolean didPlayerGetAPurpleToken(String tokenColor, String playerName) {
		boolean flag = false;
		
		if (tokenColor.equals("purple")) {
				flag = true;
				playerWhoGotPurple = playerName;
		}
		
		return flag;
	}
	
	public String getTournamentColour() {
		return tournamentColour;
	}
	
	/* set tournament color when game has started and user chooses color for that specific tournament */
	public void setTournamentColour(String tColour) {
		tournamentColour = tColour;
	}
	
	/* Give a token to a player 
	 * Takes the list of tokens and returns the random token as a string*/
	public String distributeTokens(List<String> tokens) {
		
		int random = (int) Math.floor(tokens.size() * Math.random());
		String playersToken = tokens.get(random);
		tokens.remove(random);
		return playersToken;	
	}
	
	/* Take in array of cards and distribute eight cards to each player */
	public ArrayList<String> distributeCardsToPlayers(String playerName, ArrayList<String> deckOfCards) {
		ArrayList<String> eightCardsEach = new ArrayList<String>();
		String getTheRandomString = "";
		
		/* Shuffle deck of cards first */
		int shuffleDeckOfCards;
		
		for(int i = 0; i < Config.numCardsToDistribute; i++) {
			shuffleDeckOfCards = (int) Math.floor(deckOfCards.size() * Math.random());

			getTheRandomString = deckOfCards.get(shuffleDeckOfCards);
			eightCardsEach.add(getTheRandomString);
			deckOfCards.remove(shuffleDeckOfCards);
		}
		
		return eightCardsEach;
	}
	
	/*Take one card from the deck and give it to a player 
	 * generate number at random, take card at random position 
	 * and put it in player's array of cards. Return player's array*/
	public String drawCard (Player p, ArrayList<String> deckOfCards) {
		int random = (int )(Math.random() * (deckOfCards.size()-1) + 0);
		boolean check = false;
		String newCard = deckOfCards.get(random);
		for (int i=0;i<p.handCards.size();i++) {
			if (p.handCards.get(i).equals("")) {
				p.handCards.set(i, newCard);
				check = true;
			}		
		}
		if (check == false )
			p.handCards.add(deckOfCards.get(random));
		
		deckOfCards.remove(random);
		return newCard;
	}
	
	
	/* NOTE: this will be used for iteration 2 */
	
	/*check if there are only action cards in a player's hand	
	 * if so return boolean true, otherwise return false */
	/*public boolean playerHasOnlyActions (List<String> handOfCards) {
		for (int i = 0;i < handOfCards.size(); i++) {
			String[] parts = handOfCards.get(i).split("_");
			if (!parts[0].equals("action")) {
				return false;
			}
		}
		return true;
	}*/
	
	/* Start a tournament by playing anti-clockwise from left of the dealer
	 * who deals the card to each player
	 */
	public String startTournamentFirst (ArrayList<Player> players) {
		int q = 0;
		String playerToStartsGame = "";
		
		for (int i = 0; i < players.size(); i++){
			if (didPlayerGetAPurpleToken(players.get(i).getTokenColour(), players.get(i).getPlayerName())) {
				if (i == players.size()-1) {
					playerToStartsGame = players.get(0).getPlayerName();
				}
				else  {
					q = i+1;
					playerToStartsGame = players.get(q).getPlayerName();
				}
			}
		}
		return playerToStartsGame;
	}
	
	
	public boolean colourIsValid(Player p, String chosenColour) {
		for (String s: p.handCards) {
			String[] splitIt = s.split("_");
			if ((splitIt[0].equals("color") && (splitIt[2].equals(chosenColour))) || splitIt[0].equals("supporter")) {
				return true;
			}
		}
		
		return false;
	}
	
	public void removeToken(Player p, String token) {
		for (int i =0; i<p.playerTokens.size();i++) {
			if (token.equalsIgnoreCase(p.playerTokens.get(i))) {
				System.out.println("I'm gonna remove " + p.playerTokens.get(i));
				p.playerTokens.remove(i);
			}
		}
	}
	
	public boolean hasToGiveUpToken(Player p, List<Player> players) {
		for(int b = 0; b < p.playerDisplay.size(); b++) {
			if(p.playerDisplay.get(b).startsWith("supporter_card_6") && p.myTurnToPlay) {
				if(p.playerTokens.size() >= 1) {
					return true;
			}
		  }
		}
		
		return false;
	}
	
	public boolean Withdraw(String name, List<Player> players, ArrayList<String> discardPile, ArrayList<String> token, ArrayList<Player> withdrawnPlayers) {
		boolean flag = false;	

		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).getPlayerName().equals(name) && (players.get(i).myTurnToPlay == true)) {
				for(int a = 0; a < players.get(i).handCards.size(); a++) {
					discardPile.add(players.get(i).handCards.get(a));
				}
				
				discardPile.addAll(players.get(i).playerDisplay);
				players.get(i).handCards.removeAll(players.get(i).handCards);
				players.get(i).playerDisplay.removeAll(players.get(i).playerDisplay);
				withdrawnPlayers.add(players.get(i));
				players.remove(i);
				
				flag = true;
			}
		}
		
		return flag;
	}
		
	/* takes list of players and color of tournament,  */
	/* checks if a player won a tournament, 
	 * gives him token of tournament color or lets him to choose token  */
	public void putBackCardsInDsicardPileIntoDeck(ArrayList<String> deckOfCards, ArrayList<String> discardPile) {
		for(String s: discardPile) {
			if (!s.equals(""))
				deckOfCards.add(s);
		}
		discardPile.removeAll(discardPile);
	}
	
	public String winTournament(ArrayList<Player> players, String colorOfTournament, String tokenChosen) {
		
		String  playerName = "";
		
		int sizeOfPlayerTokenArray = players.get(0).playerTokens.size();
		
		if(players.size() == 1) {
			if(sizeOfPlayerTokenArray == 0) {
				if(!colorOfTournament.equals("purple")) {
					players.get(0).playerTokens.add(colorOfTournament);
					playerName = players.get(0).getPlayerName();
				}
				
				else if(colorOfTournament.equals("purple")){
					players.get(0).playerTokens.add(tokenChosen);
					playerName = players.get(0).getPlayerName();
				}
			}
			
			else if(sizeOfPlayerTokenArray > 0) {
				if(!colorOfTournament.equals("purple")) {
					for(int i = 0; i < players.get(0).playerTokens.size(); i++) {
						if(players.get(0).playerTokens.get(i).equals(colorOfTournament)) {
							playerName = "You already have this token";
							break;
						}
						
						else if(!players.get(0).playerTokens.get(i).equals(colorOfTournament)){
							playerName = players.get(0).getPlayerName();
							players.get(0).playerTokens.add(colorOfTournament);
							break;
						}
					}
				}
				
				else {
					for(int i = 0; i < players.get(0).playerTokens.size(); i++) {
						if(players.get(0).playerTokens.get(i).equals(tokenChosen)) {
							playerName = "You already have this token";
							break;
						}
						
						else {
							players.get(0).playerTokens.add(tokenChosen);
							playerName = players.get(0).getPlayerName();
							break;
						}
					}
				}
			}
		}
		return playerName;
	}
	
	
	public void resetMyCards(ArrayList<String> discardPile, Player player) {
		discardPile.addAll(player.handCards);
		discardPile.addAll(player.playerDisplay);
		player.playerDisplay.removeAll(player.playerDisplay);
		player.handCards.removeAll(player.handCards);
	}
	
	
	public String winGame(List<Player> players, Integer playersatStart) {
		String winner = null;
		if (playersatStart <=3) {
			if (players.get(0).playerTokens.size() == 5) {
				winner = players.get(0).getPlayerName();
			}
		}
		else {
			if (players.get(0).playerTokens.size() == 4)  {
				winner = players.get(0).getPlayerName();
			}
		}
		return winner;
	}
	
	public boolean checkHighestValue(Player current, ArrayList<Player> players) {
		for (Player p: players) {
			if ((current.totalCardValue <= p.totalCardValue)) {
				if (!current.getPlayerName().equals(p.getPlayerName()))
					return false;
			}
		}
		return true;
		
	}
	
	public boolean playColorOrSupporterCard(Player player, String card) {
		int score = 0;
		String[] splitIt = card.split("_");
		boolean flag1 = true;

		if (player.myTurnToPlay) {
			if (splitIt[0].equals("supporter"))  {
				if (splitIt[2].equals("6")) {
					for (int i = 0; i< player.playerDisplay.size();i++) {
						if((player.playerDisplay.get(i).startsWith("supporter_card_6"))) {
							System.out.println("You are trying to play another supporter card");
							return false;
					}
				}
			}
				
				if (flag1) {
					score = Integer.parseInt(splitIt[2]);
					player.playerDisplay.add(card);
					for (int i=0;i<player.handCards.size();i++) {
						if (card.equals(player.handCards.get(i))) {
							player.handCards.set(i, "");
						}
					}
					if (!tournamentColour.equalsIgnoreCase("green")) {
						player.totalCardValue += score;
					}
					else 
						player.totalCardValue +=1;
					return true;
				}
			}

			else if (splitIt[0].equals("color") && tournamentColour.equalsIgnoreCase(splitIt[2])) {
			
				score = Integer.parseInt(splitIt[3]);
				player.playerDisplay.add(card);
				for (int i=0;i<player.handCards.size();i++) {
					if (card.equals(player.handCards.get(i))) {
						player.handCards.set(i, "");
					}
				}
				
				player.totalCardValue += score;
				return true;
			}
		}
		
		return false;
	}
	
	
	/* if player plays an action card, ask him what exactly he wants to do, 
	 * if no answer in required return an empty string. Otherwise, return a question. 
	 * Ivanhoe action card is not covered as it's a special case
	 */ 
	
	public String askPlayerActionCard(Player player, String card) {
		String[] splitIt = card.split("_");
		String message = "";
		if (splitIt[2].equals("unhorse")) {
			if (tournamentColour.equals("purple")) {
				message = "Change tournament colour to red, blue or yellow. Pick the colour";
			}
			else 
				message = "Current tournament colour is not purple. You cannot play unhorse.";
		}
		
		else if (splitIt[2].equals("change weapon")) {
			if (tournamentColour.equals("red") || tournamentColour.equals("yellow") 
					|| tournamentColour.equals("blue")) {
				message = "Change tournament colour to red, blue or yellow. Pick the colour.";
			}
			else 
				message = "Current tournament colour isn't red, blue or yellow. "
						+ "You cannot play 'change weapon card";
		}
		
		else if (splitIt[2].equals("drop weapon")) {
			if (tournamentColour.equals("red") || tournamentColour.equals("yellow") 
					|| tournamentColour.equals("blue")) {
				message = "  ";
			}
			else 
				message = "Current tournament colour isn't red, blue or yellow. "
						+ "You cannot play 'change weapon card";
		}
		else if (splitIt[2].equals("break lance")) {
			message = "Choose an opponent to discard all purple cards";
		}
		
		else if (splitIt[2].equals("riposte")) {
			message = "Choose an opponent to get their last played card";
		}
		
		else if (splitIt[2].equals("dodge")) {
			message = "Choose an opponent, and a card to discard";
		}
		
		else if (splitIt[2].equals("retreat")) {
			message = "Choose the card from your display";
		}
		
		else if (splitIt[2].equals("knock down")) {
			message = "Choose the opponent and the card";
		}
		
		else if (splitIt[2].equals("outmaneuver") || splitIt[2].equals("charge") ||
				splitIt[2].equals("counter-charge") || splitIt[2].equals("disgrace")
				|| splitIt[2].equals("adapt") || splitIt[2].equals("shield"))  {
			message = " ";
		}
		
		else if (splitIt[2].equals("outwit")) {
			message = "Choose your card. Then choose opponent card. ";
		}
		
		else if (splitIt[2].equals("stunned")) {
			message = "Choose an opponent";
		}
		
	
		return message;
	}
	
	/*play an action card accordingly to the player's message
	 * 
	 */
	public void playActionCard(Player player, List<Player> players, String card, String message, List<String> discardPile) {
		String[] splitIt = card.split("_");
		String cardName = splitIt[2];
		Player p = new Player("pp");
		ArrayList<String> newDisplay = new ArrayList<String>();
		
		if (cardName.equals("unhorse") || cardName.equals("change weapon")) {
			tournamentColour = message;
		}
		
		else if (cardName.equals("drop weapon")) {
		tournamentColour = "green";
		}
		
		else if (cardName.equals("break lance")) {
			/*find the matching player and remove all purple cards from his display
			 */
			for (int i = 0; i < players.size(); i++) {	
				if (players.get(i).getPlayerName().equals(message)) {
					p = players.get(i);
					break;
				}
			}
			
			for (int j = 0; j <  p.playerDisplay.size(); j++) {
				if (!p.playerDisplay.get(j).contains("purple")) {
					newDisplay.add(p.playerDisplay.get(j));
				}
				else 
					discardPile.add(p.playerDisplay.get(j));
			}
			p.playerDisplay = newDisplay;
		}
		
		else if (cardName.equals("riposte")) {
			for (int i = 0; i< players.size(); i++) {
				if (players.get(i).getPlayerName().equals(message)) {
					String lastCardInaDisplay = players.get(i).playerDisplay.get((players.get(i).playerDisplay.size())-1);
					player.playerDisplay.add(lastCardInaDisplay);
					players.get(i).playerDisplay.remove((players.get(i).playerDisplay.size())-1);
				}
			}
		}
		
		else if (cardName.equals("dodge")) {
			String splitMessage[] = message.split(" ");
			for (int i = 0; i< players.size(); i++) {
				if (players.get(i).getPlayerName().equals(splitMessage[0])) {
					for (int j = 0; j<players.get(i).playerDisplay.size();j++) {
						if (players.get(i).playerDisplay.get(j).equals(splitMessage[1])) {
							player.playerDisplay.add(splitMessage[1]);
							players.get(i).playerDisplay.remove(j);
						}
					}
				}	
			}
		}
		
		else if (cardName.equals("retreat")) {
			for (int i =0;i<player.playerDisplay.size();i++) {
				if (message.equals(player.playerDisplay.get(i))) {
					player.handCards.add(message);
					player.playerDisplay.remove(i);
				}
			}
		}
		
		else if (cardName.equals("knock down")) {
			String splitMessage[] = message.split(" ");
			for (int i = 0; i< players.size(); i++) {
				if (players.get(i).getPlayerName().equals(splitMessage[0])) {
					for (int j = 0; j<players.get(i).playerDisplay.size();j++) {
						if (players.get(i).handCards.equals(splitMessage[1])) {
							player.handCards.add(splitMessage[1]);
							players.get(i).handCards.remove(j);
						}
					}
				}
			}
		}
		
		else if (cardName.equals("outmaneuver")) {
			for (int i = 0; i< players.size(); i++) {
				players.get(i).playerDisplay.remove(players.get(i).playerDisplay.size()-1);
			}
		}
		
		else if (cardName.equals("charge")) {
			int min = 0;
			String cardValue = "" ;
			for (int i = 0; i< players.size(); i++) {
				for (int j =0;j<players.get(i).playerDisplay.size();j++) {
					String cardsIn[] = players.get(i).playerDisplay.get(i).split("_");
					if (cardsIn[0].equals("color"))  {
						if (Integer.parseInt(cardsIn[3]) < min)
							min = Integer.parseInt(cardsIn[3]);
					}
					else if (cardsIn[0].equals("supporter")) {
						if (Integer.parseInt(cardsIn[2]) < min )
							min = Integer.parseInt(cardsIn[2]);
					}
				}
			}
			
			for (int i=0;i<players.size(); i++) {
				for (int j =0;j<players.get(i).playerDisplay.size();j++) {
					String cardsIn[] = players.get(i).playerDisplay.get(i).split("_");
					if (cardsIn[0].equals("color")) {
						if (Integer.parseInt(cardsIn[3]) == min) {
							discardPile.add(players.get(i).playerDisplay.get(i));
							players.get(i).playerDisplay.remove(j);
						}
					}
					
					else if (cardsIn[0].equals("supporter")) {
						if (Integer.parseInt(cardsIn[2]) == min) {
							discardPile.add(players.get(i).playerDisplay.get(i));
							players.get(i).playerDisplay.remove(j);
						}
					}
				}
			}
		}
		
		else if (cardName.equals("counter-charge")) {
			int max = 0;
			String cardValue = "" ;
			for (int i = 0; i< players.size(); i++) {
				for (int j =0;j<players.get(i).playerDisplay.size();j++) {
					String cardsIn[] = players.get(i).playerDisplay.get(i).split("_");
					if (cardsIn[0].equals("color"))  {
						if (Integer.parseInt(cardsIn[3]) > max)
							max = Integer.parseInt(cardsIn[3]);
					}
					else if (cardsIn[0].equals("supporter")) {
						if (Integer.parseInt(cardsIn[2]) > max )
							max = Integer.parseInt(cardsIn[2]);
					}
				}
			}
			
			for (int i=0;i<players.size(); i++) {
				for (int j =0;j<players.get(i).playerDisplay.size();j++) {
					String cardsIn[] = players.get(i).playerDisplay.get(i).split("_");
					if (cardsIn[0].equals("color")) {
						if (Integer.parseInt(cardsIn[3]) == max) {
							discardPile.add(players.get(i).playerDisplay.get(i));
							players.get(i).playerDisplay.remove(j);
						}
					}
					
					else if (cardsIn[0].equals("supporter")) {
						if (Integer.parseInt(cardsIn[2]) == max) {
							discardPile.add(players.get(i).playerDisplay.get(i));
							players.get(i).playerDisplay.remove(j);
						}
					}
				}
			}
		}
		
		else if (cardName.equals("disgrace")) {
			for (int i = 0; i< players.size(); i++) {
				for (int j=0;j<players.get(i).playerDisplay.size();i++) {
					String cardsIn[] = players.get(i).playerDisplay.get(i).split("_");
					if (cardsIn[0].equals("supporter")) {
						discardPile.add(players.get(i).playerDisplay.get(i));
						players.get(i).playerDisplay.remove(j);
					}
				}	
			}
		}
				
	}
	
	public boolean EndOfTurn(Player player, List<Player> players) {
		boolean flag = true;
		
		for (int i =0; i< players.size();i++) {
			if (player.totalCardValue < players.get(i).totalCardValue)
				flag = false;
		}
		return flag;
	}
	
	public boolean checkDeckOfCardsEmpty(List<String> deckOfCards) {
		boolean flag = false;

		if(deckOfCards.isEmpty()) {
			flag = true;
		}	
		else {
			flag = false;
		}	
		return flag;
	}
	
	public String playACardDuringPlayerTurn(ArrayList<String> handOfCard, String cardChosen) {
		
		String result = "";
		
		for(int i = 0; i < handOfCard.size(); i++) {
			if(cardChosen.equals(handOfCard.get(i))) {
				result = handOfCard.get(i);
			}
		}
		
		return result;
	}
			
	@SuppressWarnings("unchecked")
	public static ArrayList<String> reShuffleDiscardPileWhenDrawDeckIsEmpty(List<String> deckOfCards, ArrayList<String> discardPile) {

		ArrayList<String> newDeckOfCards = new ArrayList<String>();

		// Shuffle the discard pile cards
		Collections.shuffle(discardPile);

		// Copy what is in the discard pile to the new deck of card
		newDeckOfCards = (ArrayList<String>) discardPile.clone();

		// now empty discard pile since we copied everything to the new deck of card
		discardPile.removeAll(discardPile);

		return newDeckOfCards;
	}
	
}
