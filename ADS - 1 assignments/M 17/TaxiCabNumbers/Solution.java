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
  int i,j;
  /**
   * Sum of cubes.
   */
  long sum;
  /**
   * Constructs the object.
   *
   * @param      i     { parameter_description }
   * @param      j     { parameter_description }
   */
  public Taxicab(int i, int j) {
        this.sum = (long) i*i*i + (long) j*j*j;
        this.i = i;
        this.j = j;
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
    public int compareTo(Taxicab that) {
        if (this.sum < that.sum) {
          return -1;
        } else if (this.sum > that.sum) {
          return +1;
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
class Solution {
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
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextLine()) {
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int n = 1000;
        MinPQ<Taxicab> pq = new MinPQ<Taxicab>();
        for (int i = 1; i <= n; i++) {
            pq.insert(new Taxicab(i, i));
        }
        int pair = 1;
        Taxicab previous = new Taxicab(0, 0);
        int count = 0;
        while (!pq.isEmpty()) {
            Taxicab current = pq.delMin();
            if (previous.sum == current.sum) {
                pair++;
                if (pair == M) {
                    count++;   
                }

                if (count == N) {
                    System.out.println(previous.sum);
                    break;
                }
            } else {
                pair = 1;
            }

            previous = current;
            if (current.j < n) {
                pq.insert(new Taxicab(current.i, current.j + 1));
            }
        }
    }
}

}

