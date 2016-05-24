package network;

import games.ClientGameState;
import cards.Card;

public class NotifyIdTransaction<T extends Card> extends Transaction<T> {
	private static final long serialVersionUID = -4553314502541740008L;

	private int id;

	public NotifyIdTransaction(int id) {
		this.id = id;
	}

	public void action(ClientGameState<T> state) {
		state.setId(id);
	}
}
