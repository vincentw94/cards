package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import network.GameClient;
import cards.Card;

@SuppressWarnings("serial")
public class HandCard<T extends Card> extends CardDrawable {
	protected T card;
	private boolean selected;

	public HandCard(T card, int ind, int numCards) {
		this.card = card;
		setOpaque(true);

		updateIndex(ind, numCards);
	}

	public void updateIndex(int ind, int numCards) {
		int totalWidth = (numCards - 1) * Hand.HORIZ_OFFSET + T.IMG_WIDTH, startX = GameClient.WIDTH/2 - totalWidth/2;
		int currY = selected ? 0 : Hand.VERT_OFFSET;
		int newX = startX + ind * Hand.HORIZ_OFFSET;
		setBounds(newX, currY, T.IMG_WIDTH, T.IMG_HEIGHT);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(card.getImage(), 0, 0, null);

		if (hover) {
			((Graphics2D)g).setStroke(BORDER_STROKE);
			g.setColor(TRANS_BLUE);
			g.fillRect(0, 0, T.IMG_WIDTH, T.IMG_HEIGHT);
		}
//		if (selected) {
//			((Graphics2D)g).setStroke(BORDER_STROKE);
//			g.setColor(TRANS_RED);
//			g.fillRect(0, 0, T.IMG_WIDTH, T.IMG_HEIGHT);
//		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		selected = !selected;
		Rectangle bounds = getBounds();
		setBounds(bounds.x, selected ? 0 : Hand.VERT_OFFSET, bounds.width, bounds.height);

		repaint();

		if (e.getClickCount() == 2) {
			// TODO: play card
		}
	}

	//TODO: set preferred size, rotate, mark selected?

}
