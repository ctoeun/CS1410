package a8;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * Rock Paper Scissors GUI with Player VS Computer and option of choosing
 * computer style of random choice or last player choice. Project contains a
 * collection of JPanels, JButtons, JLabels, and JRadioButtons.
 * 
 * @author Cobi Toeun
 *
 */
public class Battle extends JFrame implements ActionListener { // extends the JFrame and adds an action listener
	// declaration of private variables for the whole class
	private JPanel mainPanel, leftPanel, middlePanel, rightPanel, score, options, gui;
	private JButton rock, paper, scissors, restart, quit;
	private JLabel playerChoice, playerInput, compChoice, compInput, winner, winnerInput, playerScore, compScore,
			tieScore, round;
	private JRadioButton randomChoice, lastPlayerChoice;
	private TitledBorder playerChoiceTitle, gameResult, compStyle;
	private Border leftBorder, middleBorder, rightBorder;
	private int playerCount, compCount, tieCount, roundCount;

	/**
	 * Battle constructor that creates super JFrame with heading of "Rock Paper Scissors", calls
	 * JPanel methods and adds action listener to JButtons.
	 */
	public Battle() {
		super("Rock Paper Scissors");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// calling JPanel Methods
		scorePanel();
		playerChoicePanel();
		gameResultPanel();
		computerStylePanel();
		mainPanel();
		optionsPanel();
		gui();

		// adding action listener to JButtons
		rock.addActionListener(this);
		paper.addActionListener(this);
		scissors.addActionListener(this);
		randomChoice.addActionListener(this);
		lastPlayerChoice.addActionListener(this);
		restart.addActionListener(this);
		quit.addActionListener(this);

		// packing panels together and setting position
		this.setContentPane(gui);
		this.pack();
		this.setLocationRelativeTo(null);

	}

	/**
	 * Method creates top score panel with scores of the player, ties, and computer
	 * in a 1x3 grid layout.
	 */
	public void scorePanel() {
		score = new JPanel();
		score.setLayout(new GridLayout(1, 3));

		playerScore = new JLabel("Player: 0");
		playerScore.setHorizontalAlignment(JLabel.CENTER);
		tieScore = new JLabel("Tie: 0");
		tieScore.setHorizontalAlignment(JLabel.CENTER);
		compScore = new JLabel("Computer: 0");
		compScore.setHorizontalAlignment(JLabel.CENTER);

		score.add(playerScore);
		score.add(tieScore);
		score.add(compScore);

	}

	/**
	 * Method that creates left player choice panel with Rock, Paper, Scissors
	 * JButtons in a 3x3 grid layout. Titled etched border is added to provide a
	 * cleaner look.
	 */
	public void playerChoicePanel() {
		leftPanel = new JPanel();
		leftBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		playerChoiceTitle = BorderFactory.createTitledBorder(leftBorder, "Player Choice");

		GridLayout box = new GridLayout(3, 3);
		leftPanel.setLayout(box);
		box.setHgap(10);
		box.setVgap(10);

		rock = new JButton("Rock");
		paper = new JButton("Paper");
		scissors = new JButton("Scissors");

		leftPanel.setBorder(playerChoiceTitle);

		leftPanel.add(rock);
		leftPanel.add(new JLabel(""));
		leftPanel.add(paper);
		leftPanel.add(new JLabel(""));
		leftPanel.add(scissors);
		leftPanel.add(new JLabel(""));

	}

