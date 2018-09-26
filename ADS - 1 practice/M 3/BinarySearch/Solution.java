import java.util.Scanner;
import java.util.Arrays;
class Solution {
    public static int Binarysearch(int[] arr, int start, int end, int number) {
        //int mid = 0;
        //int value = 0;
        // int start = 0;
        // int end = arraysent.length;
        if (end >= start) 
        { 
            int mid = start + (end - start)/2; 
            if (arr[mid] == number) 
               return arr[mid]; 
            if (arr[mid] > number) 
               return Binarysearch(arr, start, mid-1, number); 
            return Binarysearch(arr, mid+1, end, number); 
        } 
        return -1; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size");
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Enter the required number to be found");
        int number = sc.nextInt();
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Binarysearch(array, 0, n - 1, number));
    }
}