import java.util.Scanner;
import java.util.Arrays;


class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue qu = new Queue();
        int n = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            switch(input[0]) {
                case "pushLeft":
                qu.addfront(Integer.parseInt(input[1]));
                System.out.println(qu.print());
                break;
                case "pushRight":
                qu.addend(Integer.parseInt(input[1]));
                System.out.println(qu.print());
                break;
                case "popLeft":
                if (!qu.isEmpty()) {
                    qu.removefront();
                    System.out.println(qu.print());
                } else {
                    System.out.println("Deck is empty");
                }
                break;
                case "popRight":
                if (!qu.isEmpty()) {
                    qu.removeend();
                    System.out.println(qu.print());
                } else {
                    System.out.println("Deck is empty");
                }
                break;
                case "size":
                System.out.println(qu.size());
                break;
                default:
                break;
            }
        }
    }
}