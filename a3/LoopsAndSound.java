package a3;

import java.util.Arrays;

/**
 * CS1410 Loops and Sound Assignment 3 
 * Each method uses a variety of loops with arrays.
 * 
 * @author Cobi Toeun
 *
 */
public class LoopsAndSound {
	/**
	 * After calling the method, the array has its elements swapped with zeros. 
	 * For example: [1,2] will change to [0,0]
	 * 
	 * @param zeros An array of elements that when called, will swap to zero
	 */
	public static void clearArray(int[] zeros) {
		for (int index = 0; index < zeros.length; index++)
			zeros[index] = 0;
	}

	/**
	 * The method takes an element of arrays and turn them into a string.
	 * Arrays.toString method NOT used. First starts with an empty string, and uses
	 * a for loop to store arrays in new variable, which is text. To handle the last
	 * number, an if statement is used to determine that if text ends with ", " it
	 * will remove two spaces. 
	 * For example: [1,2] will turn to {1,2}
	 * 
	 * @param array An array of integers, that will turn into a string
	 * @return Returns a String version of an array. Starts and ends with curly
	 *         brackets. Commas are including after every number except the final one.
	 */
	public static String arrayToString(int[] array) {
		String text = "";
		char comma = ',';

		for (int index = 0; index < array.length; index++) {
			text += array[index];
			text += comma + " ";
		}
		if (text.endsWith(", ")) {
			text = text.substring(0, text.length() - 2);
		}
		text = '{' + text + '}';
		return text;
	}

	/**
	 * This method takes a string and replaces the characters 'a' with an '*'. An
	 * empty string is first used. A for loop is then used to count every character
	 * in the sentence. If a character contains 'a', then '*' will be replaced in
	 * its location. The final characters will be combined into a string.
	 * For example: "A rabbit" will turn to "A r*bbit"
	 * 
	 * @param sentence A string used in method: "This phrase contains multiple a's".
	 * @return Returns a string with the same characters, except every letter 'a' is
	 *         replaced with '*'.
	 */
	public static String hideLetterA(String sentence) {
		String letters = "";
		char asterisk = '*';

		for (int count = 0; count < sentence.length(); count++) {
			char replaceA = sentence.charAt(count);
			if (replaceA == 'a') {
				replaceA = asterisk;
			}
			letters += replaceA;
		}
		return letters;
	}

	/**
	 * This methods takes an array of numbers and determines if there are more even
	 * numbers than odd. The mod operator is used to determine if the number is
	 * divisible by two. If divisible, then it will store into the even variable and
	 * odd otherwise. Returns true if there are more even numbers than odd and false
	 * otherwise. Zero and negative numbers won't be counted.
	 * For example: {1,2,3} will return false because there's more odd numbers than even.
	 * 
	 * @param numbers An array of integers
	 * @return Returns boolean true or false. True if there are more even numbers
	 *         than odd and false otherwise.
	 */
	public static boolean hasMoreEvenThanOdd(int[] numbers) {
		int even = 0;
		int odd = 0;

		for (int index = 0; index < numbers.length; index++) {
			if (numbers[index] % 2 == 0) {
				even += numbers[index];
			} else if (numbers[index] % 2 != 0) {
				odd += numbers[index];
			}
		}
		if (even > odd)
			return true;
		else
			return false;
	}

	/**
	 * This method takes the sum an array of elements, and divides them by the array.
	 * Find number at index position, and adds it to current sum. Once past
	 * array length, divides sum and array length.
	 * For example: {1,2} will return 1.5.
	 * 
	 * @param numbers An array of integers with at least length of one
	 * @return Returns double value with the sum of array elements, divided by the
	 *         length of array
	 */
	public static double averageArrayValues(int[] numbers) {
		double sum = 0;
		double average = 0;
		int count = numbers.length;

		for (int index = 0; index < numbers.length; index++) {
			sum += numbers[index];
		}
		return average = sum / count;
	}

