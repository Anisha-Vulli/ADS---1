import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 0;
		int[] array = new int[n];
		while(sc.hasNext()){
			array[i] = sc.nextInt();
			i++;
		}
		System.out.println(Arrays.toString(array));
	}
}