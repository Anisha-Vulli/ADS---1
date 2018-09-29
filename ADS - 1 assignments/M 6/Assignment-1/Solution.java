import java.util.Scanner;
import java.util.Arrays;
// class Node {
//     String data;
//     Node next;

//     Node() {

//     }

//     Node(String item) {
//         this.data = item;
//     }

// }

// class LinkedList {
//     Node start = new Node();
//     int size;
//     LinkedList() {
//         size = 0;
//     }

//     void push(String item) {
//         //System.out.println("bello");
//         Node obj = new Node();
//         if (size == 0) {
//             start.data = item;
//             //System.out.println(start.data);
//             size++;
//             return; 
//         }
//         //start = obj.next;
//         obj.next = start;
//         start.data = item;
//         start = obj;
//     }

//     String pop() {
//         String item = start.data;
//         start = start.next;
//         size--;
//         return item;
//     }

//     boolean isEmpty() {
//         if (size == 0) {
//             return true;
//         } else {
//             return false;
//         }
//     }

//     public String toString() {
//         //Node temp = new Node();
//         String str = "";
//         if (size == 0) {
//             //System.out.println("Bello");
//             str = start.data;
//             return str;
//         } else {
//             Node temp = start;
//             while (temp != null) {
//                 str = str + temp.data;
//                 temp = temp.next;
//             }
//             // for (Node temp = start; temp != null; temp = temp.next) {
//             //     str = str + temp.data;
//             //     temp = temp.next;   
//             // }
            
//         }
//         return str;
//     }
// }
/**
 * Class for node.
 */
class Node {
    /**
     * Data in string.
     */
    String data;
    /**
     * Next node.
     */
    Node next;
}

/**
 * Class for linkedlist.
 */
class LinkedList {
    /**
     * An empty node.
     */
    private Node start = null;
    int size;

    LinkedList() {
        size = 0;
    }
    /**
     * Pushing an element into list.
     *
     * @param      ch    { given String }
     */
    void push(final String ch) {
        Node val = start;
        start = new Node();
        start.data = ch;
        start.next = val;
        size++;
    }
    /**
     * Popping element from list.
     *
     * @return     { String value }
     */
    String pop() {
        if (start == null) {
            return "e";
        }
        String r = start.data;
        start = start.next;
        size--;
        return r;
    }
    /**
     * First value.
     *
     * @return     { value }
     */
    public Node gethead() {
        return start;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        //Node temp = new Node();
        String str = "";
        if (size == 0) {
            //System.out.println("Bello");
            str = start.data;
            return str;
        } else {
            Node temp = start;
            while (temp != null) {
                str = str + temp.data;
                temp = temp.next;
            }
            // for (Node temp = start; temp != null; temp = temp.next) {
            //     str = str + temp.data;
            //     temp = temp.next;   
            // }
            
        }
        return str;
    }
}
class AddLargeNumbers {
    static LinkedList input1 = new LinkedList();
    
    public static LinkedList numberToDigits(String number1) {
        LinkedList input = new LinkedList();
        String[] number = number1.split("");
        String strng = "";
        for (int i = 0; i < number.length; i++) {
            input.push(number[i]);
            strng = strng + input.pop();
        }
        //System.out.println(strng);
        //System.out.println(Arrays.toString(number));
        return input;

    }

    public static String digitsToNumber(LinkedList list) {
        
        String strng = "";
        for (int i = 0; i < list.size(); i++) {
            strng = strng + list.pop();
        }
        //strng = list.toString();
        return strng;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        int val1 = 0;
        int val2 = 0;
        int result = 0;
        while (!(list1.isEmpty() && list2.isEmpty())) {
            val1 = Integer.parseInt(list1.pop());
            val2 = Integer.parseInt(list2.pop());
            result = val1 + val2;
            System.out.println(result);
        }
        return input1;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
