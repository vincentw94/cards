package games;

import java.util.ArrayList;
import java.util.List;

import cards.Card;

public class Player<T extends Card> {	
	private ArrayList<T> hand;
	private boolean hasTurn, isActive;
	private int id, points;		// points may or may not be needed
	
	public Player(int id) {
		this.id = id;
		isActive = true;
		
		hand = new ArrayList<T>();
	}
	
	// player id
	public int getId() {
		return id;
	}
	
	// number of cards in player's hand
	public int numCardsLeft() {
		return hand.size();
	}
	
	// dealing and passing of cards
	public void putInHand(T card) {
		hand.add(card);
	}
	public void putAllInHand(List<T> cards) {
		for (T card : cards)
			putInHand(card);
	}
	
	// TODO: link to client
	public void notifyTurn() {
		if (!isActive)
			throw new IllegalStateException("Turn given to inactive player");
		
		hasTurn = true;
	}
	
	// state of player
	public boolean hasTurn() {
		return hasTurn;
	}
	public boolean isActive() {
		return isActive;
	}
	public int getPoints() {
		return points;
	}
	public void incPoints(int inc) {
		points += inc;
	}
}
