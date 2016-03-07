package controller;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import config.Config;
import entity.Player;
import networking.ClientApp;
import userinterface.MyBoard;

public class Controller extends JFrame {

	public Player model;
	public static MyBoard view;
	ClientApp clientApp ;

	boolean established = false;

	String firstPlayer  = "";
	String secondPlayer = "";
	String thirdPlayer  = "";


	public Controller(String title, final ClientApp client) { 

		super(title); 

		clientApp = client;
		model = new Player();
		view = new MyBoard(model);

		// Add the view
		getContentPane().add(view);

		view.distribute.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clientApp.send("Token is requested");

			}	
		});

		view.pickCard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientApp.send("Give me a card");
				view.pickCard.setEnabled(false);

			}	
		});

		view.withDraw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clientApp.send("I want to withdraw");

			}	
		});

		view.distributeCards.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clientApp.send("Distribute cards");

			}

		});

		view.done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientApp.send("I am done");
				view.done.setEnabled(false);
			}
		});
		view.tournamentColour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clientApp.send("now pick your colour");

			}	
		});

		view.player1Card1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 1");
				System.out.println("Mouse used");
			}
		});

		view.player1Card2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 2");
				System.out.println("Mouse used");
			}
		});

		view.player1Card3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 3");
				System.out.println("Mouse used");
			}
		});

		view.player1Card4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 4");             
				System.out.println("Mouse used");
			}
		});

		view.player1Card5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 5");
				System.out.println("Mouse used");
			}
		});

		view.player1Card6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 6");
				System.out.println("Mouse used");
			}
		});

		view.player1Card7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 7");
				System.out.println("Mouse used");
			}
		});

		view.player1Card8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 8");
				System.out.println("Mouse used");
			}
		});

		view.player1Card9.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 9");
				System.out.println("Mouse used");
			}
		});


		//PLAYER 2
		view.player2Card1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 1");
				System.out.println("Mouse used");
			}
		});

		view.player2Card2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 2");
				System.out.println("Mouse used");
			}
		});

		view.player2Card3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 3");
				System.out.println("Mouse used");
			}
		});

		view.player2Card4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 4");
				System.out.println("Mouse used");
			}
		});

		view.player2Card5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 5");
				System.out.println("Mouse used");
			}
		});

		view.player2Card6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 6");      
				System.out.println("Mouse used");
			}
		});

		view.player2Card7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 7");
				System.out.println("Mouse used");
			}
		});

		view.player2Card8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 8");
				System.out.println("Mouse used");
			}
		});

		view.player2Card9.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 9");
				System.out.println("Mouse used");
			}
		});


		//PLAYER 3

		view.player3Card1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 1");
				System.out.println("Mouse used");

			}
		});

		view.player3Card2.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 2");

				System.out.println("Mouse used");
			}
		});

		view.player3Card3.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 3");

				System.out.println("Mouse used");
			}
		});

		view.player3Card4.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 4");

				System.out.println("Mouse used");
			}
		});

		view.player3Card5.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 5");
				System.out.println("Mouse used");
			}
		});

		view.player3Card6.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 6");
				System.out.println("Mouse used");
			}
		});

		view.player3Card7.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 7");
				System.out.println("Mouse used");
			}
		});

		view.player3Card8.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 8");
				System.out.println("Mouse used");
			}
		});

		view.player3Card9.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 9");
				System.out.println("Mouse used");
			}
		});


		//PLAYER 4 
		view.player4Card1.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 1");
				System.out.println("Mouse used");
			}
		});

		view.player4Card2.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 2");
				System.out.println("Mouse used");
			}
		});

		view.player4Card3.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 3");
				System.out.println("Mouse used");
			}
		});

		view.player4Card4.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 4");
				System.out.println("Mouse used");
			}
		});

		view.player4Card5.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 5");
				System.out.println("Mouse used");
			}
		});

		view.player4Card6.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 6");
				System.out.println("Mouse used");
			}
		});

		view.player4Card7.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 7");
				System.out.println("Mouse used");
			}
		});

		view.player4Card8.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 8");
				System.out.println("Mouse used");
			}
		});

		view.player4Card9.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 9");
				System.out.println("Mouse used");
			}
		});

		//PLAYER 5

		view.player5Card1.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 1");
				System.out.println("Mouse used");
			}
		});

		view.player5Card2.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 2");
				System.out.println("Mouse used");
			}
		});

		view.player5Card3.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 3");
				System.out.println("Mouse used");
			}
		});

		view.player5Card4.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 4");
				System.out.println("Mouse used");
			}
		});

		view.player5Card5.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 5");
				System.out.println("Mouse used");
			}
		});

		view.player5Card6.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 6");
				System.out.println("Mouse used");
			}
		});

		view.player5Card7.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 7");
				System.out.println("Mouse used");
			}
		});

		view.player5Card8.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 8");
				System.out.println("Mouse used");
			}
		});

		view.player5Card9.addMouseListener(new MouseAdapter() {
			//override the method
			public void mouseClicked(MouseEvent e) {
				clientApp.send("Card was played 9");
			//	System.out.println("Mouse used");
			}
		});
		// Manually computed size
		setSize(1280,800);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void updateScore (String name, String score) {
		String label = view.namesToLabels.get(name);
		if (label.equals("player1")) {
			view.player1faceValue.setText("Total face value: " + score);
			view.player1faceValue.setVisible(true);

		}
		if (label.equals("player2")) {
			view.player2faceValue.setText("Total face value: " + score);
			view.player2faceValue.setVisible(true);

		}

		if (label.equals("player3")) {
			view.player3faceValue.setText("Total face value: " + score);
			view.player3faceValue.setVisible(true);
		}
		if (label.equals("player4")) {
			view.player4faceValue.setText("Total face value: " + score);
			view.player4faceValue.setVisible(true);

		}

		if (label.equals("player5")) {
			view.player5faceValue.setText("Total face value: " + score);
			view.player5faceValue.setVisible(true);		
		}
	}

	public void popUp(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	public void updateDisplay (String card, String playerName) {
		String label  = view.namesToLabels.get(playerName);
		if (label.equals("player1")) {
			ImageIcon icon = new ImageIcon("./img/270_cards/" + card + ".png");
			view.player1Display.setIcon(icon);
			view.player1Display.setVisible(true);
			view.player1Display.setEnabled(true);
		}
		if (label.equals("player2")) {
			ImageIcon icon = new ImageIcon("./img/360_cards/" + card + ".png");
			view.player2display.setIcon(icon);
			view.player2display.setVisible(true);
			view.player2display.setEnabled(true);
		}
		if (label.equals("player3")) {
			ImageIcon icon = new ImageIcon("./img/360_cards/" + card + ".png");
			view.player3display.setIcon(icon);
			view.player3display.setVisible(true);
			view.player3display.setEnabled(true);
		}

		if (label.equals("player4")) {
			ImageIcon icon = new ImageIcon("./img/360_cards/" + card + ".png");
			view.player4display.setIcon(icon);
			view.player4display.setVisible(true);
			view.player4display.setEnabled(true);
		}

		if (label.equals("player5")) {
			ImageIcon icon = new ImageIcon("./img/90_cards/" + card + ".png");
			view.player5display.setIcon(icon);
			view.player5display.setVisible(true);
			view.player5display.setEnabled(true);
		}
	}

	public void updateDisplay (String card1, String card2, String playerName) {
		String label  = view.namesToLabels.get(playerName);
		
		if (label.equals("player1")) {
			ImageIcon icon = new ImageIcon("./img/270_cards/" + card1 + ".png");
			view.player1Display.setIcon(icon);
			view.player1Display.setVisible(true);
			view.player1Display.setEnabled(true);

			ImageIcon icon2 = new ImageIcon("./img/270_cards/" + card2 + ".png");
			view.player1Display2.setIcon(icon2);
			view.player1Display2.setVisible(true);
			view.player1Display2.setEnabled(true);
		}
		
		if (label.equals("player2")) {
			ImageIcon icon = new ImageIcon("./img/360_cards/" + card1 + ".png");
			view.player2display.setIcon(icon);
			view.player2display.setVisible(true);
			view.player2display.setEnabled(true);

			ImageIcon icon2 = new ImageIcon("./img/360_cards/" + card2 + ".png");
			view.player2display2.setIcon(icon2);
			view.player2display2.setVisible(true);
			view.player2display2.setEnabled(true);
		}
		
		if (label.equals("player3")) {
			ImageIcon icon = new ImageIcon("./img/360_cards/" + card1 + ".png");
			view.player3display.setIcon(icon);
			view.player3display.setVisible(true);
			view.player3display.setEnabled(true);

			ImageIcon icon2 = new ImageIcon("./img/360_cards/" + card2 + ".png");
			view.player3display2.setIcon(icon2);
			view.player3display2.setVisible(true);
			view.player3display2.setEnabled(true);
		}
		
		if (label.equals("player4")) {
			ImageIcon icon = new ImageIcon("./img/360_cards/" + card1 + ".png");
			view.player4display.setIcon(icon);
			view.player4display.setVisible(true);
			view.player4display.setEnabled(true);

			ImageIcon icon2 = new ImageIcon("./img/360_cards/" + card2 + ".png");
			view.player4display2.setIcon(icon2);
			view.player4display2.setVisible(true);
			view.player2display2.setEnabled(true);
		}
		
		if (label.equals("player5")) {
			ImageIcon icon = new ImageIcon("./img/90_cards/" + card1 + ".png");
			view.player5display.setIcon(icon);
			view.player5display.setVisible(true);
			view.player5display.setEnabled(true);

			ImageIcon icon2 = new ImageIcon("./img/90_cards/" + card2 + ".png");
			view.player5display2.setIcon(icon2);
			view.player5display2.setVisible(true);
			view.player5display2.setEnabled(true);
		}
	}

	public void addNewCard(String card, String name) {
		String label = view.namesToLabels.get(name);
		
		if (label.equals("player1")) {
			ImageIcon icon = new ImageIcon("./img/270_cards/" + card + ".png");

			if (!view.player1Card1.isEnabled()) {
				view.player1Card1.setIcon(icon);
				view.player1Card1.setEnabled(true);
			}
			else if (!view.player1Card2.isEnabled()) {
				view.player1Card2.setIcon(icon);
				view.player1Card2.setEnabled(true);
			}
			else if (!view.player1Card3.isEnabled()) {
				view.player1Card3.setIcon(icon);
				view.player1Card3.setEnabled(true);
			}
			else if (!view.player1Card4.isEnabled()) {
				view.player1Card4.setIcon(icon);
				view.player1Card4.setEnabled(true);
			}
			else if (!view.player1Card5.isEnabled()) {
				view.player1Card5.setIcon(icon);
				view.player1Card5.setEnabled(true);
			}
			else if (!view.player1Card6.isEnabled()) {
				view.player1Card6.setIcon(icon);
				view.player1Card6.setEnabled(true);
			}
			else if (!view.player1Card7.isEnabled()) {
				view.player1Card7.setIcon(icon);
				view.player1Card7.setEnabled(true);
			}
			else if (!view.player1Card8.isEnabled()) {
				view.player1Card8.setIcon(icon);
				view.player1Card8.setEnabled(true);
			}

			else if (!view.player1Card9.isVisible() || !view.player1Card9.isEnabled()) {
				view.player1Card9.setIcon(icon);
				view.player1Card9.setVisible(true);
				view.player1Card9.setEnabled(true);
			}

			System.out.println("Is my card 9 visible? " + view.player1Card9.isVisible());

		}

		if (label.equals("player2")) {
			ImageIcon icon = new ImageIcon("./img/360_cards/" + card + ".png");

			if (!view.player2Card1.isEnabled()) {
				view.player2Card1.setIcon(icon);
				view.player2Card1.setEnabled(true);
			}
			else if (!view.player2Card2.isEnabled()) {
				view.player2Card2.setIcon(icon);
				view.player2Card2.setEnabled(true);
			}
			else if (!view.player2Card3.isEnabled()) {
				view.player2Card3.setIcon(icon);
				view.player2Card3.setEnabled(true);
			}
			else if (!view.player2Card4.isEnabled()) {
				view.player2Card4.setIcon(icon);
				view.player2Card4.setEnabled(true);
			}
			else if (!view.player2Card5.isEnabled()) {
				view.player2Card5.setIcon(icon);
				view.player2Card5.setEnabled(true);
			}
			else if (!view.player2Card6.isEnabled()) {
				view.player2Card6.setIcon(icon);
				view.player2Card6.setEnabled(true);
			}
			else if (!view.player2Card7.isEnabled()) {
				view.player2Card7.setIcon(icon);
				view.player2Card7.setEnabled(true);
			}
			else if (!view.player2Card8.isEnabled()) {
				view.player2Card8.setIcon(icon);
				view.player2Card8.setEnabled(true);
			}

			else if (!view.player2Card9.isVisible() || !view.player2Card9.isEnabled()) {
				view.player2Card9.setIcon(icon);
				view.player2Card9.setVisible(true);
				view.player2Card9.setEnabled(true);
			}

			System.out.println("Is my card 9 visible? " + view.player1Card9.isVisible());

		}


		if (label.equals("player3")) {

			ImageIcon icon = new ImageIcon("./img/360_cards/" + card + ".png");

			if (!view.player3Card1.isEnabled()) {
				view.player3Card1.setIcon(icon);
				view.player3Card1.setEnabled(true);
			}
			else if (!view.player3Card2.isEnabled()) {
				view.player3Card2.setIcon(icon);
				view.player3Card2.setEnabled(true);
			}
			else if (!view.player3Card3.isEnabled()) {
				view.player3Card3.setIcon(icon);
				view.player3Card3.setEnabled(true);
			}
			else if (!view.player3Card4.isEnabled()) {
				view.player3Card4.setIcon(icon);
				view.player3Card4.setEnabled(true);
			}
			else if (!view.player3Card5.isEnabled()) {
				view.player3Card5.setIcon(icon);
				view.player3Card5.setEnabled(true);
			}
			else if (!view.player3Card6.isEnabled()) {
				view.player3Card6.setIcon(icon);
				view.player3Card6.setEnabled(true);
			}
			else if (!view.player3Card7.isEnabled()) {
				view.player3Card7.setIcon(icon);
				view.player3Card7.setEnabled(true);
			}
			else if (!view.player3Card8.isEnabled()) {
				view.player3Card8.setIcon(icon);
				view.player3Card8.setEnabled(true);
			}

			else if (!view.player3Card9.isVisible() || !view.player3Card9.isEnabled()) {
				view.player3Card9.setIcon(icon);
				view.player3Card9.setVisible(true);
				view.player3Card9.setEnabled(true);
			}

		}

		if (label.equals("player4")) {

			ImageIcon icon = new ImageIcon("./img/360_cards/" + card + ".png");


			if (!view.player4Card1.isEnabled()) {
				view.player4Card1.setIcon(icon);
				view.player4Card1.setEnabled(true);
			}
			else if (!view.player4Card2.isEnabled()) {
				view.player4Card2.setIcon(icon);
				view.player4Card2.setEnabled(true);
			}
			else if (!view.player4Card3.isEnabled()) {
				view.player4Card3.setIcon(icon);
				view.player4Card3.setEnabled(true);
			}
			else if (!view.player4Card4.isEnabled()) {
				view.player4Card4.setIcon(icon);
				view.player4Card4.setEnabled(true);
			}
			else if (!view.player4Card5.isEnabled()) {
				view.player4Card5.setIcon(icon);
				view.player4Card5.setEnabled(true);
			}
			else if (!view.player4Card6.isEnabled()) {
				view.player4Card6.setIcon(icon);
				view.player4Card6.setEnabled(true);
			}
			else if (!view.player4Card7.isEnabled()) {
				view.player4Card7.setIcon(icon);
				view.player4Card7.setEnabled(true);
			}
			else if (!view.player4Card8.isEnabled()) {
				view.player4Card8.setIcon(icon);
				view.player4Card8.setEnabled(true);
			}

			else if (!view.player4Card9.isVisible() || !view.player4Card9.isEnabled()) {
				view.player4Card9.setIcon(icon);
				view.player4Card9.setVisible(true);
				view.player4Card9.setEnabled(true);
			}

		}
		if (label.equals("player5")) {
			ImageIcon icon = new ImageIcon("./img/90_cards/" + card + ".png");
			if (!view.player5Card1.isEnabled()) {
				view.player5Card1.setIcon(icon);
				view.player5Card1.setEnabled(true);
			}
			else if (!view.player5Card2.isEnabled()) {
				view.player5Card2.setIcon(icon);
				view.player5Card2.setEnabled(true);
			}
			else if (!view.player5Card3.isEnabled()) {
				view.player5Card3.setIcon(icon);
				view.player5Card3.setEnabled(true);
			}
			else if (!view.player5Card4.isEnabled()) {
				view.player5Card4.setIcon(icon);
				view.player5Card4.setEnabled(true);
			}
			else if (!view.player5Card5.isEnabled()) {
				view.player5Card5.setIcon(icon);
				view.player5Card5.setEnabled(true);
			}
			else if (!view.player5Card6.isEnabled()) {
				view.player5Card6.setIcon(icon);
				view.player5Card6.setEnabled(true);
			}
			else if (!view.player5Card7.isEnabled()) {
				view.player5Card7.setIcon(icon);
				view.player5Card7.setEnabled(true);
			}

			else if (!view.player5Card9.isVisible() || !view.player5Card9.isEnabled()) {
				view.player5Card9.setIcon(icon);
				view.player5Card9.setVisible(true);
				view.player5Card9.setEnabled(true);
			}

		}

		this.revalidate();
		this.repaint();
	}

	public void enablePickCard() {
		view.pickCard.setEnabled(true);
	}

	public void AddCardToOtherDisplays(String playerName) {
		String label = view.namesToLabels.get(playerName);
		ImageIcon backOfCard = new ImageIcon("./img/ivanhoe_rotated.png");
		ImageIcon backOfCard1 = new ImageIcon("./img/ivanhoe.png");
		if (label.equals("player1")) {
			view.player1Card9.setIcon(backOfCard);
			view.player1Card9.setVisible(true);
			view.player1Card9.setEnabled(true);
		}

		if (label.equals("player2")) {
			view.player2Card9.setIcon(backOfCard1);
			view.player2Card9.setVisible(true);
			view.player2Card9.setEnabled(true);
		}

		if (label.equals("player3")) {
			view.player3Card9.setIcon(backOfCard1);
			view.player3Card9.setVisible(true);
			view.player3Card9.setEnabled(true);

		}

		if (label.equals("player4")) {
			view.player4Card9.setIcon(backOfCard1);
			view.player4Card9.setVisible(true);
			view.player4Card9.setEnabled(true);

		}

		if (label.equals("player5")) {
			view.player5Card9.setIcon(backOfCard);
			view.player5Card9.setVisible(true);
			view.player5Card9.setEnabled(true);

		}


		this.revalidate();
		this.repaint();

	}

	public void popUpNewCard(String cardName) {
		String[] splitIt = cardName.split("_");
		ImageIcon ImageToken = new ImageIcon("./img/360_cards/" + cardName + ".png");
		JOptionPane.showMessageDialog(this, "You got a new " + splitIt[2] + " " + splitIt[1] + " " + splitIt[3] + "!!!", "NEW CARD!", JOptionPane.PLAIN_MESSAGE, ImageToken);


	}
	public void disableAllButtons() {
		view.done.setEnabled(false);
		view.distribute.setEnabled(false);
		view.pickCard.setEnabled(false);
		view.withDraw.setEnabled(false);
	}

	public void withdraw(String name) {
		String label = view.namesToLabels.get(name);

		if (label.equals("player2")) {
			view.player2.setEnabled(false);
			if (view.player2display!=null)
				view.player2display.setEnabled(false);
			if (view.player2display2 != null) 
				view.player2display2.setEnabled(false);

			view.player2nameLabel.setEnabled(false);
			setImageInVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, 
					view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8);
			view.player2Card9.setEnabled(false);
			view.player2token1.setEnabled(false);
			view.player2token2.setEnabled(false);
			view.player2token3.setEnabled(false);
			view.player2token4.setEnabled(false);
		}

		if (label.equals("player1")) {
			view.player1.setEnabled(false);
			if (view.player1Display != null)
				view.player1Display.setEnabled(false);
			if (view.player1Display2 != null) 
				view.player1Display2.setEnabled(false);
			view.player1nameLabel.setEnabled(false);
			setImageInVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, 
					view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);
			view.player1Card9.setEnabled(false);
			view.player1token1.setEnabled(false);
			view.player1token2.setEnabled(false);
			view.player1token3.setEnabled(false);
			view.player1token4.setEnabled(false);

		}


		if (label.equals("player3")) {
			view.player3.setEnabled(false);
			if (view.player3display != null)
				view.player3display.setEnabled(false);
			if (view.player3display2 != null) 
				view.player3display2.setEnabled(false);
			view.player3nameLabel.setEnabled(false);
			setImageInVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, 
					view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8);
			view.player3Card9.setEnabled(false);
			view.player3token1.setEnabled(false);
			view.player3token2.setEnabled(false);
			view.player3token3.setEnabled(false);
			view.player3token4.setEnabled(false);
		}

		if (label.equals("player4")) {
			view.player4.setEnabled(false);
			if (view.player4display != null)
				view.player4display.setEnabled(false);
			if (view.player4display2 != null)
				view.player4display2.setEnabled(false);
			view.player4nameLabel.setEnabled(false);
			setImageInVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, 
					view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8);
			view.player4Card9.setEnabled(false);
			view.player4token1.setEnabled(false);
			view.player4token2.setEnabled(false);
			view.player4token3.setEnabled(false);
			view.player4token4.setEnabled(false);
		}

		if (label.equals("player5")) {
			view.player5.setEnabled(false);
			if (view.player5display != null)
				view.player5display.setEnabled(false);
			if (view.player5display2 != null) 
				view.player5display2.setEnabled(false);
			view.player5nameLabel.setEnabled(false);
			setImageInVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4,
					view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);
			view.player5Card9.setEnabled(false);
			view.player5token1.setEnabled(false);
			view.player5token2.setEnabled(false);
			view.player5token3.setEnabled(false);
			view.player5token4.setEnabled(false);
		}

		popUpNotifyWithdraw(name);

	}

	public void popUpWrongColour() {
		JOptionPane.showMessageDialog(this, "You chose the wrong colour!!!!!");
		clientApp.send("now pick your colour");
	}


	public void popUpNotYourTurn() {
		JOptionPane.showMessageDialog(this, "NOT YOUR TURN!!!", "It's not your turn to play", JOptionPane.PLAIN_MESSAGE);
	}


	public void setvisibilityForPlayerName(String playerName1, String playerName2, String playerName3) {

		if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 3) {

			view.player1nameLabel.setText(playerName1);
			view.player1nameLabel.setVisible(true);

			view.player3nameLabel.setText(playerName2);
			view.player3nameLabel.setVisible(true);	

			view.player5nameLabel.setText(playerName3);
			view.player5nameLabel.setVisible(true);
		}
	}

	public void setvisibilityFor2PlayerName(String playerName1, String playerName2) {
		if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 2) {

			view.player1nameLabel.setText(playerName1);
			view.player1nameLabel.setVisible(true);

			view.player5nameLabel.setText(playerName2);
			view.player5nameLabel.setVisible(true);	
		}
	}

	public void setvisibilityFor4PlayerName(String playerName1, String playerName2, String playerName3, String playerName4) {

		if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 4) {

			view.player1nameLabel.setText(playerName1);
			view.player1nameLabel.setVisible(true);

			view.player2nameLabel.setText(playerName2);
			view.player2nameLabel.setVisible(true);	

			view.player4nameLabel.setText(playerName3);
			view.player4nameLabel.setVisible(true);

			view.player5nameLabel.setText(playerName4);
			view.player5nameLabel.setVisible(true);
		}
	}

	public void setvisibilityFor5PlayerName(String playerName1, String playerName2, String playerName3, String playerName4, String playerName5) {

		if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 5) {

			view.player1nameLabel.setText(playerName1);
			view.player1nameLabel.setVisible(true);

			view.player2nameLabel.setText(playerName2);
			view.player2nameLabel.setVisible(true);	

			view.player3nameLabel.setText(playerName3);
			view.player3nameLabel.setVisible(true);

			view.player4nameLabel.setText(playerName4);
			view.player4nameLabel.setVisible(true);

			view.player5nameLabel.setText(playerName5);
			view.player5nameLabel.setVisible(true);
		}
	}


	public void enableDone() {
		view.done.setEnabled(true);
	}
	public void disableCardPlayed(String number, String player) {
		String label = view.namesToLabels.get(player);
		if(label.equals("player1")) {

			if (number.equals("1")) 
				view.player1Card1.setEnabled(false);
			if (number.equals("2")) 
				view.player1Card2.setEnabled(false);
			if (number.equals("3")) 
				view.player1Card3.setEnabled(false);
			if (number.equals("4")) 
				view.player1Card4.setEnabled(false);
			if (number.equals("5")) 
				view.player1Card5.setEnabled(false);
			if (number.equals("6")) 
				view.player1Card6.setEnabled(false);
			if (number.equals("7")) 
				view.player1Card7.setEnabled(false);
			if (number.equals("8")) 
				view.player1Card8.setEnabled(false);
			if (number.equals("9")) 
				view.player1Card9.setEnabled(false);
		}
		if(label.equals("player2")) {

			if (number.equals("1")) 
				view.player2Card1.setEnabled(false);
			if (number.equals("2")) 
				view.player2Card2.setEnabled(false);
			if (number.equals("3")) 
				view.player2Card3.setEnabled(false);
			if (number.equals("4")) 
				view.player2Card4.setEnabled(false);
			if (number.equals("5")) 
				view.player2Card5.setEnabled(false);
			if (number.equals("6")) 
				view.player2Card6.setEnabled(false);
			if (number.equals("7")) 
				view.player2Card7.setEnabled(false);
			if (number.equals("8")) 
				view.player2Card8.setEnabled(false);
			if (number.equals("9")) 
				view.player2Card9.setEnabled(false);
		}

		if (label.equals("player3")) {
			if (number.equals("1")) 
				view.player3Card1.setEnabled(false);
			if (number.equals("2")) 
				view.player3Card2.setEnabled(false);
			if (number.equals("3")) 
				view.player3Card3.setEnabled(false);
			if (number.equals("4")) 
				view.player3Card4.setEnabled(false);
			if (number.equals("5")) 
				view.player3Card5.setEnabled(false);
			if (number.equals("6")) 
				view.player3Card6.setEnabled(false);
			if (number.equals("7")) 
				view.player3Card7.setEnabled(false);
			if (number.equals("8")) 
				view.player3Card8.setEnabled(false);
			if (number.equals("9")) 
				view.player3Card9.setEnabled(false);
		}

		if (label.equals("player5")) {
			if (number.equals("1")) 
				view.player5Card1.setEnabled(false);
			if (number.equals("2")) 
				view.player5Card2.setEnabled(false);
			if (number.equals("3")) 
				view.player5Card3.setEnabled(false);
			if (number.equals("4")) 
				view.player5Card4.setEnabled(false);
			if (number.equals("5")) 
				view.player5Card5.setEnabled(false);
			if (number.equals("6")) 
				view.player5Card6.setEnabled(false);
			if (number.equals("7")) 
				view.player5Card7.setEnabled(false);
			if (number.equals("8")) 
				view.player5Card8.setEnabled(false);
			if (number.equals("9")) 
				view.player5Card9.setEnabled(false);
		}

		if (label.equals("player4")) {
			if (number.equals("1")) 
				view.player4Card1.setEnabled(false);
			if (number.equals("2")) 
				view.player4Card2.setEnabled(false);
			if (number.equals("3")) 
				view.player4Card3.setEnabled(false);
			if (number.equals("4")) 
				view.player4Card4.setEnabled(false);
			if (number.equals("5")) 
				view.player4Card5.setEnabled(false);
			if (number.equals("6")) 
				view.player4Card6.setEnabled(false);
			if (number.equals("7")) 
				view.player4Card7.setEnabled(false);
			if (number.equals("8")) 
				view.player4Card8.setEnabled(false);
			if (number.equals("9")) 
				view.player4Card9.setEnabled(false);
		}
	}
	public void updatePlayers(String allPlayers, int numberOfPlayers) {
		if ((Config.NUMBER_OF_PLAYERS_SPECIFIED == 2)) {
			String[] splitIt = allPlayers.split(" ");
			if (numberOfPlayers == 1) {
				view.player1.setVisible(true);
			}

			else if(numberOfPlayers == 2) {
				view.player1.setVisible(true);
				view.player5.setVisible(true);
				String player1Name = splitIt[4];
				String player5Name = splitIt[5];
				view.namesToLabels.put(player1Name, "player1");
				view.namesToLabels.put(player5Name, "player5");
			}
		}
		if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 3) {
			String[] splitIt = allPlayers.split(" ");

			if (numberOfPlayers == 1) {
				view.player1.setVisible(true);
			}

			else if(numberOfPlayers == 2) {
				view.player1.setVisible(true);
				view.player3.setVisible(true);
			}

			else if(numberOfPlayers == 3) {
				String player1Name = splitIt[4];
				String player3Name = splitIt[5];
				String player5Name = splitIt[6];
				view.player1.setVisible(true);
				view.player3.setVisible(true);
				view.player5.setVisible(true);
				view.namesToLabels.put(player1Name, "player1");
				view.namesToLabels.put(player3Name, "player3");
				view.namesToLabels.put(player5Name, "player5");
			}

		}


		else if (Config.NUMBER_OF_PLAYERS_SPECIFIED == 4) {
			String[] splitIt = allPlayers.split(" ");

			if (numberOfPlayers == 1) {
				view.player1.setVisible(true);
			}

			else if(numberOfPlayers == 2) {
				view.player1.setVisible(true);
				view.player2.setVisible(true);
			}

			else if(numberOfPlayers == 3) {
				view.player1.setVisible(true);
				view.player2.setVisible(true);
				view.player4.setVisible(true);

			}

			else if(numberOfPlayers == 4) {
				String player1Name = splitIt[4];
				String player2Name = splitIt[5];
				String player4Name = splitIt[6];
				String player5Name = splitIt[7];
				view.player1.setVisible(true);
				view.player2.setVisible(true);
				view.player4.setVisible(true);
				view.player5.setVisible(true);
				view.namesToLabels.put(player1Name, "player1");
				view.namesToLabels.put(player2Name, "player2");
				view.namesToLabels.put(player4Name, "player4");
				System.out.println("Player 4 Name is " + player4Name + view.namesToLabels.get(player4Name));
				view.namesToLabels.put(player5Name, "player5");
			}
		}

		else{
			if (Config.NUMBER_OF_PLAYERS_SPECIFIED == 5) {
				String[] splitIt = allPlayers.split(" ");

				if (numberOfPlayers == 1) {
					view.player1.setVisible(true);
				}

				else if(numberOfPlayers == 2) {
					view.player1.setVisible(true);
					view.player2.setVisible(true);
				}

				else if(numberOfPlayers == 3) {
					view.player1.setVisible(true);
					view.player2.setVisible(true);
					view.player3.setVisible(true);
				}

				else if(numberOfPlayers == 4) {
					view.player1.setVisible(true);
					view.player2.setVisible(true);
					view.player4.setVisible(true);
					view.player5.setVisible(true);
				}

				else if(numberOfPlayers == 5) {
					String player1Name = splitIt[4];
					String player2Name = splitIt[5];
					String player3Name = splitIt[6];
					String player4Name = splitIt[7];
					String player5Name = splitIt[8];
					view.player1.setVisible(true);
					view.player2.setVisible(true);
					view.player3.setVisible(true);
					view.player4.setVisible(true);
					view.player5.setVisible(true);
					view.namesToLabels.put(player1Name, "player1");
					view.namesToLabels.put(player2Name, "player2");
					view.namesToLabels.put(player3Name, "player3");
					view.namesToLabels.put(player4Name, "player4");
					view.namesToLabels.put(player5Name, "player5");
				}
			}
		}


	}


	public void DisplayPickAToken () {
		view.distribute.setEnabled(true);
	}


	public void popUpTokenGenerated(String tokenColor) {

		if(tokenColor.equals("purple")) {
			ImageIcon purpleImageToken = new ImageIcon("./img/purple_token.png");
			JOptionPane.showMessageDialog(this, "You got a " + tokenColor + " token,\nYou will be the one to distribute the cards", tokenColor.toUpperCase() + " TOKEN!!", JOptionPane.PLAIN_MESSAGE, purpleImageToken);
		}

		else {
			ImageIcon randomIcons = new ImageIcon("./img/" + tokenColor +"_token.png");
			JOptionPane.showMessageDialog(this, "You got a " + tokenColor + " token", tokenColor.toUpperCase() + " TOKEN!!", JOptionPane.PLAIN_MESSAGE, randomIcons);
		}
		view.distribute.setEnabled(false);
	}


	public void popUpForTournamentColour(String tournamentColour) {
		view.tournamentColour1.setText( tournamentColour);
		view.tournamentColour1.setVisible(true);
		view.tournament.setVisible(true);
		ImageIcon randomIcons = new ImageIcon("./img/" + tournamentColour +"_token.png");
		JOptionPane.showMessageDialog(this, "This tournament colour for this tournament is " + tournamentColour.toUpperCase(), tournamentColour.toUpperCase() + " TOURNAMENT!!", JOptionPane.PLAIN_MESSAGE, randomIcons);
	}

	public void notifyPlayerToStartTournamentToChooseColour() {
		JOptionPane.showMessageDialog(this, "Click on the mulit colour button below to select a color for the tournament", "Choose Tournament Color", JOptionPane.PLAIN_MESSAGE);
	}

	public void enableButtonForDistributeCard() {
		view.distributeCards.setEnabled(true);
	}

	public void disableButtonForDistributeCard() {
		view.distributeCards.setEnabled(false);
	}

	public void enableWithDrawButtonForAllPlayers() {
		view.withDraw.setEnabled(true);
	}

	public void enableTournamentColourButton() {
		view.tournamentColour.setEnabled(true);
	}

	public void popUpNotifyWithdraw(String name) {
		JOptionPane.showMessageDialog(this, name + " left the game", "Ouups. Someone left", JOptionPane.PLAIN_MESSAGE);
	}

	public void popUpMenuToChooseTournamentColor() {

		String[] choices = {"RED", "PURPLE", "GREEN", "YELLOW", "BLUE"};
		String input     = (String) JOptionPane.showInputDialog(null, "Select the tournament colour", "Tournament Colour", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);

		/* Send this colour to the server */
		clientApp.send("colour tournament " + input);
		view.tournamentColour.setEnabled(false);
	}

	public void popUpMenuToRemoveToken(String tokens, String message) {
		String[] splitIt = tokens.split("_");
		String[] choices = new String[5];
		if (splitIt.length == 1) {
			choices[0] = splitIt[0];
		}

		else if (splitIt.length ==2) {
			System.out.println("That what i got as an input " + splitIt[0]);
			System.out.println("That what i got as an input " + splitIt[1]);
			choices[0] = splitIt[0];
			choices[1] = splitIt[1];
		}

		else if (splitIt.length == 3) {
			//String[] choices = {"", "",""};
			choices[0] = splitIt[0];
			choices[1] = splitIt[1];
			choices[2] = splitIt[2];
		}

		else if (splitIt.length == 4) {
			//String[] choices = {"", "", "", ""};
			choices[0] = splitIt[0];
			choices[1] = splitIt[1];
			choices[2] = splitIt[2];
			choices[3] = splitIt[3];
		}
		String input     = (String) JOptionPane.showInputDialog(null, message, "Maiden on a display!", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
		for (int i = 0;i<choices.length;i++) {
			if (input.equals(choices[i])) {
				clientApp.send("I chose to remove " + input);
			}
		}

		clientApp.send("I want to withdraw");

	}

	public void removeTokenAllDisplays(String playerName, String TokenColorToRemove) {
		String label = view.namesToLabels.get(playerName);

		System.out.println("Label of player " + playerName + ": " + label);
		
		if (label.equals("player1")) {
			if (TokenColorToRemove.equalsIgnoreCase("red")) {
				view.player1token1.setVisible(false);
				System.out.println("here we are disabling first token");
			}
			if (TokenColorToRemove.equalsIgnoreCase("blue")) {
				view.player1token2.setVisible(false);
			}
			if (TokenColorToRemove.equalsIgnoreCase("green")) {
				view.player1token3.setVisible(false);
			}
			if (TokenColorToRemove.equalsIgnoreCase("yellow")) {
				view.player1token4.setVisible(false);
			}

		}
		
		if (label.equals("player2")) {
			if (TokenColorToRemove.equalsIgnoreCase("red")) {
				view.player2token1.setVisible(false);
				System.out.println("here we are disabling first token");
			}
			if (TokenColorToRemove.equalsIgnoreCase("blue")) {
				view.player2token2.setVisible(false);
			}
			if (TokenColorToRemove.equalsIgnoreCase("green")) {
				view.player2token3.setVisible(false);
			}
			if (TokenColorToRemove.equalsIgnoreCase("yellow")) {
				view.player2token4.setVisible(false);
			}

		}

		if (label.equals("player3")) {
			if (TokenColorToRemove.equalsIgnoreCase("red")) {
				view.player3token1.setVisible(false);
				System.out.println("here we are disabling first token");
			}
			if (TokenColorToRemove.equalsIgnoreCase("blue")) {
				view.player3token2.setVisible(false);
			}
			if (TokenColorToRemove.equalsIgnoreCase("green")) {
				view.player3token3.setVisible(false);
			}
			if (TokenColorToRemove.equalsIgnoreCase("yellow")) {
				view.player3token4.setVisible(false);
			}
		}
		
		if (label.equals("player4")) {
			if (TokenColorToRemove.equalsIgnoreCase("red")) {
				view.player4token1.setVisible(false);
				System.out.println("here we are disabling first token");
			}
			if (TokenColorToRemove.equalsIgnoreCase("blue")) {
				view.player4token2.setVisible(false);
			}
			if (TokenColorToRemove.equalsIgnoreCase("green")) {
				view.player4token3.setVisible(false);
			}
			if (TokenColorToRemove.equalsIgnoreCase("yellow")) {
				view.player4token4.setVisible(false);
			}
		}

		if (label.equals("player5")) {
			if (TokenColorToRemove.equalsIgnoreCase("red")) {
				view.player5token1.setVisible(false);
				System.out.println("here we are disabling first token");
			}
			if (TokenColorToRemove.equalsIgnoreCase("blue")) {
				view.player5token2.setVisible(false);
			}
			if (TokenColorToRemove.equalsIgnoreCase("green")) {
				view.player5token3.setVisible(false);
			}
			if (TokenColorToRemove.equalsIgnoreCase("yellow")) {
				view.player5token4.setVisible(false);
			}
		}
	}

	public void setTournamentNumber(String tournamentNumber) {
		view.tournamentNo.setText(tournamentNumber);
		this.revalidate();
		this.repaint();
	}

	public void popUpMenuToChooseTournamentColorAfterTournament () {

		String[] choices = {"RED", "GREEN", "YELLOW", "BLUE"};
		String input     = (String) JOptionPane.showInputDialog(null, "Select the tournament colour", "Tournament Colour", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);

		/* Send this color to the server */
		clientApp.send("colour tournament " + input);
		view.tournamentColour.setEnabled(false);
	}

	public void popUpToNotifyAlreadyHaveToken() {
		JOptionPane.showMessageDialog(this, "You already have this token. You are the Winner of this tournament.", "TOKEN ALERT!!", JOptionPane.PLAIN_MESSAGE);
	}

	public void EnableHandForEveryone() {
		if (Config.NUMBER_OF_PLAYERS_SPECIFIED == 2) {
			setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);
			setImageCardVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);


			view.player1Card9.setVisible(false);
			view.player1Card9.setEnabled(false);
			view.player1Display.setVisible(false);
			view.player1Display2.setVisible(false);
			view.player1faceValue.setVisible(false);

			// show all tokens players won so far
			view.player1token1.setEnabled(true);
			view.player1token2.setEnabled(true);
			view.player1token3.setEnabled(true);
			view.player1token4.setEnabled(true);



			view.player5token1.setEnabled(true);
			view.player5token2.setEnabled(true);
			view.player5token3.setEnabled(true);
			view.player5token4.setEnabled(true);

			view.player5Card9.setVisible(false);
			view.player5Card9.setEnabled(false);
			view.player5display.setVisible(false);
			view.player5display2.setVisible(false);
			view.player5faceValue.setVisible(false);

			setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);
			setImageCardVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

		}
		if (Config.NUMBER_OF_PLAYERS_SPECIFIED == 3) {
			setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);
			setImageCardVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);


			view.player1Card9.setVisible(false);
			view.player1Card9.setEnabled(false);
			view.player1Display.setVisible(false);
			view.player1Display2.setVisible(false);
			view.player1faceValue.setVisible(false);

			// show all tokens players won so far
			view.player1token1.setEnabled(true);
			view.player1token2.setEnabled(true);
			view.player1token3.setEnabled(true);
			view.player1token4.setEnabled(true);


			view.player3token1.setEnabled(true);
			view.player3token2.setEnabled(true);
			view.player3token3.setEnabled(true);
			view.player3token4.setEnabled(true);

			view.player5token1.setEnabled(true);
			view.player5token2.setEnabled(true);
			view.player5token3.setEnabled(true);
			view.player5token4.setEnabled(true);

			view.player3display.setVisible(false);
			view.player3Card9.setEnabled(false);
			view.player3Card9.setVisible(false);
			view.player3display2.setVisible(false);
			view.player3faceValue.setVisible(false);

			view.player5Card9.setVisible(false);
			view.player5Card9.setEnabled(false);
			view.player5display.setVisible(false);
			view.player5display2.setVisible(false);
			view.player5faceValue.setVisible(false);

			setImageVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8);
			setImageCardVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8);

			setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);
			setImageCardVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

		}
		if (Config.NUMBER_OF_PLAYERS_SPECIFIED == 5) {
			setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);
			setImageCardVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);


			view.player1Card9.setVisible(false);
			view.player1Card9.setEnabled(false);
			view.player1Display.setVisible(false);
			view.player1Display2.setVisible(false);
			view.player1faceValue.setVisible(false);

			// show all tokens players won so far
			view.player1token1.setEnabled(true);
			view.player1token2.setEnabled(true);
			view.player1token3.setEnabled(true);
			view.player1token4.setEnabled(true);


			view.player3token1.setEnabled(true);
			view.player3token2.setEnabled(true);
			view.player3token3.setEnabled(true);
			view.player3token4.setEnabled(true);

			view.player3display.setVisible(false);
			view.player3Card9.setEnabled(false);
			view.player3Card9.setVisible(false);
			view.player3display2.setVisible(false);
			view.player3faceValue.setVisible(false);
			
			view.player2token1.setEnabled(true);
			view.player2token2.setEnabled(true);
			view.player2token3.setEnabled(true);
			view.player2token4.setEnabled(true);

			view.player5token1.setEnabled(true);
			view.player5token2.setEnabled(true);
			view.player5token3.setEnabled(true);
			view.player5token4.setEnabled(true);

			view.player2display.setVisible(false);
			view.player2Card9.setEnabled(false);
			view.player2Card9.setVisible(false);
			view.player2display2.setVisible(false);
			view.player2faceValue.setVisible(false);
			
			view.player4token1.setEnabled(true);
			view.player4token2.setEnabled(true);
			view.player4token3.setEnabled(true);
			view.player4token4.setEnabled(true);

			view.player4display.setVisible(false);
			view.player4Card9.setEnabled(false);
			view.player4Card9.setVisible(false);
			view.player4display2.setVisible(false);
			view.player4faceValue.setVisible(false);

			view.player5Card9.setVisible(false);
			view.player5Card9.setEnabled(false);
			view.player5display.setVisible(false);
			view.player5display2.setVisible(false);
			view.player5faceValue.setVisible(false);
			
			setImageVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8);
			setImageCardVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8);


			setImageVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8);
			setImageCardVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8);

			setImageVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8);
			setImageCardVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8);
			
			setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);
			setImageCardVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

		}
		
		if (Config.NUMBER_OF_PLAYERS_SPECIFIED == 4) {
			setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);
			setImageCardVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);


			view.player1Card9.setVisible(false);
			view.player1Card9.setEnabled(false);
			view.player1Display.setVisible(false);
			view.player1Display2.setVisible(false);
			view.player1faceValue.setVisible(false);

			// show all tokens players won so far
			view.player1token1.setEnabled(true);
			view.player1token2.setEnabled(true);
			view.player1token3.setEnabled(true);
			view.player1token4.setEnabled(true);


			view.player2token1.setEnabled(true);
			view.player2token2.setEnabled(true);
			view.player2token3.setEnabled(true);
			view.player2token4.setEnabled(true);

			view.player5token1.setEnabled(true);
			view.player5token2.setEnabled(true);
			view.player5token3.setEnabled(true);
			view.player5token4.setEnabled(true);

			view.player2display.setVisible(false);
			view.player2Card9.setEnabled(false);
			view.player2Card9.setVisible(false);
			view.player2display2.setVisible(false);
			view.player2faceValue.setVisible(false);
			
			view.player4token1.setEnabled(true);
			view.player4token2.setEnabled(true);
			view.player4token3.setEnabled(true);
			view.player4token4.setEnabled(true);

			view.player4display.setVisible(false);
			view.player4Card9.setEnabled(false);
			view.player4Card9.setVisible(false);
			view.player4display2.setVisible(false);
			view.player4faceValue.setVisible(false);

			view.player5Card9.setVisible(false);
			view.player5Card9.setEnabled(false);
			view.player5display.setVisible(false);
			view.player5display2.setVisible(false);
			view.player5faceValue.setVisible(false);

			setImageVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8);
			setImageCardVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8);

			setImageVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8);
			setImageCardVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8);
			
			setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);
			setImageCardVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

		}
		
	}

	public void setVisibilityForWithDrawnPlayersToTrue(String input) {
		if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 3) {
			/* This will enable us know how many players to enable when we split the string */
			String[] splitIt = input.split(" ");

			String player1ToEnable = splitIt[7];
			String player2ToEnable = splitIt[8];

			for (String s : view.namesToLabels.keySet()) {
				if(player1ToEnable.equals(s)) {

					String keyValue = view.namesToLabels.get(s);

					if(keyValue.equals("player1")) {
						System.out.println("Key Value1 is " + keyValue);
						view.player1.setEnabled(true);
						view.player1nameLabel.setEnabled(true);

						setImageCardVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, 
								view.player1Card6, view.player1Card7, view.player1Card8);

					}

					else if(keyValue.equals("player2")) {
						view.player2.setEnabled(true);
						view.player2nameLabel.setEnabled(true);

						setImageCardVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, 
								view.player2Card6, view.player2Card7, view.player2Card8);
					}

					else if(keyValue.equals("player3")) {
						view.player3.setEnabled(true);
						view.player3nameLabel.setEnabled(true);

						setImageCardVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, 
								view.player3Card6, view.player3Card7, view.player3Card8);
					}

					else if(keyValue.equals("player4")) {
						view.player4.setEnabled(true);
						view.player4nameLabel.setEnabled(true);

						setImageCardVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, 
								view.player4Card6, view.player4Card7, view.player4Card8);
					}

					else if(keyValue.equals("player5")) {
						view.player5.setEnabled(true);
						view.player5nameLabel.setEnabled(true);

						setImageCardVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, 
								view.player5Card6, view.player5Card7, view.player5Card8);
					}
				}
			}


			for (String s : view.namesToLabels.keySet()) {

				if(player2ToEnable.equals(s)) {
					String keyValue = view.namesToLabels.get(s);

					/* This is for the second guy */
					if(keyValue.equals("player1")) {
						view.player1.setEnabled(true);
						view.player1nameLabel.setEnabled(true);

						setImageCardVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, 
								view.player1Card6, view.player1Card7, view.player1Card8);
					}

					else if(keyValue.equals("player2")) {
						view.player2.setEnabled(true);
						view.player2nameLabel.setEnabled(true);

						setImageCardVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, 
								view.player2Card6, view.player2Card7, view.player2Card8);
					}

					else if(keyValue.equals("player3")) {
						view.player3.setEnabled(true);
						view.player3nameLabel.setEnabled(true);

						setImageCardVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, 
								view.player3Card6, view.player3Card7, view.player3Card8);
					}

					else if(keyValue.equals("player4")) {
						view.player4.setEnabled(true);
						view.player4nameLabel.setEnabled(true);

						setImageCardVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, 
								view.player4Card6, view.player4Card7, view.player4Card8);
					}

					else if(keyValue.equals("player5")) {
						view.player5.setEnabled(true);
						view.player5nameLabel.setEnabled(true);

						setImageCardVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, 
								view.player5Card6, view.player5Card7, view.player5Card8);
					}
				}
			}
		}
		
		if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 2) {
			/* This will enable us know how many players to enable when we split the string */
			String[] splitIt = input.split(" ");

			String player1ToEnable = splitIt[7];

			for (String s : view.namesToLabels.keySet()) {
				if(player1ToEnable.equals(s)) {

					String keyValue = view.namesToLabels.get(s);

					if(keyValue.equals("player1")) {
						System.out.println("Key Value1 is " + keyValue);
						view.player1.setEnabled(true);
						view.player1nameLabel.setEnabled(true);

						setImageCardVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, 
								view.player1Card6, view.player1Card7, view.player1Card8);

					}

					else if(keyValue.equals("player2")) {
						view.player2.setEnabled(true);
						view.player2nameLabel.setEnabled(true);

						setImageCardVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, 
								view.player2Card6, view.player2Card7, view.player2Card8);
					}

					else if(keyValue.equals("player3")) {
						view.player3.setEnabled(true);
						view.player3nameLabel.setEnabled(true);

						setImageCardVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, 
								view.player3Card6, view.player3Card7, view.player3Card8);
					}

					else if(keyValue.equals("player4")) {
						view.player4.setEnabled(true);
						view.player4nameLabel.setEnabled(true);

						setImageCardVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, 
								view.player4Card6, view.player4Card7, view.player4Card8);
					}

					else if(keyValue.equals("player5")) {
						view.player5.setEnabled(true);
						view.player5nameLabel.setEnabled(true);

						setImageCardVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, 
								view.player5Card6, view.player5Card7, view.player5Card8);
					}
				}
			}
		}

		if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 4) {
			/* This will enable us know how many players to enable when we split the string */
			String[] splitIt = input.split(" ");

			String player1ToEnable = splitIt[7];
			String player2ToEnable = splitIt[8];
			String player3ToEnable = splitIt[9];

			System.out.println("Player 1 " + player1ToEnable + "It's corresponding label " + view.namesToLabels.get(player1ToEnable));
			System.out.println("Player 2 " + player2ToEnable + "It's corresponding label " + view.namesToLabels.get(player2ToEnable));
			System.out.println("Player 3 " + player3ToEnable + "It's corresponding label " + view.namesToLabels.get(player3ToEnable));
			
			
			for (String s : view.namesToLabels.keySet()) {
				if(player1ToEnable.equals(s)) {

					String keyValue = view.namesToLabels.get(s);

					if(keyValue.equals("player1")) {
						System.out.println("Key Value1 is " + keyValue);
						view.player1.setEnabled(true);
						view.player1nameLabel.setEnabled(true);

						setImageCardVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, 
								view.player1Card6, view.player1Card7, view.player1Card8);

					}

					else if(keyValue.equals("player2")) {
						view.player2.setEnabled(true);
						view.player2nameLabel.setEnabled(true);

						setImageCardVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, 
								view.player2Card6, view.player2Card7, view.player2Card8);
					}

					else if(keyValue.equals("player3")) {
						view.player3.setEnabled(true);
						view.player3nameLabel.setEnabled(true);

						setImageCardVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, 
								view.player3Card6, view.player3Card7, view.player3Card8);
					}

					else if(keyValue.equals("player4")) {
						view.player4.setEnabled(true);
						view.player4nameLabel.setEnabled(true);

						setImageCardVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, 
								view.player4Card6, view.player4Card7, view.player4Card8);
					}

					else if(keyValue.equals("player5")) {
						view.player5.setEnabled(true);
						view.player5nameLabel.setEnabled(true);

						setImageCardVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, 
								view.player5Card6, view.player5Card7, view.player5Card8);
					}
				}
			}
			for (String s : view.namesToLabels.keySet()) {

				if(player2ToEnable.equals(s)) {
					String keyValue = view.namesToLabels.get(s);

					/* This is for the second guy */
					if(keyValue.equals("player1")) {
						view.player1.setEnabled(true);
						view.player1nameLabel.setEnabled(true);

						setImageCardVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, 
								view.player1Card6, view.player1Card7, view.player1Card8);
					}

					else if(keyValue.equals("player2")) {
						view.player2.setEnabled(true);
						view.player2nameLabel.setEnabled(true);

						setImageCardVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, 
								view.player2Card6, view.player2Card7, view.player2Card8);
					}

					else if(keyValue.equals("player3")) {
						view.player3.setEnabled(true);
						view.player3nameLabel.setEnabled(true);

						setImageCardVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, 
								view.player3Card6, view.player3Card7, view.player3Card8);
					}

					else if(keyValue.equals("player4")) {
						view.player4.setEnabled(true);
						view.player4nameLabel.setEnabled(true);

						setImageCardVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, 
								view.player4Card6, view.player4Card7, view.player4Card8);
					}

					else if(keyValue.equals("player5")) {
						view.player5.setEnabled(true);
						view.player5nameLabel.setEnabled(true);

						setImageCardVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, 
								view.player5Card6, view.player5Card7, view.player5Card8);
					}
				}
			}
			
			for (String s : view.namesToLabels.keySet()) {

				if(player3ToEnable.equals(s)) {
					String keyValue = view.namesToLabels.get(s);

					/* This is for the second guy */
					if(keyValue.equals("player1")) {
						view.player1.setEnabled(true);
						view.player1nameLabel.setEnabled(true);

						setImageCardVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, 
								view.player1Card6, view.player1Card7, view.player1Card8);
					}

					else if(keyValue.equals("player2")) {
						view.player2.setEnabled(true);
						view.player2nameLabel.setEnabled(true);

						setImageCardVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, 
								view.player2Card6, view.player2Card7, view.player2Card8);
					}

					else if(keyValue.equals("player3")) {
						view.player3.setEnabled(true);
						view.player3nameLabel.setEnabled(true);

						setImageCardVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, 
								view.player3Card6, view.player3Card7, view.player3Card8);
					}

					else if(keyValue.equals("player4")) {
						view.player4.setEnabled(true);
						view.player4nameLabel.setEnabled(true);

						setImageCardVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, 
								view.player4Card6, view.player4Card7, view.player4Card8);
					}

					else if(keyValue.equals("player5")) {
						view.player5.setEnabled(true);
						view.player5nameLabel.setEnabled(true);

						setImageCardVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, 
								view.player5Card6, view.player5Card7, view.player5Card8);
					}
				}
			}
		}
		
		if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 5) {
			/* This will enable us know how many players to enable when we split the string */
			String[] splitIt = input.split(" ");

			String player1ToEnable = splitIt[7];
			String player2ToEnable = splitIt[8];
			String player3ToEnable = splitIt[9];
			String player4ToEnable = splitIt[10];

			System.out.println("Player 1 " + player1ToEnable + "It's corresponding label " + view.namesToLabels.get(player1ToEnable));
			System.out.println("Player 2 " + player2ToEnable + "It's corresponding label " + view.namesToLabels.get(player2ToEnable));
			System.out.println("Player 3 " + player3ToEnable + "It's corresponding label " + view.namesToLabels.get(player3ToEnable));
			
			
			for (String s : view.namesToLabels.keySet()) {
				if(player1ToEnable.equals(s)) {

					String keyValue = view.namesToLabels.get(s);

					if(keyValue.equals("player1")) {
						System.out.println("Key Value1 is " + keyValue);
						view.player1.setEnabled(true);
						view.player1nameLabel.setEnabled(true);

						setImageCardVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, 
								view.player1Card6, view.player1Card7, view.player1Card8);

					}

					else if(keyValue.equals("player2")) {
						view.player2.setEnabled(true);
						view.player2nameLabel.setEnabled(true);

						setImageCardVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, 
								view.player2Card6, view.player2Card7, view.player2Card8);
					}

					else if(keyValue.equals("player3")) {
						view.player3.setEnabled(true);
						view.player3nameLabel.setEnabled(true);

						setImageCardVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, 
								view.player3Card6, view.player3Card7, view.player3Card8);
					}

					else if(keyValue.equals("player4")) {
						view.player4.setEnabled(true);
						view.player4nameLabel.setEnabled(true);

						setImageCardVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, 
								view.player4Card6, view.player4Card7, view.player4Card8);
					}

					else if(keyValue.equals("player5")) {
						view.player5.setEnabled(true);
						view.player5nameLabel.setEnabled(true);

						setImageCardVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, 
								view.player5Card6, view.player5Card7, view.player5Card8);
					}
				}
			}
			for (String s : view.namesToLabels.keySet()) {
				if(player4ToEnable.equals(s)) {

					String keyValue = view.namesToLabels.get(s);

					if(keyValue.equals("player1")) {
						System.out.println("Key Value1 is " + keyValue);
						view.player1.setEnabled(true);
						view.player1nameLabel.setEnabled(true);

						setImageCardVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, 
								view.player1Card6, view.player1Card7, view.player1Card8);

					}

					else if(keyValue.equals("player2")) {
						view.player2.setEnabled(true);
						view.player2nameLabel.setEnabled(true);

						setImageCardVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, 
								view.player2Card6, view.player2Card7, view.player2Card8);
					}

					else if(keyValue.equals("player3")) {
						view.player3.setEnabled(true);
						view.player3nameLabel.setEnabled(true);

						setImageCardVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, 
								view.player3Card6, view.player3Card7, view.player3Card8);
					}

					else if(keyValue.equals("player4")) {
						view.player4.setEnabled(true);
						view.player4nameLabel.setEnabled(true);

						setImageCardVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, 
								view.player4Card6, view.player4Card7, view.player4Card8);
					}

					else if(keyValue.equals("player5")) {
						view.player5.setEnabled(true);
						view.player5nameLabel.setEnabled(true);

						setImageCardVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, 
								view.player5Card6, view.player5Card7, view.player5Card8);
					}
				}
			}
			for (String s : view.namesToLabels.keySet()) {

				if(player2ToEnable.equals(s)) {
					String keyValue = view.namesToLabels.get(s);

					/* This is for the second guy */
					if(keyValue.equals("player1")) {
						view.player1.setEnabled(true);
						view.player1nameLabel.setEnabled(true);

						setImageCardVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, 
								view.player1Card6, view.player1Card7, view.player1Card8);
					}

					else if(keyValue.equals("player2")) {
						view.player2.setEnabled(true);
						view.player2nameLabel.setEnabled(true);

						setImageCardVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, 
								view.player2Card6, view.player2Card7, view.player2Card8);
					}

					else if(keyValue.equals("player3")) {
						view.player3.setEnabled(true);
						view.player3nameLabel.setEnabled(true);

						setImageCardVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, 
								view.player3Card6, view.player3Card7, view.player3Card8);
					}

					else if(keyValue.equals("player4")) {
						view.player4.setEnabled(true);
						view.player4nameLabel.setEnabled(true);

						setImageCardVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, 
								view.player4Card6, view.player4Card7, view.player4Card8);
					}

					else if(keyValue.equals("player5")) {
						view.player5.setEnabled(true);
						view.player5nameLabel.setEnabled(true);

						setImageCardVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, 
								view.player5Card6, view.player5Card7, view.player5Card8);
					}
				}
			}
			
			for (String s : view.namesToLabels.keySet()) {

				if(player3ToEnable.equals(s)) {
					String keyValue = view.namesToLabels.get(s);

					/* This is for the second guy */
					if(keyValue.equals("player1")) {
						view.player1.setEnabled(true);
						view.player1nameLabel.setEnabled(true);

						setImageCardVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, 
								view.player1Card6, view.player1Card7, view.player1Card8);
					}

					else if(keyValue.equals("player2")) {
						view.player2.setEnabled(true);
						view.player2nameLabel.setEnabled(true);

						setImageCardVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, 
								view.player2Card6, view.player2Card7, view.player2Card8);
					}

					else if(keyValue.equals("player3")) {
						view.player3.setEnabled(true);
						view.player3nameLabel.setEnabled(true);

						setImageCardVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, 
								view.player3Card6, view.player3Card7, view.player3Card8);
					}

					else if(keyValue.equals("player4")) {
						view.player4.setEnabled(true);
						view.player4nameLabel.setEnabled(true);

						setImageCardVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, 
								view.player4Card6, view.player4Card7, view.player4Card8);
					}

					else if(keyValue.equals("player5")) {
						view.player5.setEnabled(true);
						view.player5nameLabel.setEnabled(true);

						setImageCardVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, 
								view.player5Card6, view.player5Card7, view.player5Card8);
					}
				}
			}
		}
		this.revalidate();
		this.repaint();
	}

	public void setTokenVisibleForPlayerWhoWon(String playerName, String tokenColourObtained) {
		for (String s : view.namesToLabels.keySet()) {

			if(playerName.equals(s)) {
				String keyValue = view.namesToLabels.get(s);

				if(keyValue.equals("player1")) {
					if(tokenColourObtained.equals("red")) {
						ImageIcon redToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player1token1.setIcon(redToken);
						view.player1token1.setVisible(true);
					}

					else if(tokenColourObtained.equals("blue")) {
						ImageIcon blueToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player1token2.setIcon(blueToken);
						view.player1token2.setVisible(true);
					}

					else if(tokenColourObtained.equals("green")) {
						ImageIcon greenToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player1token3.setIcon(greenToken);
						view.player1token3.setVisible(true);
					}

					else if(tokenColourObtained.equals("yellow")) {
						ImageIcon yellowToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player1token4.setIcon(yellowToken);
						view.player1token4.setVisible(true);
					}
				}

				else if(keyValue.equals("player2")) {
					if(tokenColourObtained.equals("red")) {
						ImageIcon redToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player2token1.setIcon(redToken);
						view.player2token1.setVisible(true);
					}

					else if(tokenColourObtained.equals("blue")) {
						ImageIcon blueToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player2token2.setIcon(blueToken);
						view.player2token2.setVisible(true);
					}

					else if(tokenColourObtained.equals("green")) {
						ImageIcon greenToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player2token3.setIcon(greenToken);
						view.player2token3.setVisible(true);
					}

					else if(tokenColourObtained.equals("yellow")) {
						ImageIcon yellowToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player2token4.setIcon(yellowToken);
						view.player2token4.setVisible(true);
					}
				}

				else if(keyValue.equals("player3")) {
					if(tokenColourObtained.equals("red")) {
						ImageIcon redToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player3token1.setIcon(redToken);
						view.player3token1.setVisible(true);
					}

					else if(tokenColourObtained.equals("blue")) {
						ImageIcon blueToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player3token2.setIcon(blueToken);
						view.player3token2.setVisible(true);
					}

					else if(tokenColourObtained.equals("green")) {
						ImageIcon greenToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player3token3.setIcon(greenToken);
						view.player3token3.setVisible(true);
					}

					else if(tokenColourObtained.equals("yellow")) {
						ImageIcon yellowToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player3token4.setIcon(yellowToken);
						view.player3token4.setVisible(true);
					}
				}

				else if(keyValue.equals("player4")) {
					if(tokenColourObtained.equals("red")) {
						ImageIcon redToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player4token1.setIcon(redToken);
						view.player4token1.setVisible(true);
					}

					else if(tokenColourObtained.equals("blue")) {
						ImageIcon blueToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player4token2.setIcon(blueToken);
						view.player4token2.setVisible(true);
					}

					else if(tokenColourObtained.equals("green")) {
						ImageIcon greenToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player4token3.setIcon(greenToken);
						view.player4token3.setVisible(true);
					}

					else if(tokenColourObtained.equals("yellow")) {
						ImageIcon yellowToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player4token4.setIcon(yellowToken);
						view.player4token4.setVisible(true);
					}
				}

				else if(keyValue.equals("player5")) {
					if(tokenColourObtained.equals("red")) {
						ImageIcon redToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player5token1.setIcon(redToken);
						view.player5token1.setVisible(true);
					}

					else if(tokenColourObtained.equals("blue")) {
						ImageIcon blueToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player5token2.setIcon(blueToken);
						view.player5token2.setVisible(true);
					}

					else if(tokenColourObtained.equals("green")) {
						ImageIcon greenToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player5token3.setIcon(greenToken);
						view.player5token3.setVisible(true);
					}

					else if(tokenColourObtained.equals("yellow")) {
						ImageIcon yellowToken = new ImageIcon("./img/" + tokenColourObtained +"_token.png");
						view.player5token4.setIcon(yellowToken);
						view.player5token4.setVisible(true);
					}
				}
			}
		}
		this.revalidate();
		this.repaint();
	}

	public void popUpToNotifyWinnerOfTheTournament(String playerName) {
		JOptionPane.showMessageDialog(this, "Congratulations!! You have just won this tournament " + playerName, "WINNER!!", JOptionPane.PLAIN_MESSAGE);
	}
	public String chosenTokenColour() {

		String[] choices = {"RED", "GREEN", "YELLOW", "BLUE"};
		String input     = (String) JOptionPane.showInputDialog(null, "Select a token as the winner of this PURPLE tournament", "PICK A TOKEN ALERT!!!", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);

		return input;
	}

	public void splitCardsAndSetIt(String cards) {

		String[] splitIt = cards.split(" ");
		String nameOFPlayer = splitIt[3];
		String label = view.namesToLabels.get(nameOFPlayer);

		String card1, card2, card3, card4, card5, card6, card7, card8, card9;

		/* put those loop in an if statement to always check for size of players to know how many card to show and hide */
		if (Config.NUMBER_OF_PLAYERS_SPECIFIED == 2) {

			if(label.equals("player1")) {

				card1 = "./img/270_cards/" + splitIt[4] + ".png";
				card2 = "./img/270_cards/" + splitIt[5] + ".png";
				card3 = "./img/270_cards/" + splitIt[6] + ".png";
				card4 = "./img/270_cards/" + splitIt[7] + ".png";
				card5 = "./img/270_cards/" + splitIt[8] + ".png";
				card6 = "./img/270_cards/" + splitIt[9] + ".png";
				card7 = "./img/270_cards/" + splitIt[10] + ".png";
				card8 = "./img/270_cards/" + splitIt[11] + ".png";
				ImageIcon backOfCard = new ImageIcon("./img/ivanhoe_rotated.png");
				ImageIcon backOfCard1 = new ImageIcon("./img/ivanhoe.png");

				ImageIcon icon1 = new ImageIcon(card1);
				ImageIcon icon2 = new ImageIcon(card2);
				ImageIcon icon3 = new ImageIcon(card3);
				ImageIcon icon4 = new ImageIcon(card4);
				ImageIcon icon5 = new ImageIcon(card5);
				ImageIcon icon6 = new ImageIcon(card6);
				ImageIcon icon7 = new ImageIcon(card7);
				ImageIcon icon8 = new ImageIcon(card8);

				setCardImagesIcon(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8,
						icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8);
				setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);

				setCardImagesIcon(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

				this.revalidate();
				this.repaint();
			}

			else if(label.equals("player5")) {
				ImageIcon backOfCard1 = new ImageIcon("./img/ivanhoe.png");
				card1 = "./img/90_cards/" + splitIt[4] + ".png";
				card2 = "./img/90_cards/" + splitIt[5] + ".png";
				card3 = "./img/90_cards/" + splitIt[6] + ".png";
				card4 = "./img/90_cards/" + splitIt[7] + ".png";
				card5 = "./img/90_cards/" + splitIt[8] + ".png";
				card6 = "./img/90_cards/" + splitIt[9] + ".png";
				card7 = "./img/90_cards/" + splitIt[10] + ".png";
				card8 = "./img/90_cards/" + splitIt[11] + ".png";
				ImageIcon backOfCard = new ImageIcon("./img/ivanhoe_rotated.png");

				ImageIcon icon1 = new ImageIcon(card1);
				ImageIcon icon2 = new ImageIcon(card2);
				ImageIcon icon3 = new ImageIcon(card3);
				ImageIcon icon4 = new ImageIcon(card4);
				ImageIcon icon5 = new ImageIcon(card5);
				ImageIcon icon6 = new ImageIcon(card6);
				ImageIcon icon7 = new ImageIcon(card7);
				ImageIcon icon8 = new ImageIcon(card8);

				setCardImagesIcon(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8,
						icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8);
				setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);


				setCardImagesIcon(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);

				this.revalidate();
				this.repaint();
			}

			clientApp.send("done distributing cards");
		}

		if (Config.NUMBER_OF_PLAYERS_SPECIFIED == 3) {
			/* loop over the hash map */
			for (String s : view.namesToLabels.keySet()) {

				if(nameOFPlayer.equals(s)) {

					/* now get the value mapped to that player for the GUI */
					String keyValue = view.namesToLabels.get(s);

					if(keyValue.equals("player1")) {

						card1 = "./img/270_cards/" + splitIt[4] + ".png";
						card2 = "./img/270_cards/" + splitIt[5] + ".png";
						card3 = "./img/270_cards/" + splitIt[6] + ".png";
						card4 = "./img/270_cards/" + splitIt[7] + ".png";
						card5 = "./img/270_cards/" + splitIt[8] + ".png";
						card6 = "./img/270_cards/" + splitIt[9] + ".png";
						card7 = "./img/270_cards/" + splitIt[10] + ".png";
						card8 = "./img/270_cards/" + splitIt[11] + ".png";
						ImageIcon backOfCard = new ImageIcon("./img/ivanhoe_rotated.png");
						ImageIcon backOfCard1 = new ImageIcon("./img/ivanhoe.png");

						ImageIcon icon1 = new ImageIcon(card1);
						ImageIcon icon2 = new ImageIcon(card2);
						ImageIcon icon3 = new ImageIcon(card3);
						ImageIcon icon4 = new ImageIcon(card4);
						ImageIcon icon5 = new ImageIcon(card5);
						ImageIcon icon6 = new ImageIcon(card6);
						ImageIcon icon7 = new ImageIcon(card7);
						ImageIcon icon8 = new ImageIcon(card8);

						setCardImagesIcon(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8,
								icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8);
						setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);


						setCardImagesIcon(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8,
								backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
						setImageVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8);


						setCardImagesIcon(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8,
								backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
						setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

						this.revalidate();
						this.repaint();
					}

					else if (keyValue.equals("player3")) {

						card1 = "./img/360_cards/" + splitIt[4] + ".png";
						card2 = "./img/360_cards/" + splitIt[5] + ".png";
						card3 = "./img/360_cards/" + splitIt[6] + ".png";
						card4 = "./img/360_cards/" + splitIt[7] + ".png";
						card5 = "./img/360_cards/" + splitIt[8] + ".png";
						card6 = "./img/360_cards/" + splitIt[9] + ".png";
						card7 = "./img/360_cards/" + splitIt[10] + ".png";
						card8 = "./img/360_cards/" + splitIt[11] + ".png";

						ImageIcon backOfCard = new ImageIcon("./img/ivanhoe_rotated.png");

						ImageIcon icon1 = new ImageIcon(card1);
						ImageIcon icon2 = new ImageIcon(card2);
						ImageIcon icon3 = new ImageIcon(card3);
						ImageIcon icon4 = new ImageIcon(card4);
						ImageIcon icon5 = new ImageIcon(card5);
						ImageIcon icon6 = new ImageIcon(card6);
						ImageIcon icon7 = new ImageIcon(card7);
						ImageIcon icon8 = new ImageIcon(card8);

						setCardImagesIcon(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8,
								icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8);
						setImageVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8);


						setCardImagesIcon(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8,
								backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
						setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);


						setCardImagesIcon(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8,
								backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
						setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

						this.revalidate();
						this.repaint();
					}

					else if(keyValue.equals("player5")) {
						ImageIcon backOfCard1 = new ImageIcon("./img/ivanhoe.png");
						card1 = "./img/90_cards/" + splitIt[4] + ".png";
						card2 = "./img/90_cards/" + splitIt[5] + ".png";
						card3 = "./img/90_cards/" + splitIt[6] + ".png";
						card4 = "./img/90_cards/" + splitIt[7] + ".png";
						card5 = "./img/90_cards/" + splitIt[8] + ".png";
						card6 = "./img/90_cards/" + splitIt[9] + ".png";
						card7 = "./img/90_cards/" + splitIt[10] + ".png";
						card8 = "./img/90_cards/" + splitIt[11] + ".png";
						ImageIcon backOfCard = new ImageIcon("./img/ivanhoe_rotated.png");

						ImageIcon icon1 = new ImageIcon(card1);
						ImageIcon icon2 = new ImageIcon(card2);
						ImageIcon icon3 = new ImageIcon(card3);
						ImageIcon icon4 = new ImageIcon(card4);
						ImageIcon icon5 = new ImageIcon(card5);
						ImageIcon icon6 = new ImageIcon(card6);
						ImageIcon icon7 = new ImageIcon(card7);
						ImageIcon icon8 = new ImageIcon(card8);

						setCardImagesIcon(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8,
								icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8);
						setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);


						setCardImagesIcon(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8,
								backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
						setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);

						setCardImagesIcon(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8,
								backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
						setImageVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8);


						this.revalidate();
						this.repaint();
					}
				}
			}

			clientApp.send("done distributing cards");
		}

		else if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 4) {
			if(label.equals("player1")) {

				card1 = "./img/270_cards/" + splitIt[4] + ".png";
				card2 = "./img/270_cards/" + splitIt[5] + ".png";
				card3 = "./img/270_cards/" + splitIt[6] + ".png";
				card4 = "./img/270_cards/" + splitIt[7] + ".png";
				card5 = "./img/270_cards/" + splitIt[8] + ".png";
				card6 = "./img/270_cards/" + splitIt[9] + ".png";
				card7 = "./img/270_cards/" + splitIt[10] + ".png";
				card8 = "./img/270_cards/" + splitIt[11] + ".png";
				System.out.println("Card 8 is" + card8);
				ImageIcon backOfCard = new ImageIcon("./img/ivanhoe_rotated.png");
				ImageIcon backOfCard1 = new ImageIcon("./img/ivanhoe.png");

				ImageIcon icon1 = new ImageIcon(card1);
				ImageIcon icon2 = new ImageIcon(card2);
				ImageIcon icon3 = new ImageIcon(card3);
				ImageIcon icon4 = new ImageIcon(card4);
				ImageIcon icon5 = new ImageIcon(card5);
				ImageIcon icon6 = new ImageIcon(card6);
				ImageIcon icon7 = new ImageIcon(card7);
				ImageIcon icon8 = new ImageIcon(card8);

				setCardImagesIcon(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8,
						icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8);
				setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);


				setCardImagesIcon(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8);

				setCardImagesIcon(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8);


				setCardImagesIcon(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

				this.revalidate();
				this.repaint();
			}

			else if (label.equals("player2")) {

				card1 = "./img/360_cards/" + splitIt[4] + ".png";
				card2 = "./img/360_cards/" + splitIt[5] + ".png";
				card3 = "./img/360_cards/" + splitIt[6] + ".png";
				card4 = "./img/360_cards/" + splitIt[7] + ".png";
				card5 = "./img/360_cards/" + splitIt[8] + ".png";
				card6 = "./img/360_cards/" + splitIt[9] + ".png";
				card7 = "./img/360_cards/" + splitIt[10] + ".png";
				card8 = "./img/360_cards/" + splitIt[11] + ".png";
				System.out.println("Card 8 is" + card8);
				ImageIcon backOfCard = new ImageIcon("./img/ivanhoe_rotated.png");
				ImageIcon backOfCard1 = new ImageIcon("./img/ivanhoe.png");
				ImageIcon icon1 = new ImageIcon(card1);
				ImageIcon icon2 = new ImageIcon(card2);
				ImageIcon icon3 = new ImageIcon(card3);
				ImageIcon icon4 = new ImageIcon(card4);
				ImageIcon icon5 = new ImageIcon(card5);
				ImageIcon icon6 = new ImageIcon(card6);
				ImageIcon icon7 = new ImageIcon(card7);
				ImageIcon icon8 = new ImageIcon(card8);

				setCardImagesIcon(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8,
						icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8);
				setImageVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8);

				setCardImagesIcon(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);

				setCardImagesIcon(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8);

				setCardImagesIcon(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

				this.revalidate();
				this.repaint();
			}

			else if (label.equals("player4")) {

				card1 = "./img/360_cards/" + splitIt[4] + ".png";
				card2 = "./img/360_cards/" + splitIt[5] + ".png";
				card3 = "./img/360_cards/" + splitIt[6] + ".png";
				card4 = "./img/360_cards/" + splitIt[7] + ".png";
				card5 = "./img/360_cards/" + splitIt[8] + ".png";
				card6 = "./img/360_cards/" + splitIt[9] + ".png";
				card7 = "./img/360_cards/" + splitIt[10] + ".png";
				card8 = "./img/360_cards/" + splitIt[11] + ".png";
				System.out.println("Card 8 is" + card8);
				ImageIcon backOfCard = new ImageIcon("./img/ivanhoe_rotated.png");
				ImageIcon backOfCard1 = new ImageIcon("./img/ivanhoe.png");
				ImageIcon icon1 = new ImageIcon(card1);
				ImageIcon icon2 = new ImageIcon(card2);
				ImageIcon icon3 = new ImageIcon(card3);
				ImageIcon icon4 = new ImageIcon(card4);
				ImageIcon icon5 = new ImageIcon(card5);
				ImageIcon icon6 = new ImageIcon(card6);
				ImageIcon icon7 = new ImageIcon(card7);
				ImageIcon icon8 = new ImageIcon(card8);

				setCardImagesIcon(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8,
						icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8);
				setImageVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8);


				setCardImagesIcon(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);

				setCardImagesIcon(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8);


				setCardImagesIcon(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

				this.revalidate();
				this.repaint();
			}

			else if(label.equals("player5")) {
				ImageIcon backOfCard1 = new ImageIcon("./img/ivanhoe.png");
				card1 = "./img/90_cards/" + splitIt[4] + ".png";
				card2 = "./img/90_cards/" + splitIt[5] + ".png";
				card3 = "./img/90_cards/" + splitIt[6] + ".png";
				card4 = "./img/90_cards/" + splitIt[7] + ".png";
				card5 = "./img/90_cards/" + splitIt[8] + ".png";
				card6 = "./img/90_cards/" + splitIt[9] + ".png";
				card7 = "./img/90_cards/" + splitIt[10] + ".png";
				card8 = "./img/90_cards/" + splitIt[11] + ".png";
				System.out.println("Card 8 is" + card8);
				ImageIcon backOfCard = new ImageIcon("./img/ivanhoe_rotated.png");

				ImageIcon icon1 = new ImageIcon(card1);
				ImageIcon icon2 = new ImageIcon(card2);
				ImageIcon icon3 = new ImageIcon(card3);
				ImageIcon icon4 = new ImageIcon(card4);
				ImageIcon icon5 = new ImageIcon(card5);
				ImageIcon icon6 = new ImageIcon(card6);
				ImageIcon icon7 = new ImageIcon(card7);
				ImageIcon icon8 = new ImageIcon(card8);

				setCardImagesIcon(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8,
						icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8);
				setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

				setCardImagesIcon(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8);


				setCardImagesIcon(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);

				setCardImagesIcon(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8);


				this.revalidate();
				this.repaint();
			}
			clientApp.send("done distributing cards");
		}

		else if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 5) {
			if(label.equals("player1")) {

				card1 = "./img/270_cards/" + splitIt[4] + ".png";
				card2 = "./img/270_cards/" + splitIt[5] + ".png";
				card3 = "./img/270_cards/" + splitIt[6] + ".png";
				card4 = "./img/270_cards/" + splitIt[7] + ".png";
				card5 = "./img/270_cards/" + splitIt[8] + ".png";
				card6 = "./img/270_cards/" + splitIt[9] + ".png";
				card7 = "./img/270_cards/" + splitIt[10] + ".png";
				card8 = "./img/270_cards/" + splitIt[11] + ".png";
				System.out.println("Card 8 is" + card8);
				ImageIcon backOfCard = new ImageIcon("./img/ivanhoe_rotated.png");
				ImageIcon backOfCard1 = new ImageIcon("./img/ivanhoe.png");

				ImageIcon icon1 = new ImageIcon(card1);
				ImageIcon icon2 = new ImageIcon(card2);
				ImageIcon icon3 = new ImageIcon(card3);
				ImageIcon icon4 = new ImageIcon(card4);
				ImageIcon icon5 = new ImageIcon(card5);
				ImageIcon icon6 = new ImageIcon(card6);
				ImageIcon icon7 = new ImageIcon(card7);
				ImageIcon icon8 = new ImageIcon(card8);

				setCardImagesIcon(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8,
						icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8);
				setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);

				setCardImagesIcon(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8);

				setCardImagesIcon(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8);

				setCardImagesIcon(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8);


				setCardImagesIcon(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

				this.revalidate();
				this.repaint();
			}

			else if (label.equals("player2")) {

				card1 = "./img/360_cards/" + splitIt[4] + ".png";
				card2 = "./img/360_cards/" + splitIt[5] + ".png";
				card3 = "./img/360_cards/" + splitIt[6] + ".png";
				card4 = "./img/360_cards/" + splitIt[7] + ".png";
				card5 = "./img/360_cards/" + splitIt[8] + ".png";
				card6 = "./img/360_cards/" + splitIt[9] + ".png";
				card7 = "./img/360_cards/" + splitIt[10] + ".png";
				card8 = "./img/360_cards/" + splitIt[11] + ".png";
				System.out.println("Card 8 is" + card8);
				ImageIcon backOfCard = new ImageIcon("./img/ivanhoe_rotated.png");
				ImageIcon backOfCard1 = new ImageIcon("./img/ivanhoe.png");
				ImageIcon icon1 = new ImageIcon(card1);
				ImageIcon icon2 = new ImageIcon(card2);
				ImageIcon icon3 = new ImageIcon(card3);
				ImageIcon icon4 = new ImageIcon(card4);
				ImageIcon icon5 = new ImageIcon(card5);
				ImageIcon icon6 = new ImageIcon(card6);
				ImageIcon icon7 = new ImageIcon(card7);
				ImageIcon icon8 = new ImageIcon(card8);

				setCardImagesIcon(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8);

				setCardImagesIcon(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8,
						icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8);
				setImageVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8);

				setCardImagesIcon(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);

				setCardImagesIcon(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8);

				setCardImagesIcon(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

				this.revalidate();
				this.repaint();
			}
			else if (label.equals("player3")) {

				card1 = "./img/360_cards/" + splitIt[4] + ".png";
				card2 = "./img/360_cards/" + splitIt[5] + ".png";
				card3 = "./img/360_cards/" + splitIt[6] + ".png";
				card4 = "./img/360_cards/" + splitIt[7] + ".png";
				card5 = "./img/360_cards/" + splitIt[8] + ".png";
				card6 = "./img/360_cards/" + splitIt[9] + ".png";
				card7 = "./img/360_cards/" + splitIt[10] + ".png";
				card8 = "./img/360_cards/" + splitIt[11] + ".png";
				ImageIcon backOfCard1 = new ImageIcon("./img/ivanhoe.png");
				ImageIcon backOfCard = new ImageIcon("./img/ivanhoe_rotated.png");

				ImageIcon icon1 = new ImageIcon(card1);
				ImageIcon icon2 = new ImageIcon(card2);
				ImageIcon icon3 = new ImageIcon(card3);
				ImageIcon icon4 = new ImageIcon(card4);
				ImageIcon icon5 = new ImageIcon(card5);
				ImageIcon icon6 = new ImageIcon(card6);
				ImageIcon icon7 = new ImageIcon(card7);
				ImageIcon icon8 = new ImageIcon(card8);

				setCardImagesIcon(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8,
						icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8);
				setImageVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8);


				setCardImagesIcon(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8);


				setCardImagesIcon(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);

				setCardImagesIcon(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8);

				setCardImagesIcon(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

				this.revalidate();
				this.repaint();
			}


			else if (label.equals("player4")) {

				card1 = "./img/360_cards/" + splitIt[4] + ".png";
				card2 = "./img/360_cards/" + splitIt[5] + ".png";
				card3 = "./img/360_cards/" + splitIt[6] + ".png";
				card4 = "./img/360_cards/" + splitIt[7] + ".png";
				card5 = "./img/360_cards/" + splitIt[8] + ".png";
				card6 = "./img/360_cards/" + splitIt[9] + ".png";
				card7 = "./img/360_cards/" + splitIt[10] + ".png";
				card8 = "./img/360_cards/" + splitIt[11] + ".png";
				System.out.println("Card 8 is" + card8);
				ImageIcon backOfCard = new ImageIcon("./img/ivanhoe_rotated.png");
				ImageIcon backOfCard1 = new ImageIcon("./img/ivanhoe.png");
				ImageIcon icon1 = new ImageIcon(card1);
				ImageIcon icon2 = new ImageIcon(card2);
				ImageIcon icon3 = new ImageIcon(card3);
				ImageIcon icon4 = new ImageIcon(card4);
				ImageIcon icon5 = new ImageIcon(card5);
				ImageIcon icon6 = new ImageIcon(card6);
				ImageIcon icon7 = new ImageIcon(card7);
				ImageIcon icon8 = new ImageIcon(card8);

				setCardImagesIcon(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8,
						icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8);
				setImageVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8);

				setCardImagesIcon(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8);

				setCardImagesIcon(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);

				setCardImagesIcon(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8);


				setCardImagesIcon(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

				this.revalidate();
				this.repaint();
			}


			else if(label.equals("player5")) {
				ImageIcon backOfCard1 = new ImageIcon("./img/ivanhoe.png");
				card1 = "./img/90_cards/" + splitIt[4] + ".png";
				card2 = "./img/90_cards/" + splitIt[5] + ".png";
				card3 = "./img/90_cards/" + splitIt[6] + ".png";
				card4 = "./img/90_cards/" + splitIt[7] + ".png";
				card5 = "./img/90_cards/" + splitIt[8] + ".png";
				card6 = "./img/90_cards/" + splitIt[9] + ".png";
				card7 = "./img/90_cards/" + splitIt[10] + ".png";
				card8 = "./img/90_cards/" + splitIt[11] + ".png";
				System.out.println("Card 8 is" + card8);
				ImageIcon backOfCard = new ImageIcon("./img/ivanhoe_rotated.png");

				ImageIcon icon1 = new ImageIcon(card1);
				ImageIcon icon2 = new ImageIcon(card2);
				ImageIcon icon3 = new ImageIcon(card3);
				ImageIcon icon4 = new ImageIcon(card4);
				ImageIcon icon5 = new ImageIcon(card5);
				ImageIcon icon6 = new ImageIcon(card6);
				ImageIcon icon7 = new ImageIcon(card7);
				ImageIcon icon8 = new ImageIcon(card8);

				setCardImagesIcon(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8,
						icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8);
				setImageVisibility(view.player5Card1, view.player5Card2, view.player5Card3, view.player5Card4, view.player5Card5, view.player5Card6, view.player5Card7, view.player5Card8);

				setCardImagesIcon(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player4Card1, view.player4Card2, view.player4Card3, view.player4Card4, view.player4Card5, view.player4Card6, view.player4Card7, view.player4Card8);


				setCardImagesIcon(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player2Card1, view.player2Card2, view.player2Card3, view.player2Card4, view.player2Card5, view.player2Card6, view.player2Card7, view.player2Card8);

				setCardImagesIcon(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8,
						backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard, backOfCard);
				setImageVisibility(view.player1Card1, view.player1Card2, view.player1Card3, view.player1Card4, view.player1Card5, view.player1Card6, view.player1Card7, view.player1Card8);

				setCardImagesIcon(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8,
						backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1, backOfCard1);
				setImageVisibility(view.player3Card1, view.player3Card2, view.player3Card3, view.player3Card4, view.player3Card5, view.player3Card6, view.player3Card7, view.player3Card8);


				this.revalidate();
				this.repaint();
			}

			clientApp.send("done distributing cards");
		}	
	}

	public void disableStuffs(String nameOfPlayer) {

		if(Config.NUMBER_OF_PLAYERS_SPECIFIED == 3) {
			for (String s : view.namesToLabels.keySet()) {
				if(nameOfPlayer.equals(s)) {

					/* now get the value mapped to that player for the GUI */
					String keyValue = view.namesToLabels.get(s);

					if(keyValue.equals("player1")) {
						view.player1.setEnabled(false);
					}

					else if(keyValue.equals("player3")) {
						view.player3.setEnabled(false);
					}

					else if(keyValue.equals("player5")) {
						view.player5.setEnabled(false);
					}
				}
			}
		}
	}

	public void setCardImagesIcon(JLabel playerCard1, JLabel playerCard2, JLabel playerCard3, JLabel playerCard4, JLabel playerCard5, JLabel playerCard6, JLabel playerCard7, JLabel playerCard8,
			ImageIcon icon1, ImageIcon icon2, ImageIcon icon3, ImageIcon icon4, ImageIcon icon5, ImageIcon icon6, ImageIcon icon7, ImageIcon icon8) {
		playerCard1.setIcon(icon1);
		playerCard2.setIcon(icon2);
		playerCard3.setIcon(icon3);
		playerCard4.setIcon(icon4);
		playerCard5.setIcon(icon5);
		playerCard6.setIcon(icon6);
		playerCard7.setIcon(icon7);
		playerCard8.setIcon(icon8);
	}

	public void setImageVisibility(JLabel playerCard1, JLabel playerCard2, JLabel playerCard3, JLabel playerCard4, JLabel playerCard5, JLabel playerCard6, JLabel playerCard7, JLabel playerCard8) {
		playerCard1.setVisible(true);
		playerCard2.setVisible(true);
		playerCard3.setVisible(true);
		playerCard4.setVisible(true);
		playerCard5.setVisible(true);
		playerCard6.setVisible(true);
		playerCard7.setVisible(true);
		playerCard8.setVisible(true);
	}

	public void setImageInVisibility(JLabel playerCard1, JLabel playerCard2, JLabel playerCard3, JLabel playerCard4, JLabel playerCard5, JLabel playerCard6, JLabel playerCard7, JLabel playerCard8) {
		playerCard1.setEnabled(false);
		playerCard2.setEnabled(false);
		playerCard3.setEnabled(false);
		playerCard4.setEnabled(false);
		playerCard5.setEnabled(false);
		playerCard6.setEnabled(false);
		playerCard7.setEnabled(false);
		playerCard8.setEnabled(false);
	}

	public void setImageCardVisibility(JLabel playerCard1, JLabel playerCard2, JLabel playerCard3, JLabel playerCard4, JLabel playerCard5, JLabel playerCard6, JLabel playerCard7, JLabel playerCard8) {
		playerCard1.setEnabled(true);
		playerCard2.setEnabled(true);
		playerCard3.setEnabled(true);
		playerCard4.setEnabled(true);
		playerCard5.setEnabled(true);
		playerCard6.setEnabled(true);
		playerCard7.setEnabled(true);
		playerCard8.setEnabled(true);
	}

}