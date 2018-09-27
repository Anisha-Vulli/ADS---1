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
