package gameRuleEngineTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import config.Config;
import entity.Player;
import ruleEngine.GameRuleEngine;

public class GameRuleEngineTest {
	
	public String playerWhoGotPurple        = "";
	public String tournamentColour   = "";
	

	 ArrayList<String>				  			deckOfColorAndSupporters = new ArrayList<String>(Arrays.asList("color_card_purple_3_1","color_card_purple_3_2", "color_card_purple_3_3","color_card_purple_3_4",
			"color_card_purple_4_1", "color_card_purple_4_2", "color_card_purple_4_3", "color_card_purple_4_4", "color_card_purple_5_1", "color_card_purple_5_2", "color_card_purple_5_3", "color_card_purple_5_4", "color_card_purple_7_1", "color_card_purple_7_2", 
			"color_card_red_3_1", "color_card_red_3_2", "color_card_red_3_3", "color_card_red_3_4", "color_card_red_3_5", "color_card_red_3_6","color_card_red_4_1", "color_card_red_4_2", "color_card_red_4_3", "color_card_red_4_4", "color_card_red_4_5", "color_card_red_4_6", "color_card_red_5_1", "color_card_red_5_2",
			"color_card_blue_2_1","color_card_blue_2_2","color_card_blue_2_3", "color_card_blue_2_4", "color_card_blue_3_1","color_card_blue_3_2", "color_card_blue_3_3", "color_card_blue_3_4", "color_card_blue_4_1","color_card_blue_4_2", "color_card_blue_4_3", "color_card_blue_4_4", "color_card_blue_5_1",  "color_card_blue_5_2", 
			"color_card_yellow_2_1", "color_card_yellow_2_2", "color_card_yellow_2_3", "color_card_yellow_2_4", "color_card_yellow_3_1", "color_card_yellow_3_2", "color_card_yellow_3_3", "color_card_yellow_3_4", "color_card_yellow_3_5", "color_card_yellow_3_6", "color_card_yellow_3_7", "color_card_yellow_3_8", "color_card_yellow_4_1", "color_card_yellow_4_2",
			"color_card_green_1_1","color_card_green_1_2","color_card_green_1_3","color_card_green_1_4","color_card_green_1_5","color_card_green_1_6","color_card_green_1_7","color_card_green_1_8","color_card_green_1_9","color_card_green_1_10", "color_card_green_1_11", "color_card_green_1_12", "color_card_green_1_13", "color_card_green_1_14", 
			"supporter_card_2_1", "supporter_card_2_2", "supporter_card_2_3", "supporter_card_2_4", "supporter_card_2_5", "supporter_card_2_6", "supporter_card_2_7", "supporter_card_2_8",
			"supporter_card_3_1", "supporter_card_3_2", "supporter_card_3_3", "supporter_card_3_4", "supporter_card_3_5", "supporter_card_3_6", "supporter_card_3_7", "supporter_card_3_8",
			"supporter_card_6_1", "supporter_card_6_2","supporter_card_6_3", "supporter_card_6_4"));
	
	 
	    ArrayList<String> hand = new ArrayList<String>();
		List<String> tokens = new ArrayList<String>();
		GameRuleEngine engine = new GameRuleEngine();
		List<String> discardPile = new ArrayList<String>(); 
		ArrayList<Player> players = new ArrayList<Player>(5);
		Player first  = new Player("Aziza");
		Player second = new Player("Kevin");
		Player third = new Player("Christi");
		Player forth = new Player("Tope");
		Player five = new Player("Mike");
	
	
	 @BeforeClass
		public static void setUpBeforeClass() throws Exception {
			System.out.println("@setUpBeforeClass(): TestRuleEngine\n\n");
		}

		@AfterClass
		public static void tearDownAfterClass() throws Exception {
			System.out.println("@After(): RuleEngineTest\n\n");
		}

		@Before
		public void setUp() throws Exception {
			int numberOfCard = 0;
			
			
			tokens.add("red");
			tokens.add("blue");
			tokens.add("purple");
			tokens.add("green");
			tokens.add("yellow");
			
			players.add(first);
			players.add(second);
			players.add(third);
			players.add(forth);
			players.add(five);
		}

		@After
		public void tearDown() throws Exception {
			System.out.println("@tearDown(): RuleEngineTest\n\n");
		}
		
		@Test
		public void testDrawingCard() {
			boolean check = true;
		   String newCard = engine.drawCard(first, deckOfColorAndSupporters);
			for (String s: deckOfColorAndSupporters) {
				if (s.equals(newCard)) {
					check = false;
				}
			}
			
			assertEquals(first.handCards.get(0), newCard);
			assertTrue(check);
			
		 }
		
		@Test
		public void testplayerToStartTournament() {
			first.tokenColour = "yellow";
			second.tokenColour = "blue";
			third.tokenColour = "red";
			forth.tokenColour = "green";
			five.tokenColour = "purple";

			String playerToStart = engine.startTournamentFirst(players);
			assertEquals(first.getPlayerName(), playerToStart);
			
			first.tokenColour = "purple";
			second.tokenColour = "blue";
			third.tokenColour = "red";
			forth.tokenColour = "green";
			five.tokenColour = "yellow";
			assertEquals(second.getPlayerName(), engine.startTournamentFirst(players));

			first.tokenColour = "red";
			second.tokenColour = "blue";
			third.tokenColour = "purple";
			forth.tokenColour = "green";
			five.tokenColour = "yellow";
			assertEquals(forth.getPlayerName(), engine.startTournamentFirst(players));

			
		}
		
