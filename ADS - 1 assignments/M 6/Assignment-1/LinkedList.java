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
        //size--;
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
            //strng = strng + input.pop();
        }
        //System.out.println(strng);
        //System.out.println(Arrays.toString(number));
        return input;

    }

    public static String digitsToNumber(LinkedList list) {
        
        String strng = "";
        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.pop());
            strng = list.pop() + strng;
        }
        //strng = list.toString();
        return strng;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        //System.out.println(list1.toString());
        int val1 = 0;
        int val2 = 0;
        int result = 0;
        LinkedList resultlist = new LinkedList();
        String strng1 = "";
        for (int i = 0; i < list1.size(); i++) {
            strng1 = list1.pop() + strng1;
        }

        String strng2 = "";
        for (int i = 0; i < list2.size(); i++) {
            strng2 = list2.pop() + strng2;
        }

        String[] array1 = strng1.split("");
        String[] array2 = strng2.split("");
        //System.out.println(Arrays.toString(array1));
        // int digit = 0;
        // int poppedval = 0;
        // for (int i = 0; i < array1.length; i++) {
        //     //System.out.println(array1[i]);
        //     result = Integer.parseInt(array1[i]) + Integer.parseInt(array2[i]);
        //     if (result < 9 && result > 0) {
        //         resultlist.push(String.valueOf(result));
        //     } else {
        //         digit = result % 10;
        //         result = result / 10;
        //         resultlist.push(String.valueOf(digit));
        //         resultlist.push(String.valueOf(result));
        //         //poppedval = Integer.parseInt(resultlist.pop()); 
        //     }
        // }
        //System.out.println(result);
        //System.out.println(resultlist.toString());
        
        val1 = Integer.parseInt(strng1);
        val2 = Integer.parseInt(strng2);
        //System.out.println(val1);
        result = val1 + val2;
        resultlist.push(String.valueOf(result));

        // while (!(list1.isEmpty() && list2.isEmpty())) {
        //     val1 = Integer.parseInt(strng1);
        //     System.out.println(val1);
        //     val2 = Integer.parseInt(strng2);
        //     result = val1 + val2;
        //     System.out.println(result);
        // }
        return resultlist;
    }
}