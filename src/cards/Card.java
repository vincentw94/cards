package cards;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Card {
	public static final int IMG_WIDTH = 64*2, IMG_HEIGHT = 89*2;		// standard card 64mm x 89mm

	private BufferedImage img;

	public Card(String imgFn) {
		try {
			img = ImageIO.read(new File("Poker Card Imgs/" + imgFn + ".png"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
		Image scaled = img.getScaledInstance(IMG_WIDTH, IMG_HEIGHT, BufferedImage.SCALE_SMOOTH);

		img = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
		img.getGraphics().drawImage(scaled, 0, 0, null);
	}

	public BufferedImage getImage() {
		return img;
	}
}
