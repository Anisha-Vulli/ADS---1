/**
 * Class for node.
 */
class Node {
    /**
     * Data is a integer type.
     */
    int data;
    /**
     * Next is a node type.
     */
    Node next;
    /**
     * Constructs the object.
     */
    Node() {

    }
    /**
     * Constructs the object.
     *
     * @param      data1  The data 1
     */
    Node(int data1) {
        this.data = data1;
    }
}
/**
 * Class for steque.
 */
class Steque {
    /**
     * Head node.
     */
    private Node head;
    /**
     * Tail node.
     */
    private Node tail;
    /**
     * Size integer to record the size of the stequeue.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Steque() {
        head = new Node();
        tail = new Node();
        size = 0;
    }
    /**
     * Push method adds values infront of the added value.
     * The time complexity is 1.
     * When size is 0 both tail and head points to same node.
     * Size increases for every iteration.
     *
     * @param      item  The item
     */
    void push(int item) {
        if (size == 0) {
            head.data = item;
            head.next = null;
            tail = head;
            size++;
            return;
        }
        Node val = new Node();
        val.data = item;
        val.next = head;
        head = val;
        size++;
    }

    /**
     * Pop function popps the value from the front of the stack.
     * Time complexity is 1.
     */
    void pop() {
        size--;
        head = head.next;
        //System.out.println(size);
    }
    /**
     * Enqueue is a function in which the value adds at the end of the stack.
     * Time complexity is 1.
     * When size is 0 both tail and head points to same node.
     * For every iteration size increases.
     *
     * @param      item  The item
     */
    void enque(int item) {
        if (size == 0) {
            tail.data = item;
            tail.next = null;
            head = tail;
            size++;
            return;
        } else {
           Node oldTail = new Node();
           oldTail.data = item;
           oldTail.next = null;
           tail.next = oldTail;
           tail = oldTail;
           //System.out.println(tail.data);
        }
        size++;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
       if (size == 0) {
           return true;
       }
       return false;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        //System.out.println("Size" + size);
        if (size != 0) {
            String str = "";
            Node temp = head;
            while (temp != null) {
                str += temp.data + ", ";
                // System.out.println(str);
                temp = temp.next;
            }
            //return str;
            return str.substring(0, str.length() - 2);
        }
        return "[]";
    }
        
}