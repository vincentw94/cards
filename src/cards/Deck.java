package cards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck<T extends Card> {
	private List<T> fullDeck;		// full set of cards
	private LinkedList<T> remCards;		// cards remaining in deck
	
	// create a deck with the list of cards
	public Deck(List<T> cards) {
		fullDeck = Collections.unmodifiableList(cards);
		reset();
	}
	
	// full set of cards
	public List<T> cardSet() {
		return fullDeck;		// unmodifiable
	}
	
	// reset current deck to full deck and shuffles
	public void reset() {
		remCards = new LinkedList<T>(fullDeck);
		Collections.shuffle(remCards);
	}
	
	// number of cards left
	public boolean hasCardsLeft() {
		return remCards.size() > 0;
	}
	
	// deal card on top of deck and remove
	public T next() {
		if (!hasCardsLeft())
			return null;
		return remCards.poll();
	}
	
	// place on top of deck
	public void placeBack(T card) {
		remCards.add(0, card);
	}
}
