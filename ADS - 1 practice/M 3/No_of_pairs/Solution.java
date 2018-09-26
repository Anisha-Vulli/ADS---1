import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array size");
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		int count = 1;
		int sum = 0;
		for (int j = 0; j < n-1; j++) {
			if (j == n - 2 && array[j] == array[j + 1]) {
				count++;
				sum += count * (count - 1) / 2;
				count = 1;
				break;
			} if (array[j] == array[j + 1]) {
				count++;
				continue;
			} if (count > 1 && array[j] != array[j + 1]) {
				sum += count * (count - 1) / 2;
				count = 1;
			} 			
		}
		System.out.println("No of common pairs " + sum);
	}
}