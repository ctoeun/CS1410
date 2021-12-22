package a2;

public class SmallMethods {

	/**
	 * Inputs a number and returns true or false depending if it equals zero
	 * 
	 * @param zeroValue The value used to test whether true or false
	 * @return either true or false whether the value is zero or not
	 */
	public static boolean isZero(int zeroValue) {
		if (zeroValue == 0)
			return true;
		else
			return false;
	}

	/**
	 * Calls zeroValue and returns "Zero" if the number is equal to zero and "Not Zero" otherwise
	 * 
	 * @param zeroValue Calls zeroValue and bases the test of value
	 * @return "Zero" if the number is equal to zero and "Not Zero" otherwise
	 */
	public static String describeNumber(int zeroValue) {
		if (isZero(zeroValue))
			return "Zero";
		else
			return "Not Zero";
	}

	/**
	 * Takes the value and determines whether if it is positive, negative, or zero. Greater than is positive, less than is negative, and equal to is zero.
	 * 
	 * @param stringOfNumber The value used to compare with zero
	 * @return "Zero" if the number is equal to zero, "Positive" if the number is greater than zero, and "Negative" if the number is less than zero. 
	 */
	public static String classifyNumber(int stringOfNumber) {
		String stringNumber = "";

		if (stringOfNumber > 0)
			stringNumber = "Positive";
		else if (stringOfNumber < 0)
			stringNumber = "Negative";
		else if (stringOfNumber == 0)
			stringNumber = "Zero";

		return stringNumber;
	}

	/**
	 * Uses the mod option and returns true if the parameter value is evenly divisible by 3 or by 5
	 * 
	 * @param divisibleNumber The value that will be used to determine if it can mod by 3 or 5
	 * @return If it's divisible by 3 or 5, then it returns true, otherwise false
	 */
	public static boolean isEvenlyDivisibleByThreeOrFive(int divisibleNumber) {
		if (divisibleNumber % 3 == 0 || divisibleNumber % 5 == 0)
			return true;
		else
			return false;
	}

	/**
	 * Compares two values and returns the number that is smaller than the other. If smallValue is less than smallValue2 then it returns true, if otherwise false.
	 * 
	 * @param smallValue The first value that will compare to second value
	 * @param smallValue2 The second value that will compare to the first value
	 * @return The smaller number of the two parameters
	 */
	public static double chooseSmaller(double smallValue, double smallValue2) {
		if (smallValue < smallValue2)
			return smallValue;
		else
			return smallValue2;
	}

	/**
	 *  Use parameter as starting value, then doubles the number until it's larger than 100. If less than or equal to 0, it will return zero.
	 * 
	 * @param doubledNumber The value that doubles itself every time until larger than 100
	 * @return doubledNumber once it passes 100, or outputs nothing if zero or negative
	 */
	public static int firstDoublingPastOneHundred(int doubledNumber) {
		while (doubledNumber <= 100) {
			doubledNumber *= 2;
			if (doubledNumber <= 0)
				return 0;
		}
		return doubledNumber;
	}

	/**
	 * Uses string variable and returns the first letter then skips every other letter after that. Set count to 0, then in the while loop it will add 2 to skip every other letter.
	 * 
	 * @param name String used to test
	 * @return String letters while returning every other letter
	 */
	public static String skipLetters(String name) {
		String letters = "";
		int count = 0;

		while (count < name.length()) {
			char currentCharacter = name.charAt(count);
			String characterInStringForm = Character.toString(currentCharacter);
			letters += characterInStringForm;
			count += 2;
		}
		return letters;
	}
	
	/**
	 * Produces a String that returns as a square. Loops the outer square 
	 * until it passes an inputed width size. Combines and adds square with loop line.
	 * 
	 * @param squareSize Sets the square size depending on the value
	 * @return square which is combined with line characters
	 */
	public static String makeSquare(int squareSize) {
		String square = makeLine('+', '-', squareSize) + "\n";
		int count = 0;
		
		while (count < squareSize - 2) {
			String line = makeLine('|', ' ', squareSize);
			square += line + "\n";
			count++;
		}
		square += makeLine('+', '-', squareSize) + "\n";
		return square;
	}
	
    /**
	 * Produces a String starting and ending with the edge character and having the
	 * inner char repeated in-between. The total number of characters in the string
	 * is width.
	 * 
	 * @param edge  The character used at the start and end of the returned string.
	 * @param inner The character repeated in-between the edge char.
	 * @param width The total number of characters in the returned string. Width
	 *              must be greater or equal to 2.
	 * @return A string with width characters.
	 */
	public static String makeLine(char edge, char inner, int width) {
		String line = "";
		int currentLocation = 0;
		
		while (currentLocation < width - 2) {
			line = line + inner;
			currentLocation = currentLocation + 1;
		}
		return edge + line + edge;
	}

	public static void main(String[] args) {
		
		System.out.println(isZero(0));
		System.out.println(describeNumber(0));
		System.out.println(classifyNumber(2));
		System.out.println(isEvenlyDivisibleByThreeOrFive(25));
		System.out.println(chooseSmaller(3.2, 3.3));
		System.out.println(firstDoublingPastOneHundred(5));
		System.out.println(skipLetters("David is cool"));
		System.out.println(makeSquare(4));
	}

}
