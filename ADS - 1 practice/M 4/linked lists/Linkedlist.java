class Node {
    private String data;
    Node next;
    Node(String data1) {
        data = data1;
        next = null;
    }

    // public static void main(String[] args) {
    //  Node obj1 = new Node(5);
    //  Node obj2 = new Node(6);
    //  obj1.next = obj2;
    //  System.out.println(obj1.next);
    //  System.out.println(obj1.data);
    //  System.out.println(obj2.next);
    //  System.out.println(obj2.data);
    // }
}

class Linkedlist {
    Node start;
    int n;
    Linkedlist() {
        n = 0;
    }

    void insert (String value) {
        Node obj = new Node(value);
        if (n == 0) {
            start = obj;
            n++;
            return;
        }
        Node temp = start;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = obj;
    }

    void removeAfter(String value) {
        if (start.data.equals(value)) {
            start.next = start.next.next;
            n--;
            return;
        } 
        Node temp = start;
        while (temp != null) {
            if (temp.data.equals(value)) {
                Node del = temp.next;
                delete(del, )
            }
        }
    }

    void delete(String value) {
        temp = start;
        Node previous = null;
        while (temp != null) {
            if (temp.value.equals(search)) {
                previous.next = temp.next;
                return;
            }
            previous = temp;
            temp = temp.next;
        }
    }
}