	/**
	 * Method that creates middle game result panel with JLabel inputs of the
	 * player, computer, and winner in a 3x3 grid layout. Titled etched border is
	 * added to provide a cleaner look.
	 */
	public void gameResultPanel() {
		middlePanel = new JPanel();
		middleBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		gameResult = BorderFactory.createTitledBorder(middleBorder, "Game Result");
		gameResult.setTitleJustification(TitledBorder.CENTER);
		GridLayout box = new GridLayout(3, 3);
		middlePanel.setLayout(box);
		box.setHgap(25);
		box.setVgap(25);

		playerChoice = new JLabel("Player Move: ");
		playerInput = new JLabel("");
		compChoice = new JLabel("Computer Move: ");
		compInput = new JLabel("");
		winner = new JLabel("Winner: ");
		winnerInput = new JLabel("");

		middlePanel.setBorder(gameResult);

		middlePanel.add(playerChoice);
		middlePanel.add(playerInput);
		middlePanel.add(compChoice);
		middlePanel.add(compInput);
		middlePanel.add(winner);
		middlePanel.add(winnerInput);
	}

	/**
	 * Method that creates right computer style panel with JRadioButtons providing
	 * more play styles for the computer in a 2x1 grid layout. Random computer
	 * choice is the default selection when opening up the game. Titled etched
	 * border is provided to give a cleaner look.
	 */
	public void computerStylePanel() {
		rightPanel = new JPanel();
		rightBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		compStyle = BorderFactory.createTitledBorder(rightBorder, "Computer Style");
		compStyle.setTitleJustification(TitledBorder.RIGHT);

		GridLayout row = new GridLayout(2, 1);
		rightPanel.setLayout(row);

		randomChoice = new JRadioButton("Random Choice", true);
		lastPlayerChoice = new JRadioButton("Last Player Choice");
		ButtonGroup group = new ButtonGroup();
		group.add(randomChoice);
		group.add(lastPlayerChoice);

		rightPanel.setBorder(compStyle);

		rightPanel.add(randomChoice);
		rightPanel.add(lastPlayerChoice);

	}

