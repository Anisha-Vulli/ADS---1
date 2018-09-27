class Stackprob {
    private String[] stackarr;
    private int size;
    Stackprob() {
        stackarr = new String[10];
        size = 0;
    }

    void push (String item) {
        stackarr[size++] = item;
    }

    String pop() throws Exception {
        if (isEmpty) {
            throw Exception("Empty stack");
        } else {
            return stackarr[--size];
        }
    }

    boolean isEmpty() {
        if (size == 0) {
            return true;    
        }
        return false;
    }
}

class Solution {
    Stackprob stck = new Stackprob();
    public static void main(String[] args) {
        StackOfStrings stack = new StackOfStrings();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (str.equals("-")) {
                try {
                    System.out.println(stck.pop());
                } catch (Exception e) {
                    System.out.println(e.getmessage());
                }
            } else {
                stck.push(str);
            }
        }
    }
}