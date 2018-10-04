class Node {
    String data;
    Node next;

    Node() {

    }

    Node (String data) {
        this.data = data;
    }
}
class Linkedlist {
    Node head;
    //Node tail;
    int size;
    Linkedlist() {
        head = null;
        //tail = new Node();
        size = 0;
    }

    void insertAt(int pos, String data) throws Exception{
        //System.out.println("Pakodi");
        Node newNode = new Node(data);
        //System.out.println(newNode.data);
        if (pos < 0 || pos > size) {
            throw new Exception("Can't insert at this position.");
        }
        head = insertAt(pos, head, newNode, 0);
            //System.out.println(head.data);
    }

    Node insertAt(int pos, Node first, Node obj, int count) {
        if (pos == count) {
            obj.next = first;
            size++;
            return obj;
        }
        first.next = insertAt(pos, first.next, obj, ++count);
        return first;
    }

    void reverse() throws Exception{
        if (size == 0) {
            throw new Exception("No elements to reverse.");
        }
        reverse(null, head);
    }

    void reverse(Node previous, Node current) {
        if (current != null) {
            reverse(current, current.next);
            current.next = previous;
        } else {
            head = previous;
        }
    }

    public String toString() {
        //System.out.println(size);
        if (size != 0) {
            String str = "";
            Node temp = head;
            while (temp != null) {
                str += temp.data + ", ";
                // System.out.println(str);
                temp = temp.next;
            }
            return str.substring(0, str.length() - 2);
        }
        return "[]";
    }
}
