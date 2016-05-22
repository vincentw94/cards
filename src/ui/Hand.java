package ui;

import java.util.ArrayList;

import javax.swing.JLayeredPane;

import network.GameClient;
import cards.Card;

@SuppressWarnings("serial")
public class Hand<T extends Card> extends JLayeredPane {
	public static final int HORIZ_OFFSET = 30, VERT_OFFSET = 50, MARGIN = 10;

	private ArrayList<HandCard<T>> cards;

	public Hand() {
		cards = new ArrayList<HandCard<T>>();
		setSize(GameClient.WIDTH, Card.IMG_HEIGHT + VERT_OFFSET);
		setPreferredSize(getSize());

		// hand always positioned at bottom of client
		setBounds(0, GameClient.HEIGHT - Card.IMG_HEIGHT - VERT_OFFSET - MARGIN, GameClient.WIDTH, Card.IMG_HEIGHT + VERT_OFFSET);
	}

	public T getCard(int pos) {
		return cards.get(pos).card;
	}

	// IMPORTANT: see using Integer vs int in setting layer / depth
	// https://docs.oracle.com/javase/tutorial/uiswing/components/problems.html#layeredpane
	public void addCard(T card) {
		HandCard<T> handCard = new HandCard<T>(card, cards.size(), cards.size()+1);
		cards.add(handCard);
		add(handCard, new Integer(cards.size()));

		for (int i=0; i<cards.size()-1; i++) {
			cards.get(i).updateIndex(i, cards.size());
			setLayer(cards.get(i), i);
		}
	}

}
