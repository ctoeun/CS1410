package a9a;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Cop extends Actor {
	
	public Cop(Point2D.Double startingPosition, Point2D.Double initHitbox, BufferedImage img, int health, int coolDown, int attackDamage) {
		super(startingPosition, initHitbox, img, health, coolDown, 0, attackDamage);
	}

	/**
	 * An attack means the two hotboxes are overlapping and the
	 * Actor is ready to attack again (based on its cooldown).
	 * 
	 * Plants only attack Zombies.
	 * 
	 * @param other
	 */
	@Override
	public void attack(Actor other) {
		if (other instanceof Robber)
			super.attack(other);
	}
}
