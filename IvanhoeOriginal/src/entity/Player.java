package entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import config.Config;

public class Player {
	
	public 	String 					tokenColour;
	private String 					playerName;
	public boolean myTurnToPlay;
	public  int    					totalCardValue;
	public  ArrayList<String> 		playerTokens;
	public 	ArrayList<String> 		handCards;
	public 	ArrayList<String>       playerDisplay;
	
	public Player() {
		myTurnToPlay = false;
		this.playerName  			= "computer"; 
		totalCardValue   			= 0;
		playerTokens     			= new ArrayList<String>(Config.numberOfTokens);
		handCards					= new ArrayList<String>(Config.numberOfCardsForEachPlayer);
		playerDisplay				= new ArrayList<String>();
	}
	

	public Player(String playerName) {
		this.playerName  			= playerName; 
		totalCardValue   			= 0;
		playerTokens     			= new ArrayList<String>(Config.numberOfTokens);
		handCards					= new ArrayList<String>(Config.numberOfCardsForEachPlayer);
		playerDisplay				= new ArrayList<String>();
	}
	
	public int getTotalCardvalue() {
		return totalCardValue;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public String getTokenColour() {
		return tokenColour;
	}
	
	
}

