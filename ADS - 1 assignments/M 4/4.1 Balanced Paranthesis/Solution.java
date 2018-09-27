import java.util.Scanner;
import java.util.Arrays;

class Stackprob {
    private String[] stackarr;
    private int size;
    Stackprob() {
        stackarr = new String[10];
        size = size;
    }

    int size() {
        return size;
    }

    void push (String item) {
        try {
            stackarr[size++] = item;
        } catch (Exception e) {
            resize();
        }
    }

    void resize() {
        stackarr = Arrays.copyOf(stackarr, 2 * size);
    }

    String pop() {
        String s = stackarr[--size];
        stackarr[size] = null;
        return s;
    }

    boolean isEmpty() {
        if (size == 0) {
            return true;    
        }
        return false;
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
        Stackprob stk = new Stackprob();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("(") || array[i].equals("[") || array[i].equals("{")) {
                stk.push(array[i]);
            }
            if (array[i].equals(")") || array[i].equals("]") || array[i].equals("}")) {
                if (stk.isEmpty()) {
                    return false;
                }
                if (!Matchingpair(stk.pop(), array[i])) {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}

class Solution {
    Solution() {

    }

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