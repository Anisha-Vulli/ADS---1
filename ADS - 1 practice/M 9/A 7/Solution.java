import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Main function.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(stars(input));
	}

	/**
	 * Stars appending in between the letters.
	 * The function operates throughout the length of the string if the
	 * same letters are found at the end of the string.
	 * Time complexity of this O(N).
	 *
	 * @param      str   The string
	 *
	 * @return     { String after appending stars }
	 */
	public static String stars(String str) {
		if (str.length() == 0 || str.length() == 1) {
			return str;
		}

		if (str.charAt(0) == str.charAt(1)) {
			return str.charAt(0) + "*" + stars(str.substring(1, str.length()));
		}
		return str.charAt(0) + stars(str.substring(1, str.length()));
	}
}