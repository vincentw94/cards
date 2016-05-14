package cards;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class PokerCard extends Card {
	
	// define enumerations for Suit and Rank
	public enum Suit {
		CLUBS("clubs"), DIAMONDS("diamonds"), HEARTS("hearts"), SPADES("spades"),
		JOKER_RED("red"), JOKER_BLACK("black");
		
		private String name;
		
		private Suit(String s) {
			name = s;
		}
		public String toString() {
			return name;
		}
	}
	public enum Rank {
		TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"),
		NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K"), ACE("A"), JOKER("Joker");
		
		public String name;
		
		private Rank(String s) {
			name = s;
		}
		public String toString() {
			return name;
		}
	}
	
	private Suit suit;
	private Rank rank;
	
	// immutable card; accessible only from premade deck
	private PokerCard(Suit suit, Rank rank) {
		super(rank + "_" + suit);
		
		this.suit = suit;
		this.rank = rank;
	}
	
	// getter methods
	public Suit getSuit() {
		return suit;
	}
	
	public Rank getValue() {
		return rank;
	}
	
	public String toString() {
		return rank + "_" + suit;
	}
	
	// 52-card standard poker deck
	public static final Deck<PokerCard> genPoker52() {
		List<PokerCard> cards = new ArrayList<PokerCard>(52);
		for (Suit s : EnumSet.range(Suit.CLUBS, Suit.SPADES)) {
			for (Rank r : EnumSet.range(Rank.TWO, Rank.ACE)) {
				cards.add(new PokerCard(s, r));
			}
		}
		
		return new Deck<PokerCard>(cards);
	}
	
	// 54-cards standard + red joker + black joker
	public static final Deck<PokerCard> genPoker54() {
		List<PokerCard> cards = new ArrayList<PokerCard>(54);
		cards.addAll(genPoker52().cardSet());
		cards.add(new PokerCard(Suit.JOKER_BLACK, Rank.JOKER));
		cards.add(new PokerCard(Suit.JOKER_RED, Rank.JOKER));
		
		return new Deck<PokerCard>(cards);
	}
}
