/**
 * { Importing Scannner }.
 */
import java.util.Scanner;
/**
 * { Importing Arrays }.
 */
import java.util.Arrays;
/**
 * Class for solution.
 */
public final class Solution {
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
        Linkedlist ll = new Linkedlist();
        int popelement1 = 0;
        int popelement2 = 0;
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < input.length; i++) {
           if (!(Arrays.asList("+", "-", "*", "/").contains(input[i]))) {
                ll.push(Integer.parseInt(input[i]));
            } else {
                popelement1 = ll.pop();
                popelement2 = ll.pop();
                if (input[i].equals("+")) {
                    ll.push(popelement1 + popelement2);
                } else if (input[i].equals("-")) {
                    ll.push(popelement1 - popelement2);
                } else if (input[i].equals("*")) {
                    ll.push(popelement1 * popelement2);
                } else {
                    ll.push(popelement1 / popelement2);
                }
            }
        }
        System.out.println(ll.pop());
    }
}

