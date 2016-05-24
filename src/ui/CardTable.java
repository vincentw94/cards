package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import network.GameClient;

@SuppressWarnings("serial")
public class CardTable extends JPanel {
	private Image backgroundImg;

	public CardTable() {
		try {
			backgroundImg = ImageIO.read(new File("Card_UI_BG.jpg")).getScaledInstance(GameClient.WIDTH, GameClient.HEIGHT, Image.SCALE_SMOOTH);
		} catch (IOException ioe) {
			System.err.println("Failed to load background image!");
			ioe.printStackTrace();
		}

		setOpaque(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (backgroundImg != null)
			g.drawImage(backgroundImg, 0, 0, null);

		// rotated graphics test
//			Graphics2D g2d = (Graphics2D)(g.create());
//			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//			g2d.setColor(Color.WHITE);
//			g2d.translate(100, 100);
//			g2d.rotate(Math.toRadians(30));
//			g2d.fillRect(0, 0, 100, 100);
//			g2d.dispose();
	}
}
