import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(stars(input));
	}

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