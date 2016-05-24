package games;

import java.util.HashMap;

import ui.CardDrawable;
import ui.CardTable;
import ui.Hand;
import cards.Card;

public class ClientGameState<T extends Card> {
	private int clientId;
	private CardTable table;
	private HashMap<Integer, CardDrawable> drawables;
	private HashMap<Integer, Hand<T>> hands;

	public ClientGameState(int clientId, CardTable table) {
		this.clientId = clientId;
		this.table = table;
		drawables = new HashMap<Integer, CardDrawable>();
		hands = new HashMap<Integer, Hand<T>>();
	}
}
