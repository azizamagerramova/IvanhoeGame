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
		public void testDidPlayerGetAPurpleToken() {
			
			String tokenColor = "purple";
			String playerName = "Aziza";
			
			assertTrue(engine.didPlayerGetAPurpleToken(tokenColor, playerName));
			assertEquals(engine.playerWhoGotPurple, playerName);
			
		}
		
		@Test
		public void testDistributeTokens() {
			
			boolean flag = false;
			
			String myToken = engine.distributeTokens(tokens);
			for (String token : tokens) {
				if (token.equals(myToken)) {
					flag = false;
				}
				
				else {
					flag = true;
				}
			}
			
			assertTrue(flag);
			
		}
		
		@Test
		public void testDistributeCardsToPlayers() {
			String playerName = "Aziza";
			assertEquals(8, engine.distributeCardsToPlayers(playerName, deckOfColorAndSupporters).size());
			
			
		}


	
	

}
