/**
 * Scanner import.
 */
import java.util.Scanner;
/**
 * Arrays import.
 */
//import java.util.Arrays;
/**
 * Class for minpq.
 *
 * @param      <Key>  The key
 */
class Minpq<Key extends Comparable<Key>> {
    /**
     * Key array pq.
     */
    private Key[] pq;
    /**
     * integer n.
     */
    private int n;
    /**
     * Constructs the object.
     */
    Minpq() {
    }
    /**
     * Constructs the object.
     *
     * @param      array  The array
     */
    Minpq(Comparable[] array) {
        this.pq = (Key[]) array;
        this.n = array.length;
    }
    /**
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    Minpq(final int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
        this.n = capacity;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }
    /**
     * Inserting a value into the array.
     *
     * @param      x     { No return }
     */
    public void insert(final Key x) {
        pq[++n] = x;
        //swim(n);
    }

    /**
     * Less function compares the two values.
     *
     * @param      i     { i value }
     * @param      j     { j value }
     *
     * @return     { int value }
     */
    public boolean less(final Key i, final Key j) {

        return i.compareTo(j) >= 0;
    }

    /**
     * Checks if the array is min array or not.
     * The complexity of loop is N/2.
     * Each child is compared the parent.
     *
     * @return     { boolean value.}
     */
    public boolean check() {
        int k = n - 1;
        //System.out.println(k);
        while (k > 0) {
            //System.out.println(pq[k]);
            //System.out.println(k + "," + (k - 1) / 2);
            if (!less(pq[k], pq[(k - 1) / 2])) {
                return false;
            }
            k = (k - 1) / 2;
        }
        return true;
    }

    // public int compareTo()
}

/**
 * Solution class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * String array convertion and sending to check.
     *
     * @param      sc    The screen
     */
    public static void stringArray(final Scanner sc) {
        Minpq<String> s = new Minpq<String>();
        int noOflines = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            s = new Minpq(tokens);
            System.out.println(s.check());
        }

    }
    /**
     * Integer array convertion and checking if it is min array.
     *
     * @param      sc    The screen
     */
    public static void integerArray(final Scanner sc) {
        Minpq<Integer> s = new Minpq<>();
        int noOflines = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Integer[] input = new Integer[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                input[i] = Integer.parseInt(tokens[i]);
            }
            //System.out.println(Arrays.toString(input));
            s = new Minpq(input);
            System.out.println(s.check());
        }
    }

    /**
     * Double array is converted into double and checks if it 
     * is the min array or not.
     *
     * @param      sc    The screen
     */
    public static void doubleArray(final Scanner sc) {
        Minpq<Double> s = new Minpq<>();
        int noOflines = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Double[] input = new Double[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                input[i] = Double.parseDouble(tokens[i]);
            }
            //System.out.println(Arrays.toString(input));
            s = new Minpq(input);
            System.out.println(s.check());
        }
    }

    /**
     * Float array is converted into double and checks if it 
     * is the min array or not.
     *
     * @param      sc    The screen
     */
    public static void floatArray(final Scanner sc) {
        Minpq<Float> s = new Minpq<>();
        int noOflines = Integer.parseInt(sc.nextLine());
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            if (tokens[0].equals("")) {
                System.out.println("false");
                break;
            } else {
                Float[] input = new Float[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    input[i] = Float.parseFloat(tokens[i]);
                }
                s = new Minpq(input);
                System.out.println(s.check());
            }
        }
    }
    /**
     * Main function
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        switch (type) {
            case "String":
            stringArray(sc);
            break;
            case "Integer":
            integerArray(sc);
            break;
            case "Double":
            doubleArray(sc);
            break;
            case "Float":
            floatArray(sc);
            break;
            default:
            break;
    }
}
}


