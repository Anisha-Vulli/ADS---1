import java.util.Scanner;
//import java.util.Arrays;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Merging arrays.
     *
     * @param      arr1  The arr 1
     * @param      arr2  The arr 2
     * @param      n1    The n 1
     * @param      n2    The n 2
     * @param      arr3  The arr 3
     */
    public static void mergearrays(final int[] arr1, final int[] arr2,
        final int n1, final int n2, final int[] arr3) {
        int i = 0, j = 0, k = 0;

        // Traverse both array
        while (i < n1 && j < n2) {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }
        // Store remaining elements of first array
        while (i < n1) {
            arr3[k++] = arr1[i++];
        }
        // Store remaining elements of second array
        while (j < n2) {
            arr3[k++] = arr2[j++];
        }
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        String[] strarr1 = sc.nextLine().split(",");
        String[] strarr2 = sc.nextLine().split(",");
        int[] intarr1 = new int[m];
        int[] intarr2 = new int[n];
        for (int i = 0; i < m; i++) {
            intarr1[i] = Integer.parseInt(strarr1[i]);
        }

        for (int j = 0; j < n; j++) {
            intarr2[j] = Integer.parseInt(strarr2[j]);
        }

        int[] result = new int[m + n];
        mergearrays(intarr1, intarr2, m, n, result);
        int a;
        for (a = 0; a < (m + n) - 1; a++) {
            System.out.print(result[a] + ",");
        }
        System.out.print(result[a]);
    }
}