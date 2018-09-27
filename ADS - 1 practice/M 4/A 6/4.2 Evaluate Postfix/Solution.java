/**
 * { Importing Scannner }.
 */
import java.util.Scanner;
/**
 * { Importing Arrays }.
 */
import java.util.Arrays;
/**
 * Class for node.
 */
class Node {
    /**
     * Data in string.
     */
    int data;
    /**
     * Next node.
     */
    Node next;
}

/**
 * Class for linkedlist.
 */
class Linkedlist {
    /**
     * An empty node.
     */
    private Node start = new Node();
    /**
     * Pushing an element into list.
     *
     * @param      value  The value
     */
    void push(final int value) {
        Node val = start;
        start = new Node();
        start.data = value;
        start.next = val;
    }
    /**
     * Popping element from list.
     *
     * @return     { int value }
     */
    int pop() {
        int c = start.data;
        start = start.next;
        return c;
    }
    /**
     * First value.
     *
     * @return     { value }
     */
    public boolean isEmpty() {
        return (start.next == null);
    }
}

class Solution {
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

