package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public abstract class CardDrawable extends JComponent implements MouseListener, MouseMotionListener {
	protected static final Stroke BORDER_STROKE = new BasicStroke(5);
	protected static final Color TRANS_BLUE = new Color(0, 0, 255, 127), TRANS_RED = new Color(255, 0, 0, 127);

	public CardDrawable() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
