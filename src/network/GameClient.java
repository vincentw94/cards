package network;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

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

@SuppressWarnings("serial")
class CardTable extends JPanel {
	private Image backgroundImg;

	public CardTable() {
		try {
			backgroundImg = ImageIO.read(new File("Card_UI_BG.jpg")).getScaledInstance(GameClient.WIDTH, GameClient.HEIGHT, Image.SCALE_SMOOTH);
		} catch (IOException ioe) {
			System.err.println("Failed to load background image!");
			ioe.printStackTrace();
		}

		setOpaque(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (backgroundImg != null)
			g.drawImage(backgroundImg, 0, 0, null);
	}
}
