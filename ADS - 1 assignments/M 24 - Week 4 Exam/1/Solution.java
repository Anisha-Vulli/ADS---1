import java.util.*;
class Student {
    private String name;
    private int rollno;
    private Double marks;
    Student(int rollno1, String name1, Double marks1) {
        this.name = name1;
        this.marks = marks1;
        this.rollno = rollno1;
    }

    public String getName() {
        return this.name;
    }

    public int getnum() {
     return this.rollno;
    }

    public Double getmarks() {
        return this.marks;
    }
}

/**
 * Class for separate chaining hash st.
 */
class SeparateChainingHashST {
    /**
     * Capacity of the symbol table.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * // number of key-value pairs.
     */
    private int n;
    /**
     * // hash table size.
     */
    private int m;
    /**
     * // array of linked-list symbol tables.
     */
    private SequentialSearchST<Integer, Student>[] st;
    /**
     * Initializes an empty symbol table.
     */
    SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Constructs the object.
     *
     * @param      m1    The m 1
     */
    SeparateChainingHashST(final int m1) {
        this.m = m1;
        st = (SequentialSearchST<Integer, Student>[]) new SequentialSearchST[m1];
        for (int i = 0; i < m1; i++) {
            st[i] = new SequentialSearchST<Integer, Student>();
        }
    }

    // resize the hash table to have the given number of chains,
    // // rehashing all of the keys
    // private void resize(int chains) {
    //     SeparateChainingHashST<Key, Value> temp
    //     = new SeparateChainingHashST<Key, Value>(chains);
    //     for (int i = 0; i < m; i++) {
    //         for (Key key : st[i].keys()) {
    //             temp.put(key, st[i].get(key));
    //         }
    //     }
    //     this.m  = temp.m;
    //     this.n  = temp.n;
    //     this.st = temp.st;
    // }

    // hash value between 0 and m-1

    /**
     * Function to generate hash value to given key.
     * Complexity is 1.
     *
     * @param      key   The key
     *
     * @return     { Generated hash value }
     */
    private int hash(final int key) {
        final int data = 0x7fffffff;
        return (key & data) % m;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * Complexity of the function is 1.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     * Complexity is 1.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     * Complexity is 1.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(final int key) {
        //if (key == null)
        //throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * Returns the value associated with the specified key in this symbol table.
     * Complexity is 1.
     *
     * @param  key the key
     * @return the value associated with {@code key} in the symbol table;
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Student get(final int key) {
        //if (key == null)
        //throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    }

    /**
     * Inserts the specified key-value pair into
     * the symbol table,overwriting the old
     * value with the new value if the symbol
     * table already contains the specified key.
     * Deletes the specified key (and its
     * associated value) from this symbol table
     * if the specified value is {@code null}.
     * Complexity is 1.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(final Integer key, final Student val) {
        // if (key == null)
        //throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        // double table size if average length of list >= 10
        // if (n >= 10*m) resize(2*m);

        int i = hash(key);
        if (!st[i].contains(key)) {
            n++;
        }
        st[i].put(key, val);
    }

    /**
     * Removes the specified key and its
     * associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(final int key) {
        //if (key == null)
        //throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) {
            n--;
        }
        st[i].delete(key);
    }
}

final class Solution {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int noinputs = Integer.parseInt(sc.nextLine());
        SeparateChainingHashST st = new SeparateChainingHashST();
        for (int i = 0; i < noinputs; i++) {
            String[] input = sc.nextLine().split(",");
            Student stu = new Student(Integer.parseInt(input[0]), input[1], Double.parseDouble(input[2]));
            st.put(Integer.parseInt(input[0]), stu);
        }
        int num = Integer.parseInt(sc.nextLine());
        for (int j = 0; j < num; j++) {
            String[] tokens = sc.nextLine().split(" ");
            if (tokens[2].equals("1")) {
                 if (st.get(Integer.parseInt(tokens[1])) != null) {
                    System.out.println(st.get(Integer.parseInt(tokens[1])).getName());
                } else {
                    System.out.println("Student doesn't exists...");
                }
            }
            else if (tokens[2].equals("2")) {
                if (st.get(Integer.parseInt(tokens[1])) != null) {
                     System.out.println(st.get(Integer.parseInt(tokens[1])).getmarks());   
                } else {
                    System.out.println("Student doesn't exists...");
                }
            }
        }
    }
}