/**
 * Scanner import.
 */
import java.util.Scanner;
/**
 * Class for taxicab.
 */
class Taxicab implements Comparable<Taxicab> {
  /**
   * Two integers for  cubing numbers.
   */
  private int i, j;
  /**
   * Sum of cubes.
   */
  private long sum;
  /**
   * Gets i.
   *
   * @return     I.
   */
  public int getI() {
    return i;
  }
  /**
   * Gets the j.
   *
   * @return     The j.
   */
  public int getJ() {
    return j;
  }
  /**
   * Gets the sum.
   *
   * @return     The sum.
   */
  public long getSum() {
    return sum;
  }
  /**
   * Constructs the object.
   *
   * @param      i1     { parameter_description }
   * @param      j1     { parameter_description }
   */
  Taxicab(final int i1, final int j1) {
        this.sum = (long) i1 * i1 * i1 + (long) j1 * j1 * j1;
        this.i = i1;
        this.j = j1;
    }
    /**
     * Compares the taxicab number to the min number.
     * Complexity of compareTo is 1.
     * Returns the int value based on the comparision.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Taxicab that) {
        if (this.sum < that.sum) {
          return -1;
        } else if (this.sum > that.sum) {
          return 1;
        } 
        return  0;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return i + "^3 + " + j + "^3";
    }
}

/**
 * Class for solution.
 */
final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {
    //Empty constructor.
  }
  /**
   * Main function.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
        String[] input = sc.nextLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        final int n = 1000;
        MinPQ<Taxicab> pq = new MinPQ<Taxicab>();
        for (int i = 1; i <= n; i++) {
            pq.insert(new Taxicab(i, i));
        }
        int pair = 1;
        Taxicab previous = new Taxicab(0, 0);
        int count = 0;
        while (!pq.isEmpty()) {
            Taxicab current = pq.delMin();
            if (previous.getSum() == current.getSum()) {
                pair++;
                if (pair == m) {
                    count++;
                }

                if (count == num) {
                    System.out.println(previous.getSum());
                    break;
                }
            } else {
                pair = 1;
            }

            previous = current;
            if (current.getJ() < n) {
                pq.insert(new Taxicab(current.getI(), current.getJ() + 1));
            }
        }
    }
}

}

