package ui;

import java.util.ArrayList;

import javax.swing.JLayeredPane;

import network.GameClient;
import cards.Card;

@SuppressWarnings("serial")
public class Hand<T extends Card> extends JLayeredPane {
	public static final int HORIZ_OFFSET = 30, VERT_OFFSET = 50;

	private ArrayList<T> cards;

	public Hand() {
		cards = new ArrayList<T>();
		setSize(GameClient.WIDTH, Card.IMG_HEIGHT + VERT_OFFSET);
		setPreferredSize(getSize());
	}

	public ArrayList<T> getCards() {
		return cards;
	}

	public void addCard(T card) {
		cards.add(card);
		HandCard<T> handCard = new HandCard<T>(card);

		int depth = 0 + cards.size();
		add(handCard, new Integer(depth));
		handCard.setBounds(HORIZ_OFFSET*cards.size(), VERT_OFFSET, Card.IMG_WIDTH, Card.IMG_HEIGHT);
	}

}
