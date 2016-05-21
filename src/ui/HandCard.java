package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import cards.Card;

@SuppressWarnings("serial")
public class HandCard<T extends Card> extends CardDrawable {
	private T card;
	private boolean hover, selected;

	public HandCard(T card) {
		this.card = card;
		setOpaque(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(card.getImage(), 0, 0, null);

		if (hover) {
			((Graphics2D)g).setStroke(BORDER_STROKE);
			g.setColor(TRANS_BLUE);
			g.fillRect(0, 0, Card.IMG_WIDTH, Card.IMG_HEIGHT);
		}
//		if (selected) {
//			((Graphics2D)g).setStroke(BORDER_STROKE);
//			g.setColor(TRANS_RED);
//			g.fillRect(0, 0, Card.IMG_WIDTH, Card.IMG_HEIGHT);
//		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
//		System.out.println("pressed " + card);
		selected = !selected;
		Rectangle bounds = getBounds();
		setBounds(bounds.x, Hand.VERT_OFFSET - bounds.y, bounds.width, bounds.height);

		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
//		System.out.println("entered " + card);
		hover = true;
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
//		System.out.println("exited " + card);
		hover = false;
		repaint();
	}

	//TODO: set preferred size, rotate, mark selected?

}
