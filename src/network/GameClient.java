package network;

import javax.swing.JFrame;

import ui.CardTable;
import ui.Hand;
import cards.Deck;
import cards.PokerCard;

public class GameClient {
	public static final int WIDTH = 900, HEIGHT = 600;
	public static void main(String[] args) {
		JFrame frame = new JFrame("Cards!");

		CardTable table = new CardTable();
		table.setLayout(null);
		table.setSize(WIDTH, HEIGHT);
		table.setPreferredSize(table.getSize());

		Hand<PokerCard> hand = new Hand<PokerCard>();
		Deck<PokerCard> deck = PokerCard.genPoker52();
		for (int i=0; i<10; i++)
			hand.addCard(deck.next());
		table.add(hand);

		frame.setContentPane(table);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}


