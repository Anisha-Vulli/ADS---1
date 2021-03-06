class Linkedlist {
    private Node head;
    private Node tail;
    public int size;
    
    private class Node {
        private int value;
        private Node next;
    }
     Linkedlist() {
        head = null;
        tail = null;
    }
     public void insertfront(final int value){
        if (head == null) {
            Node oldHead = head;
            head = new Node();
            head.value = value;
            head.next = null;
            tail = head;
        } else {
            Node oldHead = head;
            head = new Node();
            head.value = value;
            head.next = oldHead;
        }
        size++;
    }
    public void insertend(final int value){
        if (tail == null) {
            Node oldTail = tail;
           tail = new Node();
           tail.value = value;
           tail.next = null;
           head = tail;
        }
        else {
            Node oldTail = tail;
           tail = new Node();
           tail.value = value;
           tail.next = null;
           oldTail.next = tail;
        }
        size++;
    }
    public void deletefront(){
        if (head != null) {
            //int value = head.value;
            head = head.next;
            size--;
            //return value;
        }
    }
     public void deleteend(){
        if (tail != null) {
            Node temp = null;
            Node pop = tail;
            Node head1 = head;
            while (head1 != tail){
                temp = head1;
                head1 = head1.next;
            } 
            //int item = temp.next.value;
            tail = temp;
            tail.next = null;
            size--;
            //return item; 
        }
    }
    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        return size;
    }
     public String toString() {
        if (size != 0) {
            String str = "[";
            Node temp = head;
            while (temp != null) {
                str += temp.value + ", ";
                // System.out.println(str);
                temp = temp.next;
            }
            return str.substring(0, str.length() - 2) + "]";
        }
        return "[]";
    }
}
 class Queue {
    Linkedlist ll;
    int size;
     Queue() {
        ll = new Linkedlist();
    }
     void addfront(int number) {
        ll.insertfront(number);
    }
     void addend(int number) {
        ll.insertend(number);
    }
     void removefront() {
        ll.deletefront();
    }
     void removeend() {
        ll.deleteend();
    }
     int size() {
        return ll.size();
    }
     String print() {
        return ll.toString();
    }
     boolean isEmpty() {
        return ll.isEmpty();
    }
}