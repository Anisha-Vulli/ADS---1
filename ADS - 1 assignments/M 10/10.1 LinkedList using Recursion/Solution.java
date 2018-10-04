import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         Linkedlist ll = new Linkedlist();
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            switch (input[0]) {
                case "insertAt":
                try {
                    ll.insertAt(Integer.parseInt(input[1]), input[2]);
                    System.out.println(ll);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "reverse":
                try {
                    ll.reverse();
                    System.out.println(ll);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                default:
                break;
            }
        }
    }
}