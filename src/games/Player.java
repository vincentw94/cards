package games;

import java.util.LinkedList;
import java.util.List;

import cards.Card;

public class Player<T extends Card> {	
	private LinkedList<T> hand, selected, faceUp, faceDown;		// not all of these may be used in each game
	private boolean hasTurn, isActive;
	private int id, points;		// points may or may not be needed
	
	public Player(int id) {
		this.id = id;
		isActive = true;
		
		hand = new LinkedList<T>();
		selected = new LinkedList<T>();
		faceUp = new LinkedList<T>();
		faceDown = new LinkedList<T>();
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
	
	// dealing or actions by player
	public void putFaceDown(T card) {
		faceDown.add(card);
	}
	public void putFaceUp(T card) {
		faceUp.add(card);
	}
	
	// card(s) player is about to play
	public LinkedList<T> getSelected() {
		return selected;
	}
	
	// state of game
	public LinkedList<T> getFaceUp() {
		return faceUp;
	}
	public LinkedList<T> getFaceDown() {
		return faceDown;
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
