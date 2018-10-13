/**
 * Stock analysis.
 */
import java.util.Scanner;
/**
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
    /**
     * name of the stock.
     */
    private String name;
    /**
     * change in stock value.
     */
    private Double value;
    /**
     * Constructs the object.
     *
     * @param      name1    The name 1
     * @param      change1  The change 1
     */
    Stock(final String name1, final Double change1) {
        this.name = name1;
        this.value = change1;
    }
    /**
     * Gets the name of the stock.
     *
     * @return     The name.
     */
    public String getStockName() {
        return this.name;
    }
    /**
     * Gets the change in stock value.
     *
     * @return     The change.
     */
    public Double getChange() {
        return this.value;
    }
    /**
     * compares two objects.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Stock that) {
        if (this.value > that.value) {
            return 1;
        }
        if (this.value < that.value) {
            return -1;
        }
        if (this.name.compareTo(that.name) > 0) {
            return 1;
        }
        if (this.name.compareTo(that.name) < 0) {
            return -1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.name + " " + this.value;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //empty constructor.
    }
    /**
     * Main program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        BinarySearchST<String, Integer> best = new  BinarySearchST<>();
        BinarySearchST<String, Integer> worst = new BinarySearchST<>();
        final int six = 6;
        for (int i = 0; i < six; i++) {
            int count = 0;
            MinPQ<Stock> min = new MinPQ<>();
            MaxPQ<Stock> max = new MaxPQ<>();
            while (count < n) {
                String[] input = scan.nextLine().split(",");
                Stock stocks = new Stock(input[0],
                    Double.parseDouble(input[1]));
                min.insert(stocks);
                max.insert(stocks);
                count++;
            }
            BinarySearchST<Stock, Integer> bestln = new  BinarySearchST<>();
            BinarySearchST<Stock, Integer> worstln = new BinarySearchST<>();
            int a = 1;
            final int five = 5;
            for (int j = 0; j < five; j++) {
                Stock maxbest = max.delMax();
                System.out.println(maxbest);
                bestln.put(maxbest, j);
            }
            System.out.println();
            for (int k = 0; k < five; k++) {
                Stock minworst = min.delMin();
                System.out.println(minworst);
                worstln.put(minworst, k);
            }
            System.out.println();
        }
        int query = Integer.parseInt(scan.nextLine());
        if (query != 0) {
            //System.out.println(query);
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
                case "get":
                if (tokens[1].equals("maxST")) {
                    System.out.println(best.rank(tokens[2]));
                    System.out.println(best.get(tokens[2]));
                } else if (tokens[1].equals("minST")) {
                    System.out.println(worst.rank(tokens[2]));
                    System.out.println(worst.get(tokens[2]));
                }
                break;
                default:
                break;
            }
        }
    }
}


