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
                int z = Binarysearch(array, a, j + 1, array.length - 1);
                if (z != -1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public int Binarysearch(int[] arraysent, int number, int start, int end) {
        int tempvar = 0;
        int value = 0;
        for (int j = 0; j < arraysent.length; j++) {
            tempvar = (start + end)/2;
            if (arraysent[tempvar] == number) {
                value = arraysent[tempvar];
                break;
            } else {
                if (arraysent[tempvar] > number) {
                    end = tempvar;
                } else {
                    start = tempvar;
                }
            }
        }
        return value;
    }
}