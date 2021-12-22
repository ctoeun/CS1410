package a6;

/**
 * A DynamicArray2 behaves like an array of strings, except that it can grow and
 * shrink. It is indexed beginning with zero. When a DynamicArray2 is created,
 * it is empty. Methods are provided to report on the size, add, get, set, and
 * remove elements.
 * 
 * DynamicArray2 is implemented into a more efficient way than dynamic array
 * presented in lecture 21.
 * 
 * @author Prof. David E. Johnson
 * @author Cobi Toeun
 *
 */
public class DynamicArray2 {

	private String[] data; // the backing array
	private int virtualArrayLength; // the number of elements in the dynamic array

	/**
	 * Creates an empty dynamic array with room to grow.
	 */
	public DynamicArray2() {
		data = new String[8];
		virtualArrayLength = 0;
	}

	/**
	 * Returns the number of elements in the dynamic array.
	 * 
	 * @return the number of elements
	 */
	public int size() {
		return virtualArrayLength;
	}

	/**
	 * Appends s to the end of the dynamic array at index this.size().
	 * 
	 * @param s The string being created
	 */
	public void add(String s) {
		add(virtualArrayLength, s);
	}

	/**
	 * Throws an IndexOutOfBoundsException if index is not a valid index for adding
	 * to the dynamic array, otherwise inserts s at index. Elements can be added
	 * from index 0 up to and including this.size().
	 * 
	 * @param index The int index added to the string s
	 * @param s     The string being created
	 */
	public void add(int index, String s) {
		if (index < 0 || index > data.length) {
			throw new IndexOutOfBoundsException();
		}

		if (virtualArrayLength == data.length) {
			String[] newData = new String[data.length * 2];

			for (int index2 = 0; index2 < index; index2++) {
				newData[index2] = data[index2];
			}

			newData[index] = s;

			for (int shiftIndex = index + 1; shiftIndex < virtualArrayLength; shiftIndex++) {
				newData[shiftIndex] = data[shiftIndex - 1];
			}

			virtualArrayLength++;
			data = newData;
		}

		else {
			
			virtualArrayLength++;
			data[index] = s;
		}
	}

	/**
	 * Throws an IndexOutOfBoundsException if index is not a valid index of the
	 * dynamic array, otherwise removes the element at index and shifts the elements
	 * after index down one to fill in the gap.
	 * 
	 * @param index The int index being removed
	 */
	public void remove(int index) {
		if (index < 0 || index > data.length) {
			throw new IndexOutOfBoundsException();
		}

		else {
			for (int shiftIndex = index; shiftIndex < virtualArrayLength - 1; shiftIndex++) {
				data[shiftIndex] = data[shiftIndex + 1];
			}

			virtualArrayLength--;
		}
	}

	/**
	 * Throws an IndexOutOfBoundsException if index is not a valid index of the
	 * dynamic array, otherwise returns the element at index.
	 * 
	 * @param index The int at a certain index being get
	 * @return the string at the index
	 */
	public String get(int index) {
		if (index < 0 || index > data.length) {
			throw new IndexOutOfBoundsException();
		}

		return data[index];
	}

	/**
	 * Throws an IndexOutOfBoundsException if index is not a valid index of the
	 * dynamic array, otherwise replaces the element at index with s
	 * 
	 * @param index The int index being set to a certain string/value
	 * @param s     The string s replacing at a certain index
	 */
	public void set(int index, String s) {
		if (index < 0 || index > data.length) {
			throw new IndexOutOfBoundsException();
		}

		data[index] = s;
	}

	/**
	 * Returns a formatted string version of this dynamic array.
	 * 
	 * @return the formatted string
	 */
	public String toString() {
		String result = "[";
		if (size() > 0)
			result += get(0);

		for (int index = 1; index < size(); index++)
			result += ", " + get(index);

		return result + "] backing size: " + data.length;
	}

	/**
	 * Testing code in main method to check the class is working as expected. Added
	 * items at the end and places in the middle, removed some items, and printed
	 * out the array after each change.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// testing the methods here
		DynamicArray2 d = new DynamicArray2();
		DynamicArray2 e = new DynamicArray2();
		System.out.println("======================");
		System.out.println("Testing Dynamic Array:");
		System.out.println("======================");
		d.add("cat");
		d.add("dogs");
		d.add("2");
		d.add("1");
		System.out.println(d);
		System.out.println(d.get(0));
		d.remove(0);
		System.out.println(d);
		d.set(1, "hamster");
		d.set(2, "frog");
		d.add("2");
		System.out.println(d);
		System.out.println(d.get(1));
		System.out.println(d.get(2));
		d.remove(0);
		d.remove(1);
		d.remove(2);
		d.remove(3);
		System.out.println(d);
		System.out.println();
		System.out.println("================================================");
		System.out.println("Testing to see if backing array doubles in size:");
		System.out.println("================================================");
		e.add("1");
		e.add("2");
		e.add("3");
		e.add("4");
		e.add("5");
		e.add("6");
		e.add("7");
		e.add("8");
		System.out.println(e);
		e.add("9");
		System.out.println(e);

	}
}
