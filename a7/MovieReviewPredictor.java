package a7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class reads in a file of movie reviews. From that it "learns" what words
 * are associated with good reviews and what are associated with poor reviews.
 * It can then predict the score for a new review that contains those words.
 * 
 * @author Prof. David E. Johnson
 * @author Cobi Toeun
 *
 */
public class MovieReviewPredictor {

	// The wordValue maps a word to its average score from the reviews.
	HashMap<String, Double> wordValue;

	/**
	 * Construct a new MovieReviewPredictor by reading in a file of reviews with
	 * scores and using that to create a mapping between a word and its score. At
	 * the end of the constructor, the wordValue HashMap should be filled in and
	 * ready to be used.
	 * 
	 * A helpful message should be printed and then System exit called if the file
	 * is not found.
	 */
	public MovieReviewPredictor(String filename) {
		// Read in the lines from the filename.

		// Get the word values from the lines and store them in wordValue
		// using the appropriate class method.
	}

	/**
	 * Read the lines from the file and stores each in an ArrayList. Each line
	 * should be processed as follows: - the line is set to all lower case using the
	 * String toLowerCase method - punctuation is removed by removing all characters
	 * that are not a through z or 0 through 9. This can be done using the String
	 * replaceAll method, like 
	 * String newString = string.replaceAll("[^a-z0-9 ]", "");
	 * 
	 * @param filename the name of the file to read
	 * @return an ArrayList of the lines with punctuation removed and made all
	 *         lowercase.
	 * @throws FileNotFoundException
	 */
	public static ArrayList<String> linesFromFile(String filename) throws FileNotFoundException {
		ArrayList<String> lines = new ArrayList<>();
		File file = new File(filename);
		Scanner s = new Scanner(file);
		while (s.hasNextLine()) {
			String line = s.nextLine().toLowerCase();
			line = line.replaceAll("[^a-z0-9 ]", "");
			lines.add(line);
		}
		return lines;
	}

	/**
	 * Given an ArrayList of review Strings, compute the total score associated with
	 * each word and the number of times each word appears.
	 * 
	 * @param reviews     An ArrayList of lines representing reviews. The first word
	 *                    in each line is a score.
	 * @param totalScores a HashMap of each word as a key and its total score as the
	 *                    value
	 * @param wordCount   a HashMap of each word as a key and the number of times it
	 *                    appears in the reviews as a value
	 */
	public void computeScoreAndCounts(ArrayList<String> reviews, HashMap<String, Integer> totalScores,
			HashMap<String, Integer> wordCount) {
		// Loop over all the reviews.
		// Break a review into words with String split.
		// Find the score for the review using the first item in the split array and
		// Integer.parseInt.
		// Loop over the rest of the words.
		// For each word, build up the score and total HashMap entries.

		// Use these debugging statements as you work on your code, then remove them
		// before submitting.
		System.out.println("Word totals: " + totalScores);
		System.out.println("Word counts: " + wordCount);
	}

	/**
	 * Given a list of reviews from the file, this method computes the average score
	 * for each word in the reviews and stores that score in the wordValue HashMap,
	 * where the key is the word and the value is the average score.
	 * 
	 * To get the average score, first compute the total score for a word and the
	 * number of times it appears.
	 * 
	 * As a slight improvement, only store the word in wordValue if the score is not
	 * an average word - if the score is less than 1.75 or greater than 2.25.
	 * 
	 * @param reviews An ArrayList of lines representing reviews. The first word in
	 *                each line is a score.
	 */
	public void computeWordValue(ArrayList<String> reviews) {

		// Initialize any needed HashMaps

		// Compute the word total scores and counts using the appropriate method.

		// Build a HashMap of average scores
	}

	/**
	 * This method predicts a review score given a review. A review is of the form
	 * "some text all in lower case and no punctuation". The predicted score is the
	 * average wordValue of any non-null word.
	 * 
	 * @param review a String of numbers and lowercase letters.
	 * @return the predicted score, or -1 if the review has no words in wordValue.
	 */
	public double predictScore(String review) {
		return 0;
		// Break the review into words

		/*
		 * Find the total score for all words in the review that are in the wordValue
		 * HashMap. Count up how many words added to the score.
		 */

		// Compute the average using the total score and word count.
	}

	/**
	 * Predict movie reviews by first learning about words in review. (This does not
	 * need to be modified).
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// First write and test your program with the small set of reviews. Then,
		// learn with the big file and try different tests.
//		String learningFilename = "src/a7/MovieReviews.txt";
		String learningFilename = "src/a7/smallReviews.txt";

		// Make an instance of the predictor based on the filename.
		MovieReviewPredictor predictor = new MovieReviewPredictor(learningFilename);
		System.out.println(predictor.wordValue);

		// Test the predictor.
		String testFilename = "src/a7/smallReviews.txt";
		// Read the file of test reviews.
		ArrayList<String> lines = null;
		try {
			lines = linesFromFile(testFilename);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the file for testing");
			System.exit(-1);
		}

		// Loop over each review. Compare the predicted score with the real score.
		for (int index = 0; index < lines.size(); index++) {
			String line = lines.get(index);
			String[] words = line.split(" ");
			String noScoreLine = "";
			for (int wordIndex = 1; wordIndex < words.length; wordIndex++)
				noScoreLine += words[wordIndex] + " ";
			String prediction = String.format("%.1f", predictor.predictScore(noScoreLine));
			System.out.print("Predicted: " + prediction + " Actual: ");
			System.out.println(line);
		}
	}
}