	/**
	 * Method for main middle panel. Adding left, middle, and right panel from above
	 * into a flow layout panel.
	 */
	public void mainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());

		mainPanel.add(leftPanel);
		mainPanel.add(middlePanel);
		mainPanel.add(rightPanel);
	}

	/**
	 * Method for bottom options panel with middle JLabel tracking the round and a restart and quit
	 * JButtons.
	 */
	public void optionsPanel() {
		options = new JPanel();
		options.setLayout(new GridLayout(1, 3));

		restart = new JButton("Restart");
		round = new JLabel("Round 1");
		round.setHorizontalAlignment(JLabel.CENTER);
		quit = new JButton("Quit");

		options.add(restart);
		options.add(round);
		options.add(quit);

	}

	/**
	 * Method for adding all above methods into one boxed layout GUI.
	 */
	public void gui() {
		gui = new JPanel();
		gui.setLayout(new BoxLayout(gui, BoxLayout.PAGE_AXIS));

		gui.add(score);
		gui.add(mainPanel);
		gui.add(options);
	}

	/**
	 * Method for generating a random string/index for computer choice. Random
	 * import is used to generate random integer between the array length or 3. That
	 * number will be stored into a variable that will place as in index in the
	 * array.
	 * 
	 * @return "Rock", "Paper", or "Scissors".
	 */
	public static String computerRandomChoice() {
		String[] array = { "Rock", "Paper", "Scissors" };
		Random random = new Random();

		int ran = random.nextInt(array.length);

		return array[ran];

	}

	/**
	 * Method used to determine the winner of rock paper scissors game. If
	 * statements and .equals() used to compare if string values equal to other
	 * string and responds accordingly.
	 * 
	 * @param player         String of playerChoice and used to compare with
	 *                       playerChoice.
	 * @param computerChoice String of computerChoice and used to compare with
	 *                       playerChoice.
	 * @return Winner of rock paper scissors game: "Tie", "Computer", "Player" or
	 *         null if no winner is found.
	 */
	public String pickWinner(String player, String computerChoice) {

		if (player.equals("Rock") && computerChoice.equals("Rock")) {
			tieCount++;
			tieScore.setText("Tie: " + tieCount);
			return "Tie";
		}
		if (player.equals("Rock") && computerChoice.equals("Paper")) {
			compCount++;
			compScore.setText("Computer: " + compCount);
			return "Computer";
		}
		if (player.equals("Rock") && computerChoice.equals("Scissors")) {
			playerCount++;
			playerScore.setText("Player: " + playerCount);
			return "Player";
		}
		if (player.equals("Paper") && computerChoice.equals("Paper")) {
			tieCount++;
			tieScore.setText("Tie: " + tieCount);
			return "Tie";
		}
		if (player.equals("Paper") && computerChoice.equals("Scissors")) {
			compCount++;
			compScore.setText("Computer: " + compCount);
			return "Computer";
		}
		if (player.equals("Paper") && computerChoice.equals("Rock")) {
			playerCount++;
			playerScore.setText("Player: " + playerCount);
			return "Player";
		}
		if (player.equals("Scissors") && computerChoice.equals("Scissors")) {
			tieCount++;
			tieScore.setText("Tie: " + tieCount);
			return "Tie";
		}
		if (player.equals("Scissors") && computerChoice.equals("Rock")) {
			compCount++;
			compScore.setText("Computer: " + compCount);
			return "Computer";
		}
		if (player.equals("Scissors") && computerChoice.equals("Paper")) {
			playerCount++;
			playerScore.setText("Player: " + playerCount);
			return "Player";
		}

		return null;

	}

	/**
	 * Main method that sets GUI to be visible when running
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Battle battle = new Battle();
		battle.setVisible(true);

	}

	/**
	 * Method where action listener is used. Once a JButton or JRadioButton is
	 * pressed or activated, the method will respond accordingly.
	 */
	@Override
	public void actionPerformed(ActionEvent e) { // if randomChoice JRadioButton is selected, the method will set the
													// computer style to be random.
		if (randomChoice.isSelected()) {
			String playerChoice = "";
			String computerChoice = computerRandomChoice();

			if (e.getSource() == rock) {
				roundCount++; 
				playerChoice = "Rock";

				playerInput.setText("Rock");
				compInput.setText(computerChoice);
			}

			if (e.getSource() == paper) {
				roundCount++;
				playerChoice = "Paper";

				playerInput.setText("Paper");
				compInput.setText(computerChoice);

			}

			if (e.getSource() == scissors) {
				roundCount++;
				playerChoice = "Scissors";

				playerInput.setText("Scissors");
				compInput.setText(computerChoice);

			}

			round.setText("Round " + roundCount);
			winnerInput.setText(pickWinner(playerChoice, computerChoice));
		}

		if (lastPlayerChoice.isSelected()) { // if lastPlayerChoice JRadioButton is selected, the method will grab the
												// previous playerInput and store it into a variable.
			String previousInput = playerInput.getText();
			String playerChoice = "";

			if (previousInput == "") {
				previousInput = "Rock";
			}

			if (e.getSource() == rock) {
				roundCount++;
				playerChoice = "Rock";

				playerInput.setText("Rock");
				compInput.setText(previousInput);

			}

			if (e.getSource() == paper) {
				roundCount++;
				playerChoice = "Paper";

				playerInput.setText("Paper");
				compInput.setText(previousInput);

			}

			if (e.getSource() == scissors) {
				roundCount++;
				playerChoice = "Scissors";

				playerInput.setText("Scissors");
				compInput.setText(previousInput);

			}

			round.setText("Round " + roundCount);
			winnerInput.setText(pickWinner(playerChoice, previousInput));
			
		}
		if (e.getSource() == quit) { // once quit JButton is pressed, the GUI will exit and be disposed.
			dispose();
		}

		if (e.getSource() == restart) { // one restart JButton is pressed, all inputed text will turn into an empty
										// string and the counters will set back to 0.
			playerCount = 0;
			compCount = 0;
			tieCount = 0;
			roundCount = 0;

			playerInput.setText("");
			compInput.setText("");
			winnerInput.setText("");
			round.setText("Round 1");
			playerScore.setText("Player: 0");
			tieScore.setText("Tie: 0");
			compScore.setText("Computer: 0");
		}
	}
}
