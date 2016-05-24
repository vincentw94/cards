package network;

import games.ClientGameState;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import cards.Card;

public abstract class Transaction<T extends Card> implements Serializable {
	private static final transient long serialVersionUID = 8131878057020275503L;

	public abstract void action(ClientGameState<T> clientState);

	@SuppressWarnings("rawtypes")
	public static final Transaction deserialize(String str) throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(str.getBytes()));
		return (Transaction) in.readObject();
	}

	public final String serialize() throws IOException {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bytes);
		out.writeObject(this);
		out.close();

		return new String(bytes.toByteArray());
	}


}
