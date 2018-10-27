/**
 * Scanner import.
 */
import java.util.*;

/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    /**
     * Student name.
     */
    private String name;
    /**
     * Student rollno.
     */
    private int rollno;
    /**
     * Student marks.
     */
    private Double marks;
    /**
     * Constructs the object.
     *
     * @param      rollno1  The rollno 1
     * @param      name1    The name 1
     * @param      marks1   The marks 1
     */
    Student(final int rollno1,
        final String name1, final Double marks1) {
        this.name = name1;
        this.marks = marks1;
        this.rollno = rollno1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets rollnumber.
     *
     * @return     { description_of_the_return_value }
     */
    public int getnum() {
     return this.rollno;
    }
    /**
     * Gets marks.
     *
     * @return     { description_of_the_return_value }
     */
    public Double getmarks() {
        return this.marks;
    }

    /**
     * Compares the marks of students.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Student that) {
        return this.marks.compareTo(that.marks);
    }
}


// /**
//  * Class for node.
//  */
// class Node {
//     /**
//      * Keys in Student format.
//      */
//     private Student key;
//     /**
//      * Values in a string.
//      */
//     private int value;
//     /**
//      * Left and right nodes.
//      */
//     private Node left, right;
//     /**
//      * Count of the insertions for each and every node.
//      */
//     private int count;
//     /**
//      * Constructs the object.
//      *
//      * @param      book  The book
//      * @param      val   The value
//      * @param      cnt   The count
//      */
//     Node(final Student book, final int val, final int cnt) {
//         this.key = book;
//         this.value = val;
//         this.count = cnt;
//     }
//     /**
//      * Gets the key.
//      *
//      * @return     The key.
//      */
//     public Student getKey() {
//         return key;
//     }
//     /**
//      * Gets the value.
//      *
//      * @return     The value.
//      */
//     public int getValue() {
//         return value;
//     }
//     /**
//      * Gets the count.
//      *
//      * @return     The count.
//      */
//     public int getCount() {
//         return count;
//     }
//     /**
//      * Gets the left.
//      *
//      * @return     The left.
//      */
//     public Node getLeft() {
//         return left;
//     }
//     /**
//      * Gets the right.
//      *
//      * @return     The right.
//      */
//     public Node getRight() {
//         return right;
//     }
//     /**
//      * Sets the left.
//      *
//      * @param      l     { parameter_description }
//      */
//     public void setLeft(final Node l) {
//         this.left = l;
//     }
//     /**
//      * Sets the right.
//      *
//      * @param      r     { parameter_description }
//      */
//     public void setRight(final Node r) {
//         this.right = r;
//     }
//     /**
//      * Sets the count.
//      *
//      * @param      c     { parameter_description }
//      */
//     public void setCount(final int c) {
//         this.count = c;
//     }
//     /**
//      * Sets the value.
//      *
//      * @param      val   The value
//      */
//     public void setValue(final int val) {
//         this.value = val;
//     }
// }

// /**
//  * Class for binary search tree.
//  */
// class BinarySearchTree {
//     /**
//      * Root node.
//      */
//     private Node root;
//     /**
//      * Constructs the object.
//      */
//     BinarySearchTree() {
//     }
//     /**
//      * Determines if empty.
//      *
//      * @return     True if empty, False otherwise.
//      */
//     public boolean isEmpty() {
//         return count() == 0;
//     }
//     /**
//      * Count of the value of the key.
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public int count() {
//         return count(root);
//     }
//     /**
//      * Count of the number of nodes under a particular node.
//      *
//      * @param      n     { parameter_description }
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public int count(final Node n) {
//         if (n == null) {
//             return 0;
//         } else {
//             return n.getCount();
//         }
//     }
//     /**
//      * Checks if the given node is present or not.
//      *
//      * @param      key   The key
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public boolean contains(final Student key) {
//         return get(key) != 0;
//     }
//     /**
//      * Puts the value according to specific order.
//      *
//      * @param      key   The key
//      * @param      val   The value
//      */
//     public void put(final Student key, final Integer val) {
//         root = put(root, key, val);
//     }
//     /**
//      * Puts the node in its place.
//      * The complexity is N.
//      *
//      * @param      x     { parameter_description }
//      * @param      key   The key
//      * @param      val   The value
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public Node put(final Node x, final Student key, final Integer val) {
//         if (x == null) {
//             return new Node(key, val, 1);
//         }

//         int comp = key.getName().compareTo(x.getKey().getName());
//         if (comp < 0) {
//             x.setLeft(put(x.getLeft(), key, val));
//         }

//         if (comp > 0) {
//             x.setRight(put(x.getRight(), key, val));
//         }

//         if (comp == 0) {
//             x.setValue(val);
//         }

//         x.setCount(1 + count(x.getLeft()) + count(x.getRight()));
//         return x;
//     }
//     /**
//      * Gets the rank of the particular node.
//      * Complexity is N.
//      *
//      * @param      key   The key
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public int get(final Student key) {
//         Node x = root;
//         while (x != null) {
//             int comp = key.getName().compareTo(x.getKey().getName());
//             if (comp > 0) {
//                 x = x.getRight();
//             }

//             if (comp < 0) {
//                 x = x.getLeft();
//             }

//             if (comp == 0) {
//                 return x.getValue();
//             }
//         }

//         return 0;
//     }
//     /**
//      * Returns the minimum value.
//      * Complexity is 1.
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public Student min() {
//         return min(root).getKey();
//     }
//     /**
//      * Returns the min value.
//      * Complexity is 1.
//      *
//      * @param      x     { parameter_description }
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public Node min(final Node x) {
//         if (x.getLeft() == null) {
//             return x;
//         } else {
//             return min(x.getLeft());
//         }
//     }
//     /**
//      * Returns the max value.
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public Student max() {
//         return max(root).getKey();
//     }
//     /**
//      * Returns the maximium value.
//      * Complexity is N.
//      *
//      * @param      x     { parameter_description }
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public Node max(final Node x) {
//         if (x.getRight() == null) {
//             return x;
//         } else {
//             return max(x.getRight());
//         }
//     }
//     /**
//      * Returns the least nearest value of the given node.
//      * Complexity is N.
//      *
//      * @param      key   The key
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public Student floor(final Student key) {
//         Node x = floor(root, key);
//         if (x == null) {
//             return null;
//         } else {
//             return x.getKey();
//         }
//     }
//     /**
//      * Returns the least nearest value of the given node.
//      * Complexity is N.
//      *
//      * @param      x     { parameter_description }
//      * @param      key   The key
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public Node floor(final Node x, final Student key) {
//         if (x == null) {
//             return null;
//         }
//         int cmp = key.compareTo(x.getKey());
//         if (cmp == 0) {
//             return x;
//         }

//         if (cmp < 0) {
//             return floor(x.getLeft(), key);
//         }

//         Node t = floor(x.getRight(), key);

//         if (t != null) {
//             return t;
//         } else {
//             return x;
//         }
//     }
//     /**
//      * Returns the nearest highest value of the given node.
//      * Complexity is N.
//      *
//      * @param      key   The key
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public Student ceiling(final Student key) {
//         Node x = ceiling(root, key);
//         if (x == null) {
//             return null;
//         } else {
//             return x.getKey();
//         }
//     }
//     /**
//      * Returns the nearest highest value of the given node.
//      * Complexity is N.
//      *
//      * @param      x     { parameter_description }
//      * @param      key   The key
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public Node ceiling(final Node x, final Student key) {
//         if (x == null) {
//             return null;
//         }
//         int cmp = key.compareTo(x.getKey());
//         if (cmp == 0) {
//             return x;
//         }

//         if (cmp < 0) {
//             Node t = ceiling(x.getLeft(), key);
//             if (t != null) {
//                 return t;
//             } else {
//                 return x;
//             }
//         }
//         return ceiling(x.getRight(), key);
//     }
//     /**
//      * Select gives the key n the particlar index.
//      * Complexity is N.
//      *
//      * @param      k     { parameter_description }
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public Student select(final int k) {
//         Node x = select(root, k);
//         return x.getKey();
//     }
//     /**
//      * Select gives the key n the particlar index.
//      * Complexity is N.
//      *
//      *
//      * @param      x     { parameter_description }
//      * @param      k     { parameter_description }
//      *
//      * @return     { description_of_the_return_value }
//      */
//     private Node select(final Node x, final int k) {
//         if (x == null) {
//             return null;
//         }
//         int t = count(x.getLeft());
//         if (t > k) {
//             return select(x.getLeft(),  k);
//         }
//         if (t < k) {
//             return select(x.getRight(), k - t - 1);
//         }
//         if (t == k) {
//             return x;
//         }
//         return x;
//     }
//     /**
//      * Delete Min.
//      */
//     public void deleteMin() {
//         root = deleteMin(root);
//     }
//     /**
//      * Delete min value.
//      * Complexity of deletion is N.
//      *
//      * @param      x     { parameter_description }
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public Node deleteMin(final Node x) {
//         if (x.getLeft() == null) {
//             return x.getRight();
//         }
//         x.setLeft(deleteMin(x.getLeft()));
//         x.setCount(count(x.getLeft()) + count(x.getRight()) + 1);
//         return x;
//     }
//     /**
//      * Deletion of max.
//      */
//     public void deleteMax() {
//         root = deleteMax(root);
//     }
//     /**
//      * Deletion of max.
//      * Complexity is N in worst case condition.
//      *
//      * @param      x     { parameter_description }
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public Node deleteMax(final Node x) {
//         if (x.getRight() == null) {
//             return x.getLeft();
//         }
//         x.setRight(deleteMax(x.getRight()));
//         x.setCount(count(x.getLeft()) + count(x.getRight()) + 1);
//         return x;
//     }
//     /**
//      * Deletion of a particular key.
//      *
//      * @param      key   The key
//      */
//     public void delete(final Student key) {
//         root = delete(root, key);
//     }
//     /**
//      * Deletion of a particular key.
//      * Complexity is N.
//      *
//      * @param      x     { parameter_description }
//      * @param      key   The key
//      *
//      * @return     { description_of_the_return_value }
//      */
//     private Node delete(final Node x, final Student key) {
//         Node node = x;
//         if (node == null) {
//             return null;
//         }
//         int cmp = key.compareTo(x.getKey());
//         if (cmp < 0) {
//             x.setLeft(delete(x.getLeft(),  key));
//         } else if (cmp > 0) {
//             x.setRight(delete(x.getRight(), key));
//         } else {
//             if (x.getRight() == null) {
//                 return x.getLeft();
//             }
//             if (x.getLeft()  == null) {
//                 return x.getRight();
//             }
//             Node t = x;
//             node = min(t.getRight());
//             x.setRight(deleteMin(t.getRight()));
//             x.setLeft(t.getLeft());
//         }
//         x.setCount(count(x.getLeft()) + count(x.getRight()) + 1);
//         return node;
//     }

//     public ArrayList<Student> keys() {
//        return keys(min(), max());
//     }

//     public ArrayList<Student> keys(Student low, Student high) {
//         ArrayList<Student> list = new ArrayList<Student>();
//         keys(root, list, low, high);
//         return list;
//     }

//     private void keys(Node x, ArrayList<Student> list, Student low, Student high) {
//         if (x == null) {
//             return;
//         }
//         int cmplow = low.compareTo(x.getKey());
//         int cmphigh = high.compareTo(x.getKey());
//         if (cmplow < 0) {
//             keys(x.getLeft(), list, low, high);
//         }
//         if (cmplow <= 0 && cmphigh >= 0) {
//             list.add(x.getKey());
//         }
//         if (cmphigh > 0) {
//             keys(x.getRight(), list, low, high);
//         }
//     }
// }

/**
 * class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int noinputs = Integer.parseInt(sc.nextLine());
        BST<Student, Integer> bst = new BST<Student, Integer>();
        Student stu = null;
        for (int i = 0; i < noinputs; i++) {
            String[] input = sc.nextLine().split(",");
            stu = new Student(Integer.parseInt(input[0]),
                input[1], Double.parseDouble(input[2]));
            bst.put(stu, Integer.parseInt(input[0]));
        }
        int num = Integer.parseInt(sc.nextLine());
        for (int j = 0; j < num; j++) {
            String[] tokens = sc.nextLine().split(" ");
            if (tokens[0].equals("BE")) {
                double less = Double.parseDouble(tokens[1]);
                double greater = Double.parseDouble(tokens[2]); 
                for (Student each : bst.keys()) {
                    if (each.getmarks() >= less && each.getmarks() <= greater) {
                        System.out.println(each.getName());
                    }
                }
            } else if (tokens[0].equals("LE")) {
                double value = Double.parseDouble(tokens[1]);
                for (Student each : bst.keys()) {
                    if (each.getmarks() <= value) {
                        System.out.println(each.getName());
                    }
                }
            } else if (tokens[0].equals("GE")) {
                double value = Double.parseDouble(tokens[1]);
                for (Student each : bst.keys()) {
                    if (each.getmarks() >= value) {
                        System.out.println(each.getName());
                    }
                }
            }
        }
    }
}