package games;

import java.util.LinkedList;

import cards.Deck;
import cards.PokerCard;

public class HeartsGame extends CardGame<PokerCard> {
	private static final int[] PASSING_OFFSET = {1, -1, 2, 0};	// pass left, right, across, then none
	private static final int NUM_PLAYERS = 4;
	
	private Deck<PokerCard> deck;
	private int passInd;
	
	public HeartsGame() {
		super(NUM_PLAYERS, PokerCard.genPoker52());
		
		passInd = 0;	// start w/ passing left
		deck = getDeck();
	}

	public Player<PokerCard>[] initPlayers(int numPlayers) {
		@SuppressWarnings("unchecked")
		Player<PokerCard>[] players = (Player<PokerCard>[]) new Player[numPlayers];
		
		for (int i=0; i<numPlayers; i++)
			players[i] = new Player<PokerCard>(i);
		
		return players;
	}

	public void dealCards() {
		deck.reset();
		
		int id = 0;
		while (deck.hasCardsLeft()) {
			PokerCard next = deck.next();
			getPlayers()[id].putInHand(next);
			id = (id+1) % NUM_PLAYERS;
		}
	}

	public void startGame() {
		// TODO: link to server and seat players CW
		
		// TODO: interface for selecting cards
		
		if (PASSING_OFFSET[passInd] != 0) {			// skip if no passing
			for (int i=0; i<NUM_PLAYERS; i++) {
				int ii = (i+1) % NUM_PLAYERS;		// player to pass to
				LinkedList<PokerCard> selected = getPlayers()[i].getSelected();
				getPlayers()[ii].putAllInHand(selected);
			}
		}
	}
	
	// players play 1 card at a time
	public boolean isValidPlay(PokerCard... cards) {
		return cards.length == 1;
	}
}
