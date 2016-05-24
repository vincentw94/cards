package games;

import java.util.HashMap;

import ui.CardDrawable;
import ui.CardTable;
import ui.Hand;
import cards.Card;

public class ClientGameState<T extends Card> {
	private static final int ID_UNKNOWN = -1;

	private int clientId;
	private CardTable table;
	private HashMap<Integer, CardDrawable> drawables;
	private HashMap<Integer, Hand<T>> hands;

	public ClientGameState(CardTable table) {
		this.clientId = ID_UNKNOWN;
		this.table = table;
		drawables = new HashMap<Integer, CardDrawable>();
		hands = new HashMap<Integer, Hand<T>>();
	}

	public void setId(int id) {
		clientId = id;
	}
}
