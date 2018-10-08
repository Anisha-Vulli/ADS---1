import java.util.Scanner;

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

    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    public boolean check() {
        int k = n - 1;
        while (k > 0) {
            if (!less(k, (k - 1) / 2)) {
                return false;
            }
            k--;
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
            s = new Minpq(tokens);
            System.out.println(s.check());
        }

    //     for (int i = 0; i < tokens.length; i++) {
    //         s.insert(Integer.parseInt(tokens[i]));
    //     }
     }
    // public static void doubleArray(final Scanner sc) {
    //     Minpq<Double> s = new Minpq<>();
    //     while (sc.hasNext()) {
    //         int noOflines = Integer.parseInt(sc.nextLine());
    //         for (int i = 0; i < noOflines; i++) {
    //             String line = sc.nextLine();
    //             String[] tokens = line.split(",");
    //         }
    //     }

    //     for (int i = 0; i < tokens.length; i++) {
    //         s.insert(Double.parseDouble(tokens[i]));
    //     }
    // }
    // public static void floatArray(final Scanner sc) {
    //     Minpq<Float> s;
    //     while (sc.hasNext()) {
    //         int noOflines = Integer.parseInt(sc.nextLine());
    //         for (int i = 0; i < noOflines; i++) {
    //             String line = sc.nextLine();
    //             String[] tokens = line.split(",");
    //         }
    //     }

    //     for (int i = 0; i < tokens.length; i++) {
    //         s.insert(Float.parseFLoat(tokens[i]));
    //     }
    // }
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
            // case "Double":
            // doubleArray(sc);
            // break;
            // case "Float":
            // floatArray(sc);
            // break;
            default:
            break;
    }
}
}