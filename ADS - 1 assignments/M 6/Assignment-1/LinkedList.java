class Node {
    String data;
    Node next;

    Node() {

    }

    Node(String item) {
        this.data = item;
    }
}

class Linkedlists {
    Node start = new Node();
    int size;
    Linkedlists() {
        size = 0;
    }

    void push(String item) {
        Node obj = new Node();
        if (size == 0) {
            start.data = item;
            size++;
            return; 
        }

        obj.next = start;
        start = obj;
    }

    String pop() {
        String item = start.data;
        start = start.next;
        size--;
        return item;
    }

    public String toString() {
        String str = "";
        if (size == 0) {
            str = start.data;
            return str;
        } else {
            Node temp = start;
            while (temp != null) {
                str = str + temp.data;
                temp = temp.next;
            }
            return str;
        }
    }
}