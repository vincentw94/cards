package network;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.Hand;
import cards.Deck;
import cards.PokerCard;

public class GameClient {
	public static final int WIDTH = 900, HEIGHT = 600;
	public static void main(String[] args) {
		JFrame frame = new JFrame("Cards!");
		JPanel content = new JPanel(new BorderLayout());
		content.setSize(WIDTH, HEIGHT);
		content.setPreferredSize(content.getSize());

		Hand<PokerCard> hand = new Hand<PokerCard>();
		Deck<PokerCard> deck = PokerCard.genPoker52();
		for (int i=0; i<4; i++)
			hand.addCard(deck.next());
		content.add(hand, BorderLayout.SOUTH);

		frame.setContentPane(content);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
