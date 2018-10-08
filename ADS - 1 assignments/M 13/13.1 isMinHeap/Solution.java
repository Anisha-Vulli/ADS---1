import java.util.Scanner;
import java.util.Arrays;
class Minpq<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;

    public Minpq() {
        
    }

    public Minpq(Comparable[] array) {
        this.pq = (Key[]) array;
        this.n = array.length;
    }
    
    public Minpq(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
        this.n = capacity;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Key x) {
        pq[++n] = x;
        //swim(n);
    }

    public boolean less(Key i, Key j) {

        return i.compareTo(j) >= 0;
    }


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
final class Solution {
    Solution() {
        //Empty constructor.
    }
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
    public static void floatArray(final Scanner sc) {
        Minpq<Float> s = new Minpq<>();
        int noOflines = Integer.parseInt(sc.nextLine());
        // outerloop:
        while (sc.hasNextLine()) {
            // System.out.println("entered");
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
                //System.out.println(Arrays.toString(input));
                s = new Minpq(input);
                System.out.println(s.check());
            }
        }
        // System.out.println("entered");
    }
    public static void main(String[] args) {
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