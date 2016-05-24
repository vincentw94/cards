package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.util.LinkedList;

import cards.Card;

@SuppressWarnings("serial")
public class Pile<T extends Card> extends CardDrawable {
	private static final double SIZE_SCALE = 0.7;	// draw cards in pile smaller

	private final int IMG_DRAW_WIDTH = (int)(T.IMG_WIDTH * SIZE_SCALE), IMG_DRAW_HEIGHT = (int)(T.IMG_HEIGHT * SIZE_SCALE);
	private final int DIAG = (int)(Math.sqrt(T.IMG_WIDTH*T.IMG_WIDTH + T.IMG_HEIGHT*T.IMG_HEIGHT) * SIZE_SCALE);

	private LinkedList<T> pile;
	private LinkedList<Double> rot;

	public Pile(int x, int y) {
		pile = new LinkedList<T>();
		rot = new LinkedList<Double>();

		setBounds(x, y, DIAG, DIAG);
	}

	public void add(T card) {
		pile.add(card);
		rot.add(Math.random() * 2 * Math.PI);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		AffineTransform base = g2d.getTransform();

		for (int i=0; i<pile.size(); i++) {
			g2d.translate(DIAG/2, DIAG/2);
			g2d.rotate(rot.get(i));
			g2d.translate(-IMG_DRAW_WIDTH/2, -IMG_DRAW_HEIGHT/2);
			g2d.drawImage(pile.get(i).getImage(), 0, 0, IMG_DRAW_WIDTH, IMG_DRAW_HEIGHT, null);

			g2d.setTransform(base);
		}

		if (hover) {
			g2d.setStroke(BORDER_STROKE);
			g2d.setColor(TRANS_BLUE);
			g2d.fillRect(0, 0, DIAG, DIAG);
		}

		g2d.dispose();

	}
}
