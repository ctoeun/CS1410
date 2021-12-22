package a4;

import java.awt.Color; // used to test and print color
import java.util.Arrays; // used to print arrays

/**
 * Loop patterns CS 1410 Assignment 4 
 * Each method uses loop patters
 * 
 * @author Cobi Toeun
 *
 */
public class LoopPatterns {
	/**
	 * This method takes an array of strings and finds the lowest alphabetical
	 * string. The String method "compareTo()" is used to compare two strings with
	 * each other. 
	 * For example: lowestAlphabetically(["cat", "dog", "apple", "fish"]) would return "apple".
	 * 
	 * @param list An array of lower-case strings, each made up of letters from a-z
	 * @return Returns a string containing the lowest alphabetical word.
	 */
	public static String lowestAlphabetically(String[] list) {
		String lowest = "";

		for (int index = 0; index < list.length; index++) {
			if (list[0].compareTo(list[index]) >= 0)
				lowest = list[index];
		}
		return lowest;
	}

	/**
	 * This method finds the smallest number between two arrays. First array
	 * compares each index with index 0, then stores it into a variable. Second
	 * array does the same. Final statement compares value with value 2 to see which
	 * value is smaller. 
	 * For example: findSmallestNumberInTwoArrays([12, 3, 5], [2, -1, 10]) would return -1.
	 * 
	 * @param array  First array of elements with length of at least 1
	 * @param array2 Second array of elements with length of at least 1
	 * @return Returns an integer value containing the smallest number found in the
	 *         two arrays.
	 */
	public static int findSmallestNumberInTwoArrays(int[] array, int[] array2) {
		int value = array[0];
		int value2 = array2[0];

		for (int index = 0; index < array.length; index++) {
			if (array[index] < value)
				value = array[index];

			if (array2[index] < value2)
				value2 = array2[index];
		}
		if (value < value2)
			return value;
		else
			return value2;
	}

	/**
	 * This method takes an array of elements and makes a curve depending how far
	 * the highest number is compared to 100. All the other numbers are added by the
	 * same amount. 
	 * For example: curveScores([45, 85, 90]) would return [55, 95, 100].
	 * 
	 * @param curve An integer array of at least one, that contains numbers ranging
	 *              from 0-100.
	 * @return Returns a new integer array of numbers changed so that the highest
	 *         number in the parameter array becomes 100 and all the other numbers
	 *         are moved up by the same amount. The ordering should remain the same
	 *         between the input and output array.
	 */
	public static int[] curveScores(int[] curve) {
		int max = curve[0];
		int scoreCurve = 0;

		for (int index = 0; index < curve.length; index++) {
			if (curve[index] > max)
				max = curve[index];
		}

		for (int index = 0; index < curve.length; index++) {
			scoreCurve = 100 - max;
			curve[index] += scoreCurve;
		}
		return curve;
	}

	/**
	 * This method takes a double array and finds the smallest positive double.
	 * Finds numbers that are greater than zero, then runs another loops and
	 * compares that number to the other positive numbers. 
	 * For example: findSmallestPositiveNumber([2.0, -4.0, 5.0]) should return 2.0.
	 * 
	 * @param doubleArray A double array of elements with at least one positive
	 *                    double.
	 * @return Returns the smallest double value that is greater than 0.0
	 */
	public static double findSmallestPositiveNumber(double[] doubleArray) {
		double smallest = 0.0;

		for (int index = 0; index < doubleArray.length; index++) {
			if (doubleArray[index] > 0.0)
				smallest = doubleArray[index];
		}

		for (int index = 0; index < doubleArray.length; index++) {
			if (smallest > doubleArray[index] && doubleArray[index] > 0.0)
				smallest = doubleArray[index];
		}
		return smallest;
	}