		//check that player has a valid colour to start the tournament he wants to start
		@Test
		public void colourIsValid() {
			String colourOfTournament = "red";
			first.handCards.add("color_card_red_3_1");
			assertTrue(engine.colourIsValid(first, colourOfTournament));
			first.handCards.add("color_card_blue_2_2");
			
			assertTrue(engine.colourIsValid(first, "blue"));
			first.handCards.add("color_card_yellow_4_3");
			assertTrue(engine.colourIsValid(first, "yellow"));
			first.handCards.add("color_card_green_4_4"); 
			first.handCards.add("supporter_card_3_1");
			assertTrue(engine.colourIsValid(first, "purple"));
			
		}
		
		@Test
		public void testRemoveToken() {
			boolean check = true;
			second.playerTokens.add("purple");
			second.playerTokens.add("blue");
			second.playerTokens.add("red");
			second.playerTokens.add("green");
			engine.removeToken(second, "purple");
			for (String s: second.playerTokens) {
				if (s.equals("purple")) {
					check = false;
				}
			}
			assertEquals(3, second.playerTokens.size());
			assertTrue(check);
			engine.removeToken(second, "green");
			assertEquals(2, second.playerTokens.size());
			for (String s : second.playerTokens) {
				if (s.equals("green")) {
					check = false;
				}
			}
			assertTrue(check);
			
		}
		
		@Test
		public void testHasToGiveUpToken () {
			third.playerDisplay.add("supporter_card_6_2");
			third.playerDisplay.add("color_card_green_4_4");
			third.playerDisplay.add("color_card_red_4_2");
			assertEquals(engine.hasToGiveUpToken(third, players), false);
			third.myTurnToPlay = true;
			assertEquals(engine.hasToGiveUpToken(third, players), false);
			third.playerTokens.add("purple");
			assertEquals(engine.hasToGiveUpToken(third, players), true);
			
		}
		
		@Test
		public void testplayerWithdraw() {
			ArrayList<String> tokens = new ArrayList<String>();
			ArrayList<Player> withdrawnPlayers = new ArrayList<Player>();
			List<Player> newPlayers = new ArrayList<Player>();
			ArrayList<String> discard = new ArrayList<String>();
			for (Player p: players) {
				newPlayers.add(p);
			}
			first.playerTokens.add("red");
			first.handCards.add("action");
			first.handCards.add( "color");
			first.handCards.add( "action");
			first.handCards.add("Maiden");
			
			assertEquals(false, engine.Withdraw(first.getPlayerName(), newPlayers, discard, tokens, withdrawnPlayers));
			
			first.myTurnToPlay = true;
			assertEquals(true, engine.Withdraw(first.getPlayerName(), newPlayers, discard, tokens, withdrawnPlayers));
			
			assertEquals(players.size(), 5);
			assertEquals(withdrawnPlayers.get(0), first);
		}
		
		@Test
		public void testWinningTournament() {
			int payersAtStart = 3;
			players.remove(4);
			players.remove(3);
			players.remove(0);
			players.remove(1);
			assertEquals(players.get(0).playerTokens.size(), 0);
			
			String colorOfTheTournament = "blue";
			assertEquals(engine.winTournament(players, colorOfTheTournament, ""), players.get(0).getPlayerName());
			
			colorOfTheTournament = "purple";
			assertEquals(engine.winTournament(players, colorOfTheTournament, "blue"), "You already have this token");
			
			assertEquals(engine.winTournament(players, colorOfTheTournament, "yellow"), players.get(0).getPlayerName());
			
			players.get(0).playerTokens.clear();
			assertEquals(engine.winTournament(players, colorOfTheTournament, "yellow"), players.get(0).getPlayerName());
			
		}
		
		@Test
		public void resetMyCards() {
			ArrayList<String> discard = new ArrayList<String>();
			first.handCards = engine.distributeCardsToPlayers(first.getPlayerName(), deckOfColorAndSupporters);
			
			GameRuleEngine.resetMyCards(discard, first);
			assertEquals(discard.size(), 8);
			assertEquals(first.handCards.size(), 0);
			
			first.playerDisplay.add("color_card_red_3_4");
			first.playerDisplay.add("color_card_green_3_4");
			GameRuleEngine.resetMyCards(discard, first);
			assertEquals(discard.size(), 10);
			assertEquals(first.handCards.size(), 0);
			assertEquals(first.playerDisplay.size(), 0);
		}
		
		@Test
		public void testDeckOfCardsIsNotEmpty() {
			
			
			List<String> deckOfCards = new ArrayList<String>();
			
			deckOfCards.add("a");
			deckOfCards.add("b");
			
			
			assertFalse("List is not empty",engine.checkDeckOfCardsEmpty(deckOfCards));	
			
		}
		
		@Test
		public void testDeckOfCardsEmpty() {
			
			
			List<String> deckOfCards = new ArrayList<String>();
			
			deckOfCards.clear();
			
			assertTrue(GameRuleEngine.checkDeckOfCardsEmpty(deckOfCards));	
			
		}
		
		

	
	

}
