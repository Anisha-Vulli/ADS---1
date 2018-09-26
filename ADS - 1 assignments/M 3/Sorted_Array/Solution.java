import java.util.Scanner;
import java.util.Arrays;
class Solution {
    Solution() {

    }

    public static void mergeArrays(int[] arr1, int[] arr2, int n1, 
                                int n2, int[] arr3) 
    { 
        int i = 0, j = 0, k = 0; 
      
        // Traverse both array 
        while (i<n1 && j <n2) 
        { 
            // Check if current element of first 
            // array is smaller than current element 
            // of second array. If yes, store first 
            // array element and increment first array 
            // index. Otherwise do same with second array 
            if (arr1[i] < arr2[j]) 
                arr3[k++] = arr1[i++]; 
            else
                arr3[k++] = arr2[j++]; 
        } 
      
        // Store remaining elements of first array 
        while (i < n1) 
            arr3[k++] = arr1[i++]; 
      
        // Store remaining elements of second array 
        while (j < n2) 
            arr3[k++] = arr2[j++]; 
    } 
      
    public static void main(String[] args) {
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

        int[] arr3 = new int[m+n];
        mergeArrays(intarr1, intarr2, m, n, arr3);
        int a;
        for (a = 0; a < (m + n) - 1; a++) {
            System.out.print(arr3[a] + ","); 
        } 
        System.out.print(arr3[a]);
    }
}