package cards;
import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class Card {
	private static final int IMG_WIDTH = 64*2, IMG_HEIGHT = 89*2;		// standard card 64mm x 89mm
	
	private BufferedImage img;
	
	public Card(String imgFn) {
		
		Image scaled = img.getScaledInstance(IMG_WIDTH, IMG_HEIGHT, BufferedImage.SCALE_SMOOTH);
		
		this.img = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
		this.img.getGraphics().drawImage(scaled, 0, 0, null);
	}
	
	public BufferedImage getImage() {
		return img;
	}
}
