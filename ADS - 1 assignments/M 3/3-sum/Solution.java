import java.util.Scanner;
import java.util.Arrays;
class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        threeSum t = new threeSum();
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        t.threeSumpairs(arr);
        //System.out.println(t.Binarysearch(arr, 686904));
        // System.out.println(Arrays.toString(arr));
    }
}

class threeSum {
    int count;
    threeSum() {
        count = 0;
    }
    public void threeSumpairs(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int a = -1 * (array[i] + array[j]);
                int z = binarysearch(array, j + 1, array.length - 1, a);
                if (z != -1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public int binarysearch(final int[] arr,
        final int start, final int end, final int number) {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == number) {
               return mid;
            }
            if (arr[mid] > number) {
               return binarysearch(arr, start, mid - 1, number);
            }
            return binarysearch(arr, mid + 1, end, number);
        }
        return -1;
    }
}