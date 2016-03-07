package ruleEngine;

import java.util.ArrayList;
import java.util.List;

import config.Config;
import entity.Player;

public class GameRuleEngine {
	
	public String playerWhoGotPurple        = "";
	public String tournamentColour   = "";
	
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
    
    public static void resetMyCards(ArrayList<String> discardPile, Player player) {
    	discardPile.addAll(player.handCards);
		discardPile.addAll(player.playerDisplay);
		player.playerDisplay.removeAll(player.playerDisplay);
		player.handCards.removeAll(player.handCards);
	}
    
	public static boolean checkDeckOfCardsEmpty(List<String> deckOfCards) {
		boolean flag = false;

		if(deckOfCards.isEmpty()) {
			flag = true;
		}	
		else {
			flag = false;
		}	
		return flag;
	}
	
	
	
	public boolean checkHighestValue(Player current, ArrayList<Player> players) {
		
		return false;
		
	}
	
	/* takes list of players and color of tournament,  */
	/* checks if a player won a tournament, 
	 * gives him token of tournament color or lets him to choose token  */
	public void putBackCardsInDsicardPileIntoDeck(ArrayList<String> deckOfCards, ArrayList<String> discardPile) {
		
	}

}
