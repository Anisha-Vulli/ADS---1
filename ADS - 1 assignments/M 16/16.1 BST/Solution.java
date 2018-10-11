/**
 * Scanner import.
 */
import java.util.Scanner;
/**
 * Class for book.
 */
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
     * @param      name    The name
     * @param      author  The author
     * @param      price   The price
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
    String getPrice() {
        return price;
    }
    /**
     * Compares the name of the books.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(Book that) {
        return this.name.compareTo(that.name);
    }
}

/**
 * Class for binary search tree.
 */

class BinarySearchTree {
    /**
     * Node named root.
     */
    private Node root;
    /**
     * Size integer.
     */
    int size;
    /**
     * Class for node.
     */
    private class Node {
        Book key;
        String value;
        Node left;
        Node right;
        Node(final Book key, final String value) {
            this.key = key;
            this.value =value;
        }
    }
    /**
     * Constructs the object.
     */
    BinarySearchTree() {
        root = null;
    }
    /**
     * Put method for putting value.
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Book key, final String value) {
        root = put(root, key, value);
    }

    /**
     * Put the value into the search tree.
     * Complexity is log N.
     *
     * @param      x      { parameter_description }
     * @param      key    The key
     * @param      value  The value
     *
     * @return     { description_of_the_return_value }
     */
    public Node put(final Node x, final Book key, final String value) {
        if (x == null) {
            return new Node(key, value);
        }

        int cmp = key.getName().compareTo(x.key.getName());
        //System.out.println(cmp);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        }

        else if (cmp > 0) {
            x.right = put(x.right, key, value);
        }
       else if (cmp == 0) {
            x.value = value;
        }
        return x;
    }

    /**
     * Get method gets the particular key from the search tree.
     * Complexity is log N.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public String get(Book key) {
        Node x = root;

        while (x != null) {
            int cmp = key.getName().compareTo(x.key.getName());
            //System.out.println(x.key.getName());
            if (cmp < 0) {
                x = x.left;
            } 
            else if (cmp > 0) {
                x = x.right;
            } 
            else if (cmp == 0) {
                return x.value;
            }
        }
        return null;
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
        while(sc.hasNextLine()) {
            String[] input = sc.nextLine().split(",");
            switch(input[0]) {
            case "put":
            Book book = new Book(input[1], input[2], input[3]);
            bst.put(book, input[4]);
            break;
            case "get":
            book = new Book(input[1], input[2], input[3]);
            System.out.println(bst.get(book));
            break;
            default:
            break;
        }
        }
    }
}

