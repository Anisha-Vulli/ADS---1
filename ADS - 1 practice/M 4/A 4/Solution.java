import java.util.Scanner;
import java.util.Arrays;
class Stackprob {
    private String[] stackarr;
    private int size;
    Stackprob() {
        stackarr = new String[10];
        size = 0;
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

    String pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty stack");
        } else {
            String s = stackarr[--size];
            stackarr[size] = null;
            return s;
        }
    }

    boolean isEmpty() {
        if (size == 0) {
            return true;    
        }
        return false;
    }
}

public class Solution {
    public static void main(String[] args) {
        Stackprob stck = new Stackprob();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (str.equals("-")) {
                try {
                    System.out.println(stck.pop());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                stck.push(str);
            }
        }
    }
}