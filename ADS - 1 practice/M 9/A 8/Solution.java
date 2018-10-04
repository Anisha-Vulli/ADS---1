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
		int n = sc.nextInt();
		System.out.println(fact(n));
	}

	/**
	 * Factorial caluculation function.
	 * Here factorial is calculated in recursion so the complexity is N.
	 *
	 * @param      n     { Number sent }
	 *
	 * @return     { factorial of specified number }
	 */
	public static int fact(int n) {
		if (n == 0) {
			return 1;
		}
		return n * fact(n - 1);
	}
}