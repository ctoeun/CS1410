package a9a;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CopsAndRobbers extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Timer timer;
	private ArrayList<Actor> actors; // Plants and zombies all go in here
	BufferedImage copImage; // Maybe these images should be in those classes, but easy to change here.
	BufferedImage robberImage;
	int numRows, numCols, cellSize;
	private Random randomGenerator;

	/**
	 * Setup the basic info for the example
	 */
	public CopsAndRobbers() {
		super();

		// Define some quantities of the scene
		numRows = 5;
		numCols = 7;
		cellSize = 100;
		setPreferredSize(new Dimension(50 + numCols * cellSize, 50 + numRows * cellSize));
		randomGenerator = new Random();

		// Store all the plants and zombies in here.
		actors = new ArrayList<>();

		// Load images
		try {
			robberImage = ImageIO.read(new File("src/a9/robber.png"));
		} catch (IOException e) {
			System.out.println("A file was not found");
			System.exit(0);
		}

		// Make a plant
//		Plant plant = new Plant(new Point2D.Double(200, 200),
//				new Point2D.Double(plantImage.getWidth(), plantImage.getHeight()), plantImage, 100, 5, 1);
		// Make a zombie
//		Zombie zombie = new Zombie(new Point2D.Double(500, 200),
//				new Point2D.Double(plantImage.getWidth(), plantImage.getHeight()), zombieImage, 100, 50, -2, 10);
//
		// Add them to the list of actors
//		actors.add(plant);
//		actors.add(zombie);

		// The timer updates the game each time it goes.
		// Get the javax.swing Timer, not from util.
		timer = new Timer(30, this);
		timer.start();

	}

	/***
	 * Implement the paint method to draw the plants
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Actor actor : actors) {
			actor.draw(g, 0);
			actor.drawHealthBar(g);
		}
	}

	/**
	 * 
	 * This is triggered by the timer. It is the game loop of this test.
	 * 
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (randomGenerator.nextInt(100) > 97) {
			int col = randomGenerator.nextInt(7);
			int row = randomGenerator.nextInt(5);

			int x = col * 100;
			int y = row * 100;

			BasicCop cop = new BasicCop(new Point2D.Double(x, y),
					new Point2D.Double(robberImage.getWidth(), robberImage.getHeight()));
			FatCop fatCop = new FatCop(new Point2D.Double(x, y),
					new Point2D.Double(robberImage.getWidth(), robberImage.getHeight()));

			int randomPlacement = randomGenerator.nextInt(2);
			if (randomPlacement == 1) {
				actors.add(cop);
			} else {
				actors.add(fatCop);
			}

		}

		if (randomGenerator.nextInt(100) > 98) {

			int col = randomGenerator.nextInt(7);
			int row = randomGenerator.nextInt(5);

			int x = col * 100;
			int y = row * 100;

			Robber robber = new Robber(new Point2D.Double(800, y),
					new Point2D.Double(robberImage.getWidth(), robberImage.getHeight()), robberImage, 100, 50, -2, 10);

			actors.add(robber);

		}

		// This method is getting a little long, but it is mostly loop code
		// Increment their cooldowns and reset collision status
		for (Actor actor : actors) {
			actor.update();
		}

		// Try to attack
		for (Actor actor : actors) {
			for (Actor other : actors) {
				actor.attack(other);
			}
		}

		// Remove plants and zombies with low health
		ArrayList<Actor> nextTurnActors = new ArrayList<>();
		for (Actor actor : actors) {
			if (actor.isAlive())
				nextTurnActors.add(actor);
			else
				actor.removeAction(actors); // any special effect or whatever on removal
		}
		actors = nextTurnActors;

		// Check for collisions between zombies and plants and set collision status
		for (Actor actor : actors) {
			for (Actor other : actors) {
				actor.setCollisionStatus(other);
			}
		}

		// Move the actors.
		for (Actor actor : actors) {
			actor.move(); // for Zombie, only moves if not colliding.
		}

		// Redraw the new scene
		repaint();
	}

	/**
	 * Make the game and run it
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame app = new JFrame("Cops and Robbers");
				app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				CopsAndRobbers panel = new CopsAndRobbers();

				app.setContentPane(panel);
				app.pack();
				app.setVisible(true);
				app.setLocationRelativeTo(null);
			}
		});
	}

}