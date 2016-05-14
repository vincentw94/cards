package games;

import java.util.LinkedList;

import cards.Card;
import cards.Deck;

public abstract class CardGame<T extends Card> {
	
	private Player<T>[] players;
	private Deck<T> deck;
	private LinkedList<T> discardPile;		// use like a stack
	
	public CardGame(int numPlayers, Deck<T> deck) {
		this.deck = deck;
		discardPile = new LinkedList<T>();
		
		players = initPlayers(numPlayers);
		dealCards();
		startGame();
	}
	
	public Player<T>[] getPlayers() {
		return players;
	}
	
	public Deck<T> getDeck() {
		return deck;
	}
	
	public LinkedList<T> getDiscardPile() {
		return discardPile;
	}
	
	public abstract Player<T>[] initPlayers(int numPlayers);
	public abstract void dealCards();
	public abstract void startGame();
	public abstract boolean isValidPlay(T... cards);
}
