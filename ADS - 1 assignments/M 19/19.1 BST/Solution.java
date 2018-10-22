import java.util.Scanner;
class Book implements Comparable<Book> {
    /**
     * Name string.
     */
    private String name;
    /**
     * Author of book.
     */
    private String author;
    /**
     * Price of the book.
     */
    private String price;
    /**
     * Constructs the object.
     *
     * @param      name1    The name 1
     * @param      author1  The author 1
     * @param      price1   The price 1
     */
    Book(final String name1, final String author1, final String price1) {
        this.name = name1;
        this.author = author1;
        this.price = price1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    String getName() {
        return name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    String getAuthor() {
        return author;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    Double getPrice() {
        return Double.parseDouble(price);
    }
    /**
     * Compares the name of the books.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Book that) {
        return this.name.compareTo(that.name);
    }

    public String toString() {
        return getName() + ", " + getAuthor() + ", " + getPrice();
    }
}
/**
 * Class for node.
 */
class Node {
    /**
     * Keys in book format.
     */
    private Book key;
    /**
     * Values in a string.
     */
    private String value;
    /**
     * Left and right nodes.
     */
    private Node left, right;
    /**
     * Count of the insertions for each and every node.
     */
    private int count;
    /**
     * Constructs the object.
     *
     * @param      book  The book
     * @param      val   The value
     * @param      cnt   The count
     */
    Node(final Book book, final String val, final int cnt) {
        this.key = book;
        this.value = val;
        this.count = cnt;
    }
    /**
     * Gets the key.
     *
     * @return     The key.
     */
    public Book getKey() {
        return key;
    }
    /**
     * Gets the value.
     *
     * @return     The value.
     */
    public String getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }
    /**
     * Gets the left.
     *
     * @return     The left.
     */
    public Node getLeft() {
        return left;
    }
    /**
     * Gets the right.
     *
     * @return     The right.
     */
    public Node getRight() {
        return right;
    }
    /**
     * Sets the left.
     *
     * @param      l     { parameter_description }
     */
    public void setLeft(final Node l) {
        this.left = l;
    }
    /**
     * Sets the right.
     *
     * @param      r     { parameter_description }
     */
    public void setRight(final Node r) {
        this.right = r;
    }
    /**
     * Sets the count.
     *
     * @param      c     { parameter_description }
     */
    public void setCount(final int c) {
        this.count = c;
    }
    /**
     * Sets the value.
     *
     * @param      val   The value
     */
    public void setValue(final String val) {
        this.value = val;
    }
}
/**
 * Class for binary search tree.
 */
class BinarySearchTree {
    /**
     * Root node.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    BinarySearchTree() {
    }

    public boolean isEmpty() {
        return count() == 0;
    }

    public int count() {
        return count(root);
    }

    public int count(final Node n) {
        if (n == null) {
            return 0;
        } else {
            return n.getCount();
        }
    }

    public boolean contains(final Book key) {
        return get(key) != null;
    }

    public void put(final Book key, final String val) {
        root = put(root, key, val);
    }

    public Node put(Node x, Book key, String val) {
        if (x == null) {
            return new Node(key, val, 1);
        }

        int comp = key.getName().compareTo(x.getKey().getName());
        if (comp < 0) {
            x.setLeft(put(x.getLeft(), key, val));
        }

        if (comp > 0) {
            x.setRight(put(x.getRight(), key, val));
        }

        if (comp == 0) {
            x.setValue(val);
        }

        x.setCount(1 + count(x.getLeft()) + count(x.getRight()));
        return x;
    }

    public String get(final Book key) {
        Node x = root;
        while (x != null) {
            int comp = key.getName().compareTo(x.getKey().getName());
            if (comp > 0) {
                x = x.getRight();
            }

            if (comp < 0) {
                x = x.getLeft();
            }

            if (comp == 0) {
                return x.getValue();
            }
        }

        return null;
    }

    public Book min() {
        return min(root).getKey();
    }

    public Node min(Node x) {
        if (x.getLeft() == null) {
            return x;
        } else {
            return min(x.getLeft());
        }
    }

    public Book max() {
        return max(root).getKey();
    }

    public Node max(Node x) {
        if (x.getRight() == null) {
            return x;
        } else {
            return max(x.getRight());
        }
    }

    public Book floor(Book key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.getKey();
        }
    }

    public Node floor(Node x, Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.getKey());
        if (cmp == 0) {
            return x;
        }

        if (cmp < 0) {
            return floor(x.getLeft(), key);
        }

        Node t = floor(x.getRight(), key);

        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    public Book ceiling(Book key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.getKey();
        }
    }

    public Node ceiling(Node x, Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.getKey());
        if (cmp == 0) {
            return x;
        }

        if (cmp < 0) {
            Node t = ceiling(x.getLeft(), key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.getRight(), key);
    }

    public Book select(int k) {
        Node x = select(root, k);
        return x.getKey();
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        //System.out.println(x.toString());
        int t = count(x.getLeft());
        //System.out.println(t);
        if (t > k) {
            return select(x.getLeft(),  k);
        } 
        if (t < k) {
            return select(x.getRight(), k - t - 1); 
        }
        if(t==k)
            return x;
        return x;
    }    
}

/**
 * Class for solution.
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
        BinarySearchTree bst = new BinarySearchTree();
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(",");
            switch (input[0]) {
                case "put":
                Book book = new Book(input[1], input[2], input[2 + 1]);
                bst.put(book, input[2 + 2]);
                break;
                case "get":
                book = new Book(input[1], input[2], input[2 + 1]);
                System.out.println(bst.get(book));
                break;
                case "max":
                System.out.println(bst.max());
                break;
                case "min":
                System.out.println(bst.min());
                break;
                case "select":
                System.out.println(bst.select(Integer.parseInt(input[1])));
                break;
                case "floor":
                book = new Book(input[1], input[2], input[2 + 1]);
                System.out.println(bst.floor(book));
                break;
                case "ceiling":
                book = new Book(input[1], input[2], input[2 + 1]);
                System.out.println(bst.ceiling(book));
                break;
                default:
                break;
            }
        }
    }
}