	/**
	 * This method take an array of elements and counts the frequency of the numbers
	 * from 0-9. 
	 * For example: {1,1,5,7,7}, turns to {0, 2, 0, 0, 0, 1, 0, 2, 0, 0}
	 * 
	 * @param frequency An array of elements
	 * @return Returns an array of ten new integers. New array has index n is the
	 *         number of times value n appears in the parameter array.
	 */
	public static int[] frequencyCount(int[] frequency) {
		int newFrequency[] = new int[10];

		for (int index = 0; index < frequency.length; index++) {

			if (frequency[index] == 0) {
				newFrequency[0] += 1;

			} else if (frequency[index] == 1) {
				newFrequency[1] += 1;

			} else if (frequency[index] == 2) {
				newFrequency[2] += 1;

			} else if (frequency[index] == 3) {
				newFrequency[3] += 1;

			} else if (frequency[index] == 4) {
				newFrequency[4] += 1;

			} else if (frequency[index] == 5) {
				newFrequency[5] += 1;

			} else if (frequency[index] == 6) {
				newFrequency[6] += 1;

			} else if (frequency[index] == 7) {
				newFrequency[7] += 1;

			} else if (frequency[index] == 8) {
				newFrequency[8] += 1;

			} else if (frequency[index] == 9) {
				newFrequency[9] += 1;

			}
		}
		return newFrequency;
	}

	/**
	 * This method take a double array of elements and reverses their order. The reversed
	 * variable is set at the index count, which is being incremented by 1.
	 * Index for sound is working backwards and subtracting after every loop and storing into reversed.
	 *  
	 * For example: {1.0,2.0}, turns into {2.0,1.0}
	 * 
	 * @param sound A double array of elements
	 * @return Returns a double array that has been reversed in order.
	 */
	public static double[] reverseSound(double[] sound) {
		double reversed[] = new double[sound.length];
		int count = 0;
		
		for (int index = sound.length - 1; index >= 0; index--) {
			reversed[count++] = sound[index];
		}
		return reversed;
	}

	/**
	 * This method takes double array of elements and scales it by the scaled
	 * number. 
	 * For example: ([0.0, -0.1, 0.3], 2.0) should return a new array [0.0, -0.2, 0.6]
	 * 
	 * @param scaleSound The double array of elements
	 * @param scale      Number used to scale the arrays. If two, then it will
	 *                   multiply each array by two.
	 * @return Returns a new double array, that has been scale by a number if the
	 *         number is three, then each array element will be tripled.
	 */
	public static double[] scaleSound(double[] scaleSound, double scale) {

		for (int index = 0; index < scaleSound.length; index++) {
			scaleSound[index] *= scale;
		}

		return scaleSound;
	}

	/**
	 * This method takes an array of elements and creates an echo effect depending
	 * on the offset and weight value. The first offset samples will be the same as 
	 * the first offset samples as the parameter array. The last offset samples will be 
	 * the same as the last offset samples from the parameter array scaled by the weight 
	 * parameter. The middle samples will be the sample from the parameter array plus the
	 * sample from the parameter array back the offset amount scaled by the weight parameter.
	 * For example: {0.1, 0.2, 0.3, 0.4}, 1, 0.5 will return {0.1, 0.25, 0.4, 0.55, 0.2}.
	 * 
	 * @param echo   A double array of elements
	 * @param offset An integer specifying how many samples offset the echo starts
	 *               at
	 * @param weight A double giving a weight to the echo
	 * @return Returns a double array plus the offset parameter.
	 */
	public static double[] echoSound(double[] echo, int offset, double weight) {
		double newEcho[] = new double[echo.length + offset];

		newEcho[0] = echo[0];
		newEcho[echo.length] = echo[echo.length - 1] * weight;
		for (int index = 0; index < echo.length; index++) {
			if (index > 0) {
				newEcho[index] = echo[index] + (echo[index - 1] * weight);
			}
		}
		return newEcho;
	}

	/**
	 * This method reduces noise played in the sound. The first and last elements are the 
	 * average of the first and last two elements of the parameter. The other elements are 
	 * the average of the elements at indices index-1, index, and index+1.
	 * For example: Calling smoothSound([0.0, 0.2, 0.7, 0.2]) should return a new array [0.1, 0.3,
	 * 0.3666,0.45].
	 * 
	 * @param smooth A double array with at least three elements
	 * @return Returns a double array that has as its elements a sliding average of
	 *         the parameter array elements.
	 */
	public static double[] smoothSound(double[] smooth) {
		double newSmooth[] = new double[smooth.length];

		newSmooth[0] = (smooth[0] + smooth[1]) / 2;
		newSmooth[smooth.length - 1] = (smooth[smooth.length - 1] + smooth[smooth.length - 2]) / 2;

		for (int index = 1; index < smooth.length - 1; index++) {
			newSmooth[index] = (smooth[index - 1] + smooth[index] + smooth[index + 1]) / 3;
		}
		return newSmooth;
	}

