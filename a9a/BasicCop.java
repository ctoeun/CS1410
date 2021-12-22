package a9a;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BasicCop extends Cop {
	
	private static final int HEALTH = 100, COOLDOWN = 2, ATTACK = 1;
	private static final BufferedImage image;
	
	static {
		BufferedImage localImage = null;
		try {
			localImage = ImageIO.read(new File("src/a9/basicCop.png"));
		} catch (IOException e) {
			System.out.println("basic cop image was not found");
			System.exit(0);
		}
		image = localImage;
	}
	
	public BasicCop(Point2D.Double startingPosition, Point2D.Double initHitbox) {
		super(startingPosition, initHitbox, image, HEALTH, COOLDOWN, ATTACK);
	}
}
