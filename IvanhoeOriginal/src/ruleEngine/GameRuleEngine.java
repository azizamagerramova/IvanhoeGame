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

}