	/**
	 * This method takes an image and compares the rgb components with a color
	 * parameter. Color match is done with .equals() method. 
	 * For example: a 1 pixel picture with a color of (100, 200, 50) and a color 
	 * to search for of (100, 100, 100), this method would return false.
	 *
	 * @param picture A picture object with at least 1x1 pixels
	 * @param rgb     A color object
	 * @return Returns a boolean value. True if the color parameter matches the
	 *         pixel image and false otherwise.
	 */
	public static boolean containsThisColor(Picture picture, Color rgb) {
		Color picColor = picture.get(0, 0);
		int red = picColor.getRed();
		int green = picColor.getGreen();
		int blue = picColor.getBlue();
		Color newColor = new Color(red, green, blue);

		if (newColor.equals(rgb))
			return true;
		else
			return false;
	}

	/**
	 * This method takes an image and creates a grey scale. It takes the average of
	 * the red, green, and blue components. 
	 * For example: A single pixel image with a color (100, 200, 50) would have a grey 
	 * intensity of (100+200+50)/3, which = 116. The new image would be a single pixel 
	 * with the same color (116, 116, 116).
	 * 
	 * @param greyPicture A picture object, which is the source image.
	 * @return Returns a new picture object that has been grey scaled.
	 */
	public static Picture makeGrey(Picture greyPicture) {
		int width = greyPicture.width();
		int height = greyPicture.height();

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				Color color = greyPicture.get(col, row);
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				int newColor = (red + green + blue) / 3;
				int grey = newColor;
				Color makeGrey = new Color(grey, grey, grey);
				greyPicture.set(col, row, makeGrey);
			}
		}
		return greyPicture;
	}

	/**
	 * This method takes an image and creates a photo-negative style. You would take
	 * each red, green, and blue value in the source and subtract it from 255. Each
	 * value will be returned. 
	 * For example: A single pixel image with a color (100, 200, 50) would make a new image 
	 * with a single pixel with color (155, 55, 205)
	 * 
	 * @param negative A picture object, that is the source image
	 * @return Returns a new picture object that has been changed to a
	 *         photo-negative style.
	 */
	public static Picture makeNegative(Picture negative) {
		int width = negative.width();
		int height = negative.height();

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				Color color = negative.get(col, row);
				int red = (255 - color.getRed());
				int green = (255 - color.getGreen());
				int blue = (255 - color.getBlue());
				Color negativeColor = new Color(red, green, blue);
				negative.set(col, row, negativeColor);
			}
		}
		return negative;
	}

	/**
	 * This method returns a the same value, unless it's less than zero or greater
	 * than 255. If less than 0, it will return 0 and if greater than 255, it will
	 * return 255. 
	 * For example: If the parameter is 100, then it will return 0. If the parameter is 
	 * 300, it will return 255. If the parameter is -10, it will return 0.
	 * 
	 * @param rgb A single int value that represents a red, green, or blue value.
	 * @return Returns the same value, except that it is 0 if the original value is
	 *         0 and is 255 if the original value is greater than 255.
	 */
	public static int safeColor(int rgb) {

		if (rgb < 0)
			rgb = 0;
		if (rgb > 255)
			rgb = 255;
		if (rgb >= 0 || rgb <= 255) {
			return rgb;
		}
		return rgb;
	}

	/**
	 * This method returns a picture that has been brightened. The values in picture
	 * will be doubled, but if values are greater than 255, then the safeColor()
	 * method will be applied. 
	 * For example: A single pixel image with a color (100, 200, 50) would make a new image 
	 * with a single pixel with color (200, 255, 100).
	 * 
	 * @param bright A picture, that is the source image
	 * @return Returns a picture object with the values doubled.
	 */
	public static Picture makeBrighter(Picture bright) {
		int width = bright.width();
		int height = bright.height();

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				Color color = bright.get(col, row);
				int red = (2 * color.getRed());
				int green = (2 * color.getGreen());
				int blue = (2 * color.getBlue());
				red = safeColor(red);
				green = safeColor(green);
				blue = safeColor(blue);
				Color brighter = new Color(red, green, blue);
				bright.set(col, row, brighter);
			}
		}
		return bright;
	}

	/**
	 * Main method with testings and method calls
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// variables for array methods
		String[] list = { "batman", "joker", "bane", "catwoman" };
		String[] emptyString = {};
		int[] array = { 12, 3, -7 };
		int[] array2 = { 1, -2, 4 };
		int[] curve = { 45, 85, 90 };
		double[] doubleArray = { 2.0, -4.0, 1.5, 5.0 };

		// variables for picture methods
		Picture picture = new Picture("Arches.jpg");
		Picture greyPicture = new Picture(picture);
		Picture negative = new Picture(picture);
		Picture bright = new Picture(picture);
		Color color = picture.get(0, 0);
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		Color rgb = new Color(red, green, blue);
		Color rgbFalse = new Color(100, 100, 100);
		int safeUnder0 = -10;
		int safe = 100;
		int safeOver255 = 300;

		// calling picture methods
		makeGrey(greyPicture);
		makeNegative(negative);
		makeBrighter(bright);

		// getting colors after call
		Color greyColor = greyPicture.get(10, 20);
		Color negativeColor = negative.get(10, 20);
		Color brightColor = bright.get(10, 20);

		// showing picture methods
		picture.show();
		bright.show();
		negative.show();
		greyPicture.show();

		// testing code and printing
		System.out.println("============");
		System.out.println("Testing Code");
		System.out.println("============");
		System.out.println("1. List tested: " + Arrays.toString(list));
		System.out.println("Lowest alphabetically in list: " + lowestAlphabetically(list));
		System.out.println("Special case for empty string: " + lowestAlphabetically(emptyString));
		System.out.println();
		System.out.println("2. Arrays tested: " + Arrays.toString(array) + " , " + Arrays.toString(array2));
		System.out.println("Smallest number in two arrays: " + findSmallestNumberInTwoArrays(array, array2));
		System.out.println();
		System.out.println("3. Score before curve: " + Arrays.toString(curve));
		curveScores(curve); // calling curve method
		System.out.println("Score after curve: " + Arrays.toString(curve));
		System.out.println();
		System.out.println("4. Array tested: " + Arrays.toString(doubleArray));
		System.out.println("Smallest positive number in array: " + findSmallestPositiveNumber(doubleArray));
		System.out.println();
		System.out.println("5. Original picture rgb components: " + "(" + color.getRed() + ", " + color.getGreen()
				+ ", " + color.getBlue() + ")");
		System.out.println("Picture contains (87, 162, 243) 'true' case: " + containsThisColor(picture, rgb));
		System.out.println("Picture contains (100, 100, 100) 'false' case: " + containsThisColor(picture, rgbFalse));
		System.out.println();
		System.out.println("NOTE: Pictures are opened in separate windows");
		System.out.println();
		System.out.println("***Original picture rgb components: " + "(" + color.getRed() + ", " + color.getGreen()
				+ ", " + color.getBlue() + ")***");
		System.out.println();
		System.out.println("6. Grey picture rgb components: " + "(" + greyColor.getRed() + ", " + greyColor.getGreen()
				+ ", " + greyColor.getBlue() + ")");
		System.out.println();
		System.out.println("7. Negative picture rgb components: " + "(" + negativeColor.getRed() + ", "
				+ negativeColor.getGreen() + ", " + negativeColor.getBlue() + ")");
		System.out.println();
		System.out.println("8. Safe method with -10 color: " + safeColor(safeUnder0));
		System.out.println("Safe method with 100 color: " + safeColor(safe));
		System.out.println("Safe method with 300 color: " + safeColor(safeOver255));
		System.out.println();
		System.out.println("9. Brighter picture rgb components: " + "(" + brightColor.getRed() + ", "
				+ brightColor.getGreen() + ", " + brightColor.getBlue() + ")");
	}

}
