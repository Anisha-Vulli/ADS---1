import java.util.Scanner;

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
        
        // if (pos == 0) {
        //     //newNode.data = data;
        //     newNode.next = head;
        //     head = newNode;
        //     size++;
        //     return;
        // }
        // 
        // if (size++ == 0) {
        //     head.data = data;
        //     return;
        // }

        // Node previous = null;
        // Node temp = head;
        // int count = 0;
        // while (temp != null) {
        //     if (count == pos) {
        //         previous.next = newNode;
        //         newNode.next = temp;
        //         size++;
        //         return;
        //     }
        //     previous = temp;
        //     temp = temp.next;
        //     count++;
        // }
        
        Node newNode = new Node(data);
        if (pos < 0 || pos > size) {
            throw new Exception("Can't insert at this position.");
        }
        head = insertAt(pos, head, newNode, 0);   
    }

    Node insertAt(int pos, Node first, Node obj, int count) {
        if (pos == count) {
            obj.next = first;
            return obj;
        }

        first.next = insertAt(pos, first.next, obj, count++);
        return first;
    }

    void reverse() {
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


class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            Linkedlist ll = new Linkedlist();
            switch (input[0]) {
                case "insertAt":
                try {
                    ll.insertAt(Integer.parseInt(input[1]), input[2]);
                    System.out.println(ll);;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "reverse":
                ll.reverse();
                break;
                default:
                break;
            }
        }
    }
}