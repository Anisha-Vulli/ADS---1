import java.util.Scanner;
/**
 * Class for merge.
 */
class Merge {
 /**
 * cutoff to insertion sort.
 */
 private final int x = 7;
 /**
 * Constructs the object.
 * Time complexity of this method is O(1).
 */
 Merge() {
 //Unused Constructor.
 }
 /**
 * {Method to merge two arrays}.
 * Time complexity of this method is O(N).
 * @param array The array
 * @param aux The auxiliary
 * @param lo The lower value
 * @param mid The middle value
 * @param hi The higher value
 */
 public void merge(final Comparable[] array, final Comparable[] aux,
 final int lo, final int mid, final int hi) {
 assert isSorted(array, lo, mid);
 assert isSorted(array, mid + 1, hi);
 int i = lo;
 int j = mid + 1;
 for (int k = lo; k <= hi; k++) {
 if (i > mid) {
 aux[k] = array[j++];
 } else if (j > hi) {
 aux[k] = array[i++];
 } else if (less(array[j], array[i])) {
 aux[k] = array[j++];
 } else {
 aux[k] = array[i++];
 }
 }
 assert isSorted(aux, lo, hi);
 }
 /**
 * {Method for sorting}.
 * Time complexity of sorting is O(log(N)).
 * @param array The array
 * @param aux The auxiliary array
 * @param lo The lower value
 * @param hi The higher value
 */
 public void sort(final Comparable[] array, final Comparable[] aux,
 final int lo, final int hi) {
 if (hi <= lo + x) {
 insertionSort(aux, lo, hi);
 System.out.println("Insertion sort method invoked...");
 return;
 }
 int mid = lo + (hi - lo) / 2;
 sort(aux, array, lo, mid);
 sort(aux, array, mid + 1, hi);
 if (!less(array[mid + 1], array[mid])) {
 for (int i = lo; i <= hi; i++) {
 aux[i] = array[i];
 }
 System.out.println(
 "Array is already sorted. So, skipped the call to merge...");
 return;
 }
 merge(array, aux, lo, mid, hi);
 }
 /**
 * Rearranges the array in ascending order, using the natural order.
 * Time complexity of this method is O(N).
 * @param a {Comparable array}.
 */
 public void sort(final Comparable[] a) {
 Comparable[] aux = a.clone();
 sort(aux, a, 0, a.length - 1);
 assert isSorted(a);
 }
 /**
 * {Method for insertion sort}.
 * sort from a[lo] to a[hi].
 * Time complexity of insertion sort is O(N^2/2).
 * @param a {Comparable array}.
 * @param lo The lower value
 * @param hi The higher value
 */
 public void insertionSort(final Comparable[] a,
 final int lo, final int hi) {
 for (int i = lo; i <= hi; i++) {
 for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
 exch(a, j, j - 1);
 }
 }
 }
 /**
 * {Method to exchange two elements in the array}.
 * Time complexity of this method is O(N).
 * @param a {Array of object}
 * @param i {Integer i}
 * @param j {Integer j}
 */
 public void exch(final Comparable[] a,
 final int i, final int j) {
 Comparable swap = a[i];
 a[i] = a[j];
 a[j] = swap;
 }
 /**
 * {Method to check which one is smaller of the two}.