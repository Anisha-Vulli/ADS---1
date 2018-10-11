import java.util.*;
class Book implements Comparable<Book>{
    String name;
    String author;
    String price;
    Book(String name, String author, String price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    String getName() {
        return name;
    }

    String getAuthor() {
        return author;
    }

    String getPrice() {
        return price;
    }

    public int compareTo(Book that) {
        return this.name.compareTo(that.name);
    }
}

class BinarySearchTree {
    private Node root;
    int size;

    private class Node {
        Book key;
        String value;
        Node left;
        Node right;
        Node(Book key, String value) {
            this.key = key;
            this.value =value;
        }
    }
    BinarySearchTree() {
        root = null;
    }

    public void put(Book key, String value) {
        root = put(root, key, value);
    }

    public Node put(Node x, Book key, String value) {
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

class Solution {
    public static void main(String[] args) {
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