import java.util.Scanner;
//import java.util.Arrays;

/**
 * Class for Solution.
 */
final public class Solution {
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            Queue q = new Queue();
            String str = "";
            for (int i = 0; i < m; i++) {
                q.enqueue(i);
            }

            while (!q.isEmpty()) {
                for (int k = 0; k < n - 1; k++) {
                    q.enqueue(q.dequeue());
                }
                str += q.dequeue() + " ";
            }
            System.out.println(str.substring(0, str.length() - 1));
        }
    }
}