package a9a;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FatCop extends Cop {
	
	private static final int HEALTH = 200, COOLDOWN = 50, ATTACK = 25;
	private static final BufferedImage image;
	
	static {
		BufferedImage localImage = null;
		try {
			localImage = ImageIO.read(new File("src/a9/fatCop.png"));
		} catch (IOException e) {
			System.out.println("fat cop image was not found");
			System.exit(0);
		}
		image = localImage;
	}
	
	public FatCop(Point2D.Double startingPosition, Point2D.Double initHitbox) {
		super(startingPosition, initHitbox, image, HEALTH, COOLDOWN, ATTACK);
	}
}
