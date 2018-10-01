import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node() {

    }

    Node(int data1) {
        this.data = data1;
    }
}

class Steque {
    private Node head;
    private Node tail;
    private int size;
    Steque() {
        head = new Node();
        tail = new Node();
        size = 0;
    }

    void push(int item) {
        //Node val = new Node(item);
        if (size == 0) {
            //Node val = head;
            //head = new Node();
            head.data = item;
            head.next = null;
            tail = head;
            size++;
            return;
            //System.out.println(head.next);
            //System.out.println(tail.next);
        }
        Node val = new Node();
        val.data = item;
        val.next = head;
        head = val;
        size++;
    }

    void pop() {
        size--;
        head = head.next;
        //System.out.println(size);
    }

    void enque(int item) {
        //System.out.println(size);
        if (size == 0) {
            //Node oldtail = tail;
            //tail = new Node();
            tail.data = item;
            tail.next = null;
            //System.out.println(tail.data);
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
    boolean isEmpty() {
       if (size == 0) {
           return true;
       }
       return false;
    }

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

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Steque sq = new Steque();
        while (sc.hasNext()) {
            String data = sc.nextLine();
            if (data.equals("") || data.equals(null)) {
                sq = new Steque();
                System.out.println("");
            } else {
                String[] input = data.split(" ");
            switch (input[0]) {
                case "push":
                sq.push(Integer.parseInt(input[1]));
                System.out.println(sq);
                break;
                case "pop":
                if (!sq.isEmpty()) {
                    sq.pop();
                    //System.out.println(sq);
                    if (!sq.isEmpty()) {
                        System.out.println(sq);    
                    } else {
                        System.out.println("Steque is empty.");
                    }  
                } else {
                    System.out.println("Steque is empty.");
                }
                break;
                case "enqueue":
                sq.enque(Integer.parseInt(input[1]));
                System.out.println(sq);
                break;
            }
            }
        }
    }
}