	/**
	 * Main method used for testing called methods. Created variables with
	 * meaningful names to keep track of tests. Sound method tests are included to
	 * appreciate the use of sounds in java.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Integer and double variables with initializations
		int zeros[] = { 1, 2, 3 };
		int array[] = { 1, 2, 4 };
		int emptyArray[] = {};
		int negativeArray[] = {0, -1, -2};
		int falseArray[] = { 1, 2, 3 };
		int frequency[] = { 1, 1, 9, 4, 8, 9, 3 };
		int offset = 1;

		double sound[] = { 1.0, 2.0, 4.0, 8.0, 2.0 };
		double scaledSound[] = { -0.1, 0.1, 0.3 };
		double echoedSound[] = { 0.1, 0.2, 0.3, 0.4 };
		double smooth[] = { 0.0, 0.2, 0.7, 0.2 };
		double scale = 2.0;
		double weight = 0.5;

		// Testing sound methods
		double[] samples = StdAudio.read("asyouwish2.wav");
		StdAudio.play(samples);

		double[] reversed = reverseSound(samples);
		StdAudio.play(reversed);

		double[] scaleSound = scaleSound(samples, scale);
		StdAudio.play(scaleSound);

		double[] echoSound = echoSound(samples, offset, weight);
		StdAudio.play(echoSound);

		double[] smoothSound = smoothSound(samples);
		StdAudio.play(smoothSound);
		StdAudio.close();

		// Testing and printing code here + calling methods
		arrayToString(array);
		frequencyCount(frequency);
		reverseSound(sound);
		scaleSound(scaledSound, scale);
		echoSound(sound, offset, weight);
		smoothSound(smooth);

		System.out.println("Testing code");
		System.out.println("============");
		System.out.println("1. Change array to zeros before call: " + Arrays.toString(zeros));
		clearArray(zeros);
		System.out.println("Change array to zeros after call: " + Arrays.toString(zeros));
		System.out.println();
		System.out.println("2. " + Arrays.toString(array) + " to String: " + arrayToString(array));
		System.out.println("Special case for " + Arrays.toString(emptyArray) + ": " + arrayToString(emptyArray));
		System.out.println();
		System.out.println("3. Hide letter 'a': " + hideLetterA("This phrase has a couple a's"));
		System.out.println("No 'a': " + hideLetterA("This sentence doesn't include lower 'A'"));
		System.out.println();
		System.out.println("4. More even than odd for " + Arrays.toString(array) + ": " + hasMoreEvenThanOdd(array));
		System.out.println(
				"False case scenerio for " + Arrays.toString(falseArray) + ": " + hasMoreEvenThanOdd(falseArray));
		System.out.println("Zero and negative array for " + Arrays.toString(negativeArray) + ": " + hasMoreEvenThanOdd(negativeArray));
		System.out.println();
		System.out.println("5. Average sum of " + Arrays.toString(array) + ": " + averageArrayValues(array));
		System.out.println();
		System.out.println(
			"6. "+ Arrays.toString(frequency) + " frequency count: " + Arrays.toString(frequencyCount(frequency)));
		System.out.println();
		System.out.println("7. " + Arrays.toString(sound) + " reversed: " + Arrays.toString(reverseSound(sound)));
		System.out.println();
		System.out.println("8. Array scaled by " + scale + ": " + Arrays.toString(scaledSound));
		System.out.println();
		System.out.println("9. " + Arrays.toString(echoedSound) + " with offset of " + offset + " and weight of " + weight
				+ ": " + Arrays.toString(echoSound(echoedSound, offset, weight)));
		System.out.println();
		System.out.println("10. " + Arrays.toString(smooth) + " to smooth sound: " + Arrays.toString(smoothSound(smooth)));

	}

}