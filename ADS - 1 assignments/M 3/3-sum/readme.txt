input:
first line of input is int N represent no of elements in given array
Below N line represents each element in the array

output:
print 3-sum value of the array 

**
 * to import scanner class
 */
import java.util.Scanner;
/**
 * { item_description }
 */
import java.util.Arrays;
class Solution{
Solution() {

}
public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  int size = s.nextInt();
int arr[] = new int[size];
for(int i= 0; i<arr.length; i++) {
  arr[i] = s.nextInt();
}
int cnt =0;
Arrays.sort(arr);
  for(int i = 0; i < arr.length; i++) {
    for (int j = i+1; j < arr.length; j++) {
      int a = -1 * (arr[i] + arr[j]);
      int z = binarySearch(arr, j+1, arr.length-1, a);
      if (z != -1) {
        cnt++;  
    }
    }
}
System.out.println(cnt);
}
static int binarySearch(int arr[], int startIndex, int endIndex, int x) 
{ 
   if (endIndex >= startIndex) 
   {
        int mid = startIndex + (endIndex - startIndex)/2;
        if (arr[mid] == x)   
            return arr[mid];
        if (arr[mid] > x)  
            return binarySearch(arr, startIndex, mid-1, x);  
        return binarySearch(arr, mid+1, endIndex, x); 
   } 
  return -1; 
}
}
