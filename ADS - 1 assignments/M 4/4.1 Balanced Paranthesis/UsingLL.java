import java.util.Scanner;
import java.util.Arrays;
class Node {
	String data;
	Node next;
}

class Linkedlist {
	private Node start = null;

	void push(final String ch) {
		Node val = start;
		start = new Node();
		start.data = ch;
		start.next = val;
	}

	String pop() {
		if (start == null) {
            return "e";
        }
        String r = start.data;
        start = start.next;
        return r;
	}

	public Node gethead() {
        return start;
    }
}
class Balanced {
    Balanced() {

    }

    boolean Matchingpair (String str1, String str2) {
        if (str1.equals("(") && str2.equals(")")) {
            return true;
        }
        if (str1.equals("[") && str2.equals("]")) {
            return true;
        }
        if (str1.equals("{") && str2.equals("}")) {
            return true;
        }
        return false;
    }

    boolean balancing(final String[] array) {
        Linkedlist ll = new Linkedlist();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("(") || array[i].equals("[") || array[i].equals("{")) {
                ll.push(array[i]);
            }
            if (array[i].equals(")") || array[i].equals("]") || array[i].equals("}")) {
                if (Matchingpair(ll.pop(), array[i])) {
                    continue;
                } else {
                	return false;
                }
            }
        }
        return ll.gethead() == null;
    }
}
class UsingLL {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n != 0) {
            String[] input = sc.nextLine().split("");
            Balanced b = new Balanced();
            if (b.balancing(input)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            n--;
        }
    